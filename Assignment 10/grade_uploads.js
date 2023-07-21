const fs = require("node:fs");
const cp = require("node:child_process");
const path = require("node:path");

const graderPath = path.join(__dirname, "grader.js");
// iterate through all the folders in "latest-uploads"
const latestUploadsPath = path.join(__dirname, "latest-uploads");
const latestUploads = fs.readdirSync(latestUploadsPath, { withFileTypes: true });
const grades = {};
for (let i = latestUploads.length - 4; i < latestUploads.length-1; i++) {
    let upload = latestUploads[i];
    let name = upload.name;
    console.log(name.split('-')[0])
    const filePath = path.join(latestUploadsPath, name);
    const classList = JSON.parse(fs.readFileSync(path.join(filePath, "classes.json")));
    fs.copyFileSync(graderPath, path.join(filePath, "grader.js"));
    try{
        cp.execSync('javac ' + Object.values(classList).map(el => el + '.java').join(' '), {cwd: path.join(filePath, "assignment10")});
        cp.execSync('javac -cp .:assignment10 Grader.java', {cwd: filePath});
        let grade = cp.execSync(`node grader.js ${classList.runner} ${classList.parent} ${classList.child}`, {cwd: filePath}).toString();
        grades[name.split('-')[0]] = grade.trim();
    } catch (e){
        grades[name.split('-')[0]] = "error";
    }
    console.log(grades[name.split('-')[0]]);
}
fs.writeFileSync("latest-grades.json", JSON.stringify(grades, null, 4));
