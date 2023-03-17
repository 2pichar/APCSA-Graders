const process = require("node:process");
const fs = require("node:fs");
const cp = require("node:child_process");
const args = process.argv.slice(2);

/**
 * Grades the uploaded program to ensure that it contains:
 * 1 Parameterized method
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
    let res = cp.execSync(`java -cp .:assignment10 ${grading_helper} ${cmd} ${cls.join(" ")}`);
    return res;
}

const grading_helper = 'Grader'
const runnerClass = args[0];
const parentClass = args[1];
const childClass = args[2];

const runner_file = fs.readFileSync(`${__dirname}/assignment10/${runnerClass}.java`, 'utf-8');
const parent_file = fs.readFileSync(`${__dirname}/assignment10/${parentClass}.java`, 'utf-8');
const child_file = fs.readFileSync(`${__dirname}/assignment10/${childClass}.java`, 'utf-8');

const runner_code = removeStrings(cleanComments(runner_file));
const parent_code = removeStrings(cleanComments(parent_file));
const child_code = removeStrings(cleanComments(child_file));

// Get all method names
let runnerMethods = JSON.parse(runGrader_java('methods', runnerClass));
let parentMethods = JSON.parse(runGrader_java('methods', parentClass));
let childMethods = JSON.parse(runGrader_java('methods', childClass));

// ========= Grading =========
let grades = {};
// Grade code with java grader
let java_grades = JSON.parse(runGrader_java('grade', parentClass, childClass, runnerClass));
grades = {...grades, ...java_grades};


// Grade code for recursive function existence
let recursive = checkRecursion();
grades = {...grades, recursive};
console.log(grades);



function checkRecursion(){
    let runnerBlocks = getMethodBlocks(runner_code, runnerMethods);
    let parentBlocks = getMethodBlocks(parent_code, parentMethods);
    let childBlocks = getMethodBlocks(child_code, childMethods);

    for(let name of runnerMethods){
      let blockStartInd = runnerBlocks[name].indexOf('{');
      let re = new RegExp(`${name}\\(.*?\\)`, 'g');
      re.lastIndex = blockStartInd;
      if (re.test(runnerBlocks[name])){
        console.log(name);
        return true;
      }
    }
    for(let name of parentMethods){
      let blockStartInd = parentBlocks[name].indexOf('{');
      let re = new RegExp(`${name}\\(.*?\\)`, 'g');
      re.lastIndex = blockStartInd;
      if (re.test(parentBlocks[name])){
        console.log(name);
        return true;
      }
    }
    for(let name of childMethods){
      let blockStartInd = childBlocks[name].indexOf('{');
      let re = new RegExp(`${name}\\(.*?\\)`, 'g');
      re.lastIndex = blockStartInd;
      if (re.test(childBlocks[name])){
        console.log(name);
        return true;
      }
    }
    return false;
}

function cleanComments(code){
  // removes all java comments (/* */, // )from the code 
  return code.replace(/\/\*[\s\S]*?\*\/|([^\\:]|^)\/\/.*$/gm, '');
}

function removeStrings(code){
  // removes all strings from the code
  return code.replace(/".*?"/g, '');
}

function getMethodBlocks(code, methodNames){
  /**
   * Returns an object of method name to method block containing full method definitions
   * @param {string} code - the code to search
   * @param {string[]} methodNames - the names of the methods to search for
   * @returns {object} - an object of method name to method block
   */
  let blocks = {};
  for(let name of methodNames){
    let startRegex = new RegExp(`public( static)?\\s+\\w+\\s+${name}\\s*\\(`);
    let startInd = code.search(startRegex);
    let openBracketInd = code.indexOf('{', startInd);
    if(startInd == -1){
      // method not found
      continue;
    }
    let endInd = findMatchingBracket(code, openBracketInd);
    blocks[name] = code.substring(startInd, endInd+1);
  }
  return blocks;
}

function findMatchingBracket(code, start){
  /* Finds the index of the closing bracket matching the opening bracket at start */
  let bracketDepth = 1;
  for(let i = start+1; i < code.length; i++){
    if(code[i] == '{'){
      bracketDepth++;
    }else if(code[i] == '}'){
      bracketDepth--;
    }
    if(bracketDepth == 0){
      return i;
    }
  }
  return -1;
}