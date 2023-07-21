/*let decRe = /(?<type>\w+)(?:(?:(?:(?:\[\]\[\] )|(?: \[\]\[\]))(?<name>\w+))|(?: (?<oname>\w+)\[\]\[\])) *= *.+?;/s;

let s = `\
String[][] phones = {
    {"Iphone 12", "Blue", "64"},
    {"Iphone 10", "Black", "128"},
    {"Iphone 13", "Green", "256"},
    {"Iphone 8", "White", "32"},
    {"Iphone 14", "Black", "128"},
    {"Iphone 13 Pro", "Mint", "64"},
    {"Iphone 11 Pro", "Red", "64"},
    {"Iphone 10 Pro", "Blue", "128"},
    {"Iphone 13", "Black", "256"},
    {"Iphone 7", "White", "32"},
    {"Iphone 6", "White", "64"},
    {"Iphone 15", "White", "1000"},
    {"Iphone 11 Pro Max", "Yellow", "500"},
    {"Iphone 13 Pro Max", "White", "256"},
    {"Iphone 14 Pro Max", "Green", "1000"},
};`

console.log(decRe.test(s));*/

let re = /for *\( *int (\w+) *= *\d+; *\1 *(?:<|>)(?:=?) *.+?; *\1.+?\) *(\{[^]+?\})/g
let s = "{\n        Scanner scan = new Scanner(System.in);\n        System.out.print();\n        String models = scan.nextLine();\n        System.out.print();\n        String colors = scan.nextLine();\n        System.out.print();\n        int storages = scan.nextInt();\n        scan.nextLine();\n\n\n        Iphone iphone = new Iphone(models, colors, storages);\n\n\n        System.out.print();\n        String CPU = scan.nextLine();\n        System.out.print();\n        String GPU = scan.nextLine();\n        System.out.println();\n        String operating = scan.nextLine();\n\n\n        Macbook combo = new Macbook(models, colors, storages, CPU, GPU, operating);\n\n\n        iphone.printModel();\n\n\n        iphone.printColStorage();\n\n\n        combo.printDetails();\n\n\n       \n        ArrayList<String> colorScheme = new ArrayList<>();\n        colorScheme.add();\n        colorScheme.add();\n        colorScheme.add();\n        colorScheme.add();\n\n\n        System.out.println();\n        for (int i = 0; i < colorScheme.size(); i++) {\n            System.out.println( + colorScheme.get(i));\n        }\n\n\n       \n        String[][] phones = {\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n                {, , },\n            };\n\n\n        System.out.println();\n        for (String[] morePhones : phones) {\n            for (int i = 0; i < morePhones.length; i++) {\n                System.out.print(morePhones[i] + );\n            }\n            System.out.println();\n        }\n\n\n        int[] productNumbers = {1, 2, 3, 4, 5};\n        System.out.println();\n        System.out.println(sum(productNumbers, productNumbers.length - 1));\n    }";
console.log([...s.matchAll(re)].length);