const cp = require("node:child_process");
const fs = require("node:fs");
const cluster = require("node:cluster");
const { availableParallelism } = require("node:os");
const express = require('express');
const multiparty = require('multiparty');

const app = express();
const port = 3000;
const numWorkers = availableParallelism() * 2;

const dateFmtOpts = {year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', hour12: false};

let currentGrades = JSON.parse(fs.readFileSync(__dirname + '/grades.json', 'utf8'));
const gradeResTemplate = fs.readFileSync(__dirname + '/html/grading_res.html', 'utf8');
const gradesSummaryTemplate = fs.readFileSync(__dirname + '/html/grades_summary.html', 'utf8');
var errors = [];
var usageLog = {};

function logError(err){
    process.send({type: 'error', data: err.toString()});
}

function saveGrade(name, date, grade, didBonus){
    process.send({type: 'grade', data: {date: `${formatDate(date)} @ ${formatTime(date)}`, name, val: grade, didBonus}});
}

String.format = function(format) {
    var args = Array.prototype.slice.call(arguments, 1);
    return format.replace(/{(\d+)}/g, function(match, number) { 
      return typeof args[number-1] != 'undefined'
        ? args[number-1] 
        : match
      ;
    });
};

function formatDate(date){
	let year = date.getFullYear().toString().substring(2);
	let month = (date.getMonth() + 1).toString().padStart(2, '0');
	let day = date.getDate().toString().padStart(2, '0');
	return String.format('{1}.{2}.{3}', month, day, year);
}

function formatTime(date){
	let hour = date.getHours().toString().padStart(2, '0');
	let min = date.getMinutes().toString().padStart(2, '0');
	return String.format('{1}:{2}', hour, min);
}

function build_summary_html(){
    let str = "";
    let fmt = "<tr><td>{1}</td><td>{2}</td><td>{3}</td><td>{4}</td><td>{5}%</td></tr>";
    for(let name of Object.keys(currentGrades)){
        let obj = currentGrades[name];
        let s = String.format(fmt, obj.date, name, obj.bonus ? "✅" : "❌", obj.grade, Math.round((obj.grade / 10 * 100) * 100) / 100);
        str += s;
    }
    return String.format(gradesSummaryTemplate, str);
}
function build_res_html(grade, total){
    return String.format(gradeResTemplate, ...grade, total, Math.round((total/10 * 100) * 100)/100);
}
function update_grades_json(){
    fs.writeFileSync(__dirname + '/grades.json', JSON.stringify(currentGrades), 'utf8');
}

if(cluster.isPrimary){
    var int = setInterval(update_grades_json, 60 * 60 * 1000);
}

app.use((req, res, next) => {
    // log the request
    process.send({type: 'request', data: process.pid});
    next();
});

app.on('error', (err) => {
    logError(err);
});

app.get('/', (req, res) => res.sendFile(__dirname + '/html/index.html'));
app.get('/css/bootstrap.css', (req, res) => res.sendFile(__dirname + '/node_modules/bootstrap/dist/css/bootstrap.min.css'));
app.get('/js/bootstrap.js', (req, res) => res.sendFile(__dirname + '/node_modules/bootstrap/dist/js/bootstrap.bundle.min.js'));
app.get('/grading-err', (req, res) => res.sendFile(__dirname + '/html/grading_err.html'));
app.post('/grade', (req, res) => {
    let date = new Date();
    let form = new multiparty.Form();
    let files = {};
    let fields = {};
    form.on('part', (part) => {
        if(part.filename){
            let file = "";
            part.on('data', (chunk) => {
                file += chunk;
            });
            part.on('end', () => {
                files[part.name] = {name: part.filename, data: file};
            });
        } else {
            let field = "";
            part.on('data', (chunk) => {
                field += chunk;
            });
            part.on('end', () => {
                fields[part.name] = field;
            });
        }
    });
    form.on('close', () => {
        let parentClass = files.parentClass.name.split('.')[0];
        let childClass = files.childClass.name.split('.')[0];
        let runnerClass = files.runnerClass.name.split('.')[0];
        let name = fields.name;
        let didBonus = fields.bonus !== undefined;
        let folder = __dirname + `/uploads/${name}${`-${formatDate(date)} (${formatTime(date)})`}`;
        if (!fs.existsSync(folder + '/assignment10/')) {
            fs.mkdirSync(folder + '/assignment10/', {recursive: true});
        }
        for(let file of Object.values(files)) {
            // prepend 'package assignment10;' to the top of the file
            file.data = 'package assignment10;\n\n' + file.data;
            // move the file to the uploads folder
            fs.writeFileSync(folder + '/assignment10/' + file.name, file.data);
        }
        // is grader.java in the uploads folder?
        if(!fs.existsSync(folder + '/Grader.java')) {
            // Copy the Grader.java file to the uploads folder
            fs.copyFileSync(__dirname + '/Grader.java', folder + '/Grader.java', 0, logError);
        }
        // is grader.js in the uploads folder?
        if(!fs.existsSync(folder + '/grader.js')) {
            fs.copyFileSync(__dirname + '/grader.js', folder + '/grader.js', 0, logError);
        }
        // compile the uploaded files
        try {
            cp.execSync("javac " + Object.values(files).map(el => el.name).join(' '), {cwd: folder + '/assignment10'}); // Compile all the uploaded files
            cp.execSync("javac -cp .:assignment10 Grader.java", {cwd: folder});
            let grade_obj = JSON.parse(cp.execSync(`node grader.js '${runnerClass}' '${parentClass}' '${childClass}'`, {cwd: folder})); // run the js grading program
            saveGrade(name, date, grade_obj, didBonus);
            let total_pts = 0;
            for(let key of Object.keys(grade_obj)){
                total_pts += grade_obj[key] && 1 || 0;
            }
            res.status(200).send(build_res_html(Object.values(grade_obj).map(e => e && 1 || 0), total_pts, didBonus)).end();
        } catch (e) {
            logError(e.toString());
            res.redirect(500, '/grading-err');
            return;
        }
    });
    form.parse(req);
});

app.get('/grades', (req, res) => res.status(200).send(build_summary_html()).end());

if (cluster.isPrimary){
    currentGrades = JSON.parse(fs.readFileSync(__dirname + '/grades.json', 'utf8'));
    let workers = [];
    console.log(`primary ${process.pid} running`);
    for(let i = 0; i < numWorkers; i++){
        workers.push(cluster.fork());
    }
    cluster.on('message', (w, msg) => {
        if(msg.type == 'grade'){
            let grade_obj = msg.data.val;
            let total_pts = 0;
            for(let key of Object.keys(grade_obj)){
                total_pts += grade_obj[key] && 1 || 0;
            }
            currentGrades[msg.data.name] = {date: msg.data.date, tests: msg.data.val, grade: total_pts, bonus: msg.data.didBonus};
            for (let worker of workers){
                worker.send({type: 'grades', data: currentGrades});
            }
        } else if(msg.type == 'error'){
            errors.push(msg.data);
        } else if (msg.type == 'request'){
            let pid = msg.data;
            if (pid in usageLog){
                usageLog[pid]++;
            } else {
                usageLog[pid] = 1;
            }
        }
    });
} else {
    console.log(`worker ${process.pid} running`);
    process.on('message', msg => {
        if(msg.type == 'grades'){
            currentGrades = msg.data;
        }
    });
    var server = app.listen(port, () => console.log(`App listening on port ${port}!`));
}

function __onExit(){
    if(cluster.isPrimary){
        clearInterval(int);
        fs.writeFileSync(__dirname + '/errors.json', JSON.stringify(errors, '', 2)); 
        fs.writeFileSync(__dirname + '/grades.json', JSON.stringify(currentGrades, '', 2));
        fs.writeFileSync(__dirname + '/usage.json', JSON.stringify(usageLog, '', 2));
    } else {
        server.close();
    }
    process.exit();
}
process.on('SIGINT', __onExit);
process.on('SIGTERM', __onExit);
