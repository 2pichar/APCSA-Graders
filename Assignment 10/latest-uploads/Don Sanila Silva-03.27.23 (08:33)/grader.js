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
    let res = cp.execSync(`java -cp .:assignment10 ${grading_helper} ${cmd} ${cls.join(" ")}`, {cwd: __dirname}).toString();
    return res;
}

const grading_helper = 'Grader'
const runnerClass = args[0];
const parentClass = args[1];
const childClass = args[2];

console.log(__dirname);
console.log(`runnerClass: ${runnerClass}`);
const runner_file = fs.readFileSync(`${__dirname}/assignment10/${runnerClass}.java`, 'utf-8');
const parent_file = fs.readFileSync(`${__dirname}/assignment10/${parentClass}.java`, 'utf-8');
const child_file = fs.readFileSync(`${__dirname}/assignment10/${childClass}.java`, 'utf-8');

const runner_code = removeStrings(cleanComments(runner_file));
const parent_code = removeStrings(cleanComments(parent_file));
const child_code = removeStrings(cleanComments(child_file));

// Get all method names
const runnerMethods = JSON.parse(runGrader_java('methods', runnerClass));
const parentMethods = JSON.parse(runGrader_java('methods', parentClass));
const childMethods = JSON.parse(runGrader_java('methods', childClass));

const runnerBlocks = getMethodBlocks(runner_code, runnerMethods);
const parentBlocks = getMethodBlocks(parent_code, parentMethods);
const childBlocks = getMethodBlocks(child_code, childMethods);

const runnerFields = JSON.parse(runGrader_java('fields', runnerClass));
const parentFields = JSON.parse(runGrader_java('fields', parentClass));
const childFields = JSON.parse(runGrader_java('fields', childClass));

const runnerArrayFields = getArrayFields(runnerFields);
const parentArrayFields = getArrayFields(parentFields);
const childArrayFields = getArrayFields(childFields);

// ========= Grading =========
let grades = {};
// Grade code with java grader
let java_grades = JSON.parse(runGrader_java('grade', parentClass, childClass, runnerClass));
grades = {...grades, ...java_grades};


try{
  let recursive = checkRecursion();
  let arrayExists = checkArray();
  let twoDArrayExists = check2DArray();
  let arrayListExists = checkArrayList();
  grades = {...grades, recursive, arrayExists, twoDArrayExists, arrayListExists};
  console.log(JSON.stringify(grades));
} catch (e){
  process.exit(1);
}


function checkArray(){
  // Checks for the existence of a java array in any of the method declarations
  let decRe = /(?<type>\w+)(?:(?:(?:(?:\[\] )|(?: \[\]))(?<name>\w+))|(?: (?<oname>\w+)\[\]))(?:(?: *= *(?:(?:new \w+\[\w+\])|(?:\{.+\})))|(?:;(?:.|\s)*(?:(?:\k<name>|\k<oname>) *= *(?:(?:new \w+\[\w+\])|(?:\{.+\})))))/;
  let useReStr = "for(?:\\s*)\\({1} (\\w+)(?:\\s*):(?:\\s*){2}\\)(?:\\s*)\\{(?:.|\\s)+\\1(?:.|\\s)+\\}";
  let arrayName = "";
  // find name of java array in method declaration
  for(let name of runnerMethods){
    let block = runnerBlocks[name].code;
    let match = decRe.exec(block);
    if (match){
      arrayName = match.groups.name || match.groups.oname;
      let useRe = new RegExp(String.format(useReStr, match.groups.type, arrayName));
      if (useRe.test(block)){
        return true;
      }
    }
  }
  for(let name of parentMethods){
    let block = parentBlocks[name].code;
    let match = decRe.exec(block);
    if (match){
      arrayName = match.groups.name || match.groups.oname;
      let useRe = new RegExp(String.format(useReStr, match.groups.type, arrayName));
      if (useRe.test(block)){
        return true;
      }
    }
  }
  for(let name of childMethods){
    let block = childBlocks[name].code;
    let match = decRe.exec(childBlocks[name]);
    eval("");
    if (match){
      arrayName = match.groups.name || match.groups.oname;
      let useRe = new RegExp(String.format(useReStr, match.groups.type, arrayName));
      if (useRe.test(block)){
        return true;
      }
    }
  }

  // check for use of array fields in methods
  for(let name of runnerMethods){
    for(let field of runnerArrayFields.array){
      let useRe = new RegExp(String.format(useReStr, field.type, field.name));
      if (useRe.test(runnerBlocks[name].code)){
        return true;
      }
    }
  }
  for(let name of parentMethods){
    for(let field of parentArrayFields.array){
      let useRe = new RegExp(String.format(useReStr, field.type, field.name));
      if (useRe.test(parentBlocks[name].code)){
        return true;
      }
    }
  }
  for(let name of childMethods){
    for(let field of childArrayFields.array){
      let useRe = new RegExp(String.format(useReStr, field.type, field.name));
      if (useRe.test(childBlocks[name].code)){
        return true;
      }
    }
  }
  
  // check for array parameter usage
  for (let name of runnerMethods){
    let params = runnerBlocks[name].params.array;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useReStr, param.baseType, param.name));
      if (useRe.test(runnerBlocks[name].code)){
        return true;
      }
    }
  }

  for (let name of parentMethods){
    let params = parentBlocks[name].params.array;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useReStr, param.baseType, param.name));
      if (useRe.test(parentBlocks[name].code)){
        return true;
      }
    }
  }

  for (let name of childMethods){
    let params = childBlocks[name].params.array;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useReStr, param.baseType, param.name));
      if (useRe.test(childBlocks[name].code)){
        return true;
      }
    }
  }

  return false;
}

function check2DArray(){
  // TODO: fix 2D array usage checks
  /*let foreachFinder = "for\\({1}\\[\\] (\\w+) : {2}\\)\\{(?:.|\\s)+for\\({1} (\\w+) : \\1\\)\\{(?:.|\\s)+\\2(?:.|\\s)+\\}(?:.|\\s)+\\}"
  let forFinder = "for\\(int (\\w+) = \\d+;\\s*\\1 (?:<|>)=? {2}.length;\\s*\\1.+\\)\\{(?:.|\\s)+\\}";*/
  // Checks for the existence of a java 2D array (type[][]) in any of the method declarations
  let decRe = /(?<type>\w+)(?:(?:(?:(?:\[\]\[\] )|(?: \[\]\[\]))(?<name>\w+))|(?: (?<oname>\w+)\[\]\[\])) *= *.+?;/s;
  let useFinder = "{1}\\[\\w+\\]\\[\\w+\\]";
  let travFinder = "(?:for\\({1}\\[\\] \\w+ : {2}\\)\\s*?\\{)|(?:for\\(int (\\w+) = \\w+;\\s*\\1 (?:<|>)=? .+?;\\s*\\1.+\\)\\s*?\\{)";
  let arrayName = "";
  // find name of java array in method declaration
  for(let name of runnerMethods){
    let block = runnerBlocks[name].code
    let match = decRe.exec(block);
    if (match){
      arrayName = match.groups.name || match.groups.oname;
      let useRegex = new RegExp(String.format(useFinder, arrayName));
      let travRegex = new RegExp(String.format(travFinder, match.groups.type, arrayName));
      let travMatch = travRegex.exec(block);
      if (travMatch){
        let ind = travMatch.index + travMatch[0].length;
        let close = findMatchingBracket(block, ind);
        let sub = block.substring(ind, close + 1);
        if (useRegex.test(sub)){
          return true;
        }
      }
    }
  }
  for(let name of parentMethods){
    let block = parentBlocks[name].code;
    let match = decRe.exec(block);
    if (match){
      arrayName = match.groups.name || match.groups.oname;
      let useRegex = new RegExp(String.format(useFinder, match.groups.type, arrayName));
      let travRegex = new RegExp(String.format(travFinder, match.groups.type, arrayName));
      if (useRegex.test(block) && travRegex.test(block)){
        return true;
      }
    }
  }
  for(let name of childMethods){
    let block = childBlocks[name].code;
    let match = decRe.exec(block);
    if (match){
      arrayName = match.groups.name || match.groups.oname;
      let useRegex = new RegExp(String.format(useFinder, arrayName));
      let travRegex = new RegExp(String.format(travFinder, match.groups.type, arrayName));
      if (useRegex.test(block) && travRegex.test(block)){
        return true;
      }
    }
  }

  for(let field of runnerArrayFields.array2d){
    let useRegex = new RegExp(String.format(useFinder, field.name));
    let travRegex = new RegExp(String.format(travFinder, field.type, field.name));
    for(let name of runnerMethods){
      if (useRegex.test(runnerBlocks[name].code) && travRegex.test(runnerBlocks[name].code)){
        return true;
      }
    }
  }

  for(let field of parentArrayFields.array2d){
    let useRegex = new RegExp(String.format(useFinder, field.name));
    let travRegex = new RegExp(String.format(travFinder, field.type, field.name));
    for(let name of parentMethods){
      if (useRegex.test(parentBlocks[name].code) && travRegex.test(parentBlocks[name].code)){
        return true;
      }
    }
  }

  for (let field of childArrayFields.array2d){
    let useRegex = new RegExp(String.format(useFinder, field.name));
    let travRegex = new RegExp(String.format(travFinder, field.type, field.name));
    for(let name of childMethods){
      if (useRegex.test(childBlocks[name].code) && travRegex.test(childBlocks[name].code)){
        return true;
      }
    }
  }

  // check for 2D array parameter usage
  for (let name of runnerMethods){
    let params = runnerBlocks[name].params.array2D;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useFinder, param.name));
      let travRe = new RegExp(String.format(travFinder, param.baseType, param.name));
      if (useRe.test(runnerBlocks[name].code) && travRe.test(runnerBlocks[name].code)){
        return true;
      }
    }
  }

  for (let name of parentMethods){
    let params = parentBlocks[name].params.array2D;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useFinder, param.name));
      let travRe = new RegExp(String.format(travFinder, param.baseType, param.name));
      if (useRe.test(parentBlocks[name].code) && travRe.test(parentBlocks[name].code)){
        return true;
      }
    }
  }

  for (let name of childMethods){
    let params = childBlocks[name].params.array2D;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useFinder, param.name));
      let travRe = new RegExp(String.format(travFinder, param.baseType, param.name));
      if (useRe.test(childBlocks[name].code) && travRe.test(childBlocks[name].code)){
        return true;
      }
    }
  }

  return false;
}

function checkArrayList(){
  // Checks for the existence of a java ArrayList in any of the method declarations
  let decRe = /(?<type>ArrayList\<\w+\>)(?: (?<name>\w+))(?:(?: *= *new ArrayList<.*?>\(\))|(?:;(?:.|\s)+\k<name> *= *new ArrayList<.*?>\(\)));/;
  let useFinder = "{1}\\.get\\(\\w+\\)";
  // check for ArrayList traversal in a normal for loop
  let travFinder = /for *\( *int (\w+) *= *\d+; *\1 *(?:<|>)(?:=?) *.+?; *\1.+?\) *(\{[^]+?\})/g;
  let arrayName = "";
  // find name of ArrayList in method declaration
  for(let name of runnerMethods){
    let match = decRe.exec(runnerBlocks[name].code);
    if (match){
      arrayName = match.groups.name;
      let useRegex = new RegExp(String.format(useFinder, arrayName));
      let travRegex = new RegExp(travFinder);
      let forLoops = [...(runnerBlocks[name].code).matchAll(travRegex)];
      for (let loop of forLoops){
        if(useRegex.test(loop[2])){
          return true;
        }
      }
    }
  }
  for(let name of parentMethods){
    let match = decRe.exec(parentBlocks[name].code);
    if (match){
      arrayName = match.groups.name;
      let useRegex = new RegExp(String.format(useFinder, arrayName));
      let travRegex = new RegExp(travFinder, 'g');
      let forLoops = [...parentBlocks[name].code.matchAll(travRegex)];
      for (let loop of forLoops){
        if(useRegex.test(loop[2])){
          return true;
        }
      }
    }
  }
  for(let name of childMethods){
    let match = decRe.exec(childBlocks[name].code);
    if (match){
      arrayName = match.groups.name;
      let useRegex = new RegExp(String.format(useFinder, arrayName));
      let travRegex = new RegExp(travFinder, 'g');
      let forLoops = [...childBlocks[name].code.matchAll(travRegex)];
      for (let loop of forLoops){
        if(useRegex.test(loop[2])){
          return true;
        }
      }
    }
  }

  for(let field of runnerArrayFields.arrayList){
    let useRegex = new RegExp(String.format(useFinder, field.name));
    let travRegex = new RegExp(travFinder, 'g');
    for(let name of runnerMethods){
      let forLoops = [...runnerBlocks[name].code.matchAll(travRegex)];
      for (let loop of forLoops){
        if(useRegex.test(loop[2])){
          return true;
        }
      }
    }
  }

  for(let field of parentArrayFields.arrayList){
    let useRegex = new RegExp(String.format(useFinder, field.name));
    let travRegex = new RegExp(travFinder, 'g');
    for(let name of parentMethods){
      let forLoops = [...parentBlocks[name].code.matchAll(travRegex)];
      for (let loop of forLoops){
        if(useRegex.test(loop[2])){
          return true;
        }
      }
    }
  }

  for (let field of childArrayFields.arrayList){
    let useRegex = new RegExp(String.format(useFinder, field.name));
    let travRegex = new RegExp(travFinder, 'g');
    for(let name of childMethods){
      let forLoops = [...childBlocks[name].code.matchAll(travRegex)];
      for (let loop of forLoops){
        if(useRegex.test(loop[2])){
          return true;
        }
      }
    }
  }

  // check for ArrayList parameter usage
  for (let name of runnerMethods){
    let params = runnerBlocks[name].params.arrayList;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useFinder, param.name));
      let travRe = new RegExp(travFinder, 'g');
      let forLoops = [...runnerBlocks[name].code.matchAll(travRe)];
      for (let loop of forLoops){
        if (useRe.test(loop[2])){
          return true;
        }
      }
    }
  }

  for (let name of parentMethods){
    let params = parentBlocks[name].params.arrayList;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useFinder, param.name));
      let travRe = new RegExp(travFinder, 'g');
      let forLoops = [...parentBlocks[name].code.matchAll(travRe)];
      for (let loop of forLoops){
        if (useRe.test(loop[2])){
          return true;
        }
      }
    }
  }

  for (let name of childMethods){
    let params = childBlocks[name].params.arrayList;
    if (params.length == 0)
      continue;
    for (let param of params){
      let useRe = new RegExp(String.format(useFinder, param.name));
      let travRe = new RegExp(travFinder, 'g');
      let forLoops = [...childBlocks[name].code.matchAll(travRe)];
      for (let loop of forLoops){
        if (useRe.test(loop[2])){
          return true;
        }
      }
    }
  }

  return false;
}

function checkRecursion(){
  for(let name of runnerMethods){
    let block = runnerBlocks[name].code;
    let re = new RegExp(`(?<!.)${name}\\(`);
    if (re.test(block)){
      return true;
    }
  }
  for(let name of parentMethods){
    let block = parentBlocks[name].code;
    let re = new RegExp(`(?<!.)${name}\\(`);
    if (re.test(block)){
      return true;
    }
  }
  for(let name of childMethods){
    let block = childBlocks[name].code;
    let re = new RegExp(`(?<!\\.)${name}\\(`);
    ;
    if (re.test(block)){
      return true;
    }
  }
  return false;
}

function getArrayFields(fieldsArr){
  // returns an array of all of the array, 2d array, and arrayList fields using the array of fields
  let arrayFields = [];
  let array2dFields = [];
  let arrayListFields = [];
  for(let field of fieldsArr){
    if (field.includes('[][]')){
      array2dFields.push({type: field.split('[][]')[0].trim(), name: field.split('[][]')[1].trim()});
    } else if (field.includes('[]')){
      arrayFields.push({type: field.split('[]')[0].trim(), name: field.split('[]')[1].trim()});
    } else if (field.includes('ArrayList')){
      arrayListFields.push({type: field.split('ArrayList')[1].trim(), name: field.split('ArrayList')[0].trim()});
    }
  }
  return {array: arrayFields, array2d: array2dFields, arrayList: arrayListFields};
}

function cleanComments(code){
  // removes all java comments (/* */, // )from the code 
  return code.replace(/\/\*[\s\S]*?\*\/|([^\\:]|^)\/\/.*$/gm, '');
}

function removeStrings(code){
  // removes all strings from the code
  return code.replace(/".*?"/g, '');
}

/**
 * Returns an object of method name to method block containing full method definitions
 * @param {string} code - the code to search
 * @param {string[]} methodNames - the names of the methods to search for
 * @returns {object} - an object of method name to method block
 */
function getMethodBlocks(code, methodNames){
  let blocks = {};
  let methodReStr = "(?:public|private) +(?:static +)?.+? +{1}\\s*\\((.*)\\)";
  for(let name of methodNames){
    let re = new RegExp(String.format(methodReStr, name), "g");
    let match = re.exec(code);
    let openBracketInd = code.indexOf("{", re.lastIndex);
    if(match == null)
      continue;
    let endBracketInd = findMatchingBracket(code, openBracketInd);

    // get params
    let paramsObj = {array: [], array2D: [], arrayList: [], primitive: []};
    if(match[1].length == 0){
      blocks[name] = {code: code.substring(openBracketInd, endBracketInd + 1), params: paramsObj};
      continue;
    }
    let params = match[1].split(/, */);
    for (let i = 0; i < params.length; i++) {
      let param = params[i];
      let type = param.split(/ +/)[0];
      let name = param.split(/ +/)[1];
      if (type.includes("[][]") || name.includes("[][]")) {
        type = type.replace("[][]", "");
        name = name.replace("[][]", "");
        paramsObj.array2D.push({baseType: type, name});
      } else if (type.includes("[]") || name.includes("[]")) {
        type = type.replace("[]", "");
        name = name.replace("[]", "");
        paramsObj.array.push({baseType: type, name});
      } else if (type.startsWith("ArrayList")) {
        type = type.replace(/ArrayList<(.+)>/, "\1");
        paramsObj.arrayList.push({baseType: type, name});
      } else {
        paramsObj.primitive.push({type, name});
      }
    }
    blocks[name] = {params: paramsObj, code: code.substring(openBracketInd, endBracketInd + 1)};
  }
  return blocks
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