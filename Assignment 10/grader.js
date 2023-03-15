const process = require("node:process");
const fs = require("node:fs");
const cp = require("node:child_proces");
const args = process.argv.slice(2);

/**
 * Grades the uploaded program to ensure that it contains:
 * 1 Parametrized method
 * 1 Class w/ one subclass
 * 1 Array
 * 1 2D Array
 * 1 Recursive method
 * Usage of ArrayList   
 */

String.format = function(format) {
    var args = Array.prototype.slice.call(arguments, 1);
    return format.replace(/{(\d+)}/g, function(match, number) { 
      return typeof args[number-1] != 'undefined'
        ? args[number-1] 
        : match
      ;
    });
};

function runGrader_java(cmd, ...cls){
    let cls_fls = cls.map(e => e + ".java");
    let res = cp.execSync(`java -cp .:assignment10 ${grading_helper} ${cmd} ${cls_fls.join(" ")}`);
    return res;
}

const grading_helper = 'Grader.java'
const runnerClass = args[0];
const parentClass = args[1];
const childClass = args[2];

const runner_file = fs.readFileSync(`${__dirname}/assignment10/${runnerClass}.java`);
const parent_file = fs.readFileSync(`${__dirname}/assignment10/${parentClass}.java`);
const child_file = fs.readFileSync(`${__dirname}/assignment10/${childClass}.java`);

// ========= Grading =========

// Inheritance, Constructors, Overriding
let doesInherit = JSON.parse(runGrader_java('inherit', childClass, parentClass));
let parentHasConstructors = JSON.parse(runGrader_java('constructors', parentClass));
let childHasConstructors = JSON.parse(runGrader_java('constructors', childClass));

// Get all method names
let runnerMethods = JSON.parse(runGrader_java('methods', runnerClass));
let parentMethods = JSON.parse(runGrader_java('methods', parentClass));
let childMethods = JSON.parse(runGrader_java('methods', childClass));


function checkRecursion(){
    
}

