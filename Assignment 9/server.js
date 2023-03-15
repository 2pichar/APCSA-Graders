const cp = require("node:child_process");
const fs = require("node:fs");
const util = require("node:util");
const express = require('express');
const multiparty = require('multiparty');

const app = express();
const port = 3000;

const dateFmtOpts = {year: 'numeric', month: '2-digit', day: '2-digit', hour: '2-digit', minute: '2-digit', hour12: false};

const currentGrades = JSON.parse(fs.readFileSync(__dirname + '/grades.json', 'utf8'));
const gradeResTemplate = fs.readFileSync(__dirname + '/html/grading_res.html', 'utf8');
const gradesSummaryTemplate = fs.readFileSync(__dirname + '/html/grades_summary.html', 'utf8');
var errors = [];

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
    let fmt = `<tr><td>{1}</td><td>{2}</td><td>{3}</td><td>{4}</td><td>{5}</td></tr>`;
    for(let name of Object.keys(currentGrades)){
        let obj = currentGrades[name];
        str += String.format(fmt, obj.date, obj.name, obj.partner, obj.grade, obj.grade_pct);
    }
    return String.format(gradesSummaryTemplate, str);
}
function build_res_html(grade, total){
    return String.format(gradeResTemplate, ...grade, total, total/7 * 100);
}
function update_grades_json(){
    fs.writeFileSync(__dirname + '/grades.json', JSON.stringify(currentGrades), 'utf8');
}

let int = setInterval(update_grades_json, 60 * 60 * 1000);

app.on('error', (err) => {
    errors.push(err.toString());
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
        let grandChildClass = files.grandchildClass.name.split('.')[0];
        let name = fields.name;
        let partner = fields.partnerName;
        let hasPartner = partner != "";
        let folder = __dirname + `/uploads/${name}${hasPartner?'-' + partner:''}${`-${formatDate(date)} (${formatTime(date)})`}`;
        if (!fs.existsSync(folder + '/assignment9/')) {
            fs.mkdirSync(folder + '/assignment9/', {recursive: true});
        }
        for(let file of Object.values(files)) {
            // prepend 'package assignment9;' to the top of the file
            file.data = 'package assignment9;\n\n' + file.data;
            // move the file to the uploads folder
            fs.writeFileSync(folder + '/assignment9/' + file.name, file.data);
        }
        // is grader.java in the uploads folder?
        if(!fs.existsSync(folder + '/Grader.java')) {
            // Copy the Grader.java file to the uploads folder
            fs.copyFileSync(__dirname + '/Grader.java', folder + '/Grader.java', 0, console.error);
        }
        // compile the uploaded files
        try {
            cp.execSync("javac " + Object.values(files).map(el => el.name).join(' '), {cwd: folder + '/assignment9'}); // Compile all the uploaded files
            cp.execSync("javac -cp .:./assignment9 Grader.java", {cwd: folder}); // Compile the Grader.java file
            let result = cp.execSync(`java -cp .:./assignment9 Grader people=${hasPartner ? 2 : 1} ` + parentClass + " " + childClass + " " + grandChildClass, {cwd: folder}).toString();
            let cases = result.replaceAll('assignment9.', '').split('\n\n');
            cases = cases.map(el => {
                el = el.split('?\n')[1];
                el = el.split('\n');
                el = el.filter(el => el != "").map(el => Boolean(el.split(": ")[1]));
                return el;
            });
            let grade = new Array(7).fill(0);
            for(let i = 0; i < cases.length; i++){
                let c = cases[i];
                if (c.every(el => el)) grade[i] = 1;
            }
            let total_pts = grade.reduce((a, b) => a + b);
            if (total_pts > (+currentGrades[name]?.total_pts || 0)){
                currentGrades[name] = {date: date.toLocaleTimeString('en-US', dateFmtOpts) ,name: name, partner: partner, grade: total_pts, grade_pct: total_pts/7 * 100};
            }
            res.status(200).send(build_res_html(grade, total_pts)).end();
        } catch (e) {
            errors.push(e.toString());
            res.redirect(500, '/grading-err');
            return;
        }
    });
    form.parse(req);
});

app.get('/grades', (req, res) => res.status(200).send(build_summary_html()).end());

let server = app.listen(port, () => console.log(`App listening on port ${port}!`));
function __onExit(){
	clearInterval(int);
    server.close();
    fs.writeFileSync(__dirname + '/error.txt', JSON.stringify(errors, '', 2)); 
    fs.writeFileSync(__dirname + '/grades.json', JSON.stringify(currentGrades, '', 2));
    process.exit();
}
process.on('SIGINT', __onExit);
process.on('SIGTERM', __onExit);
