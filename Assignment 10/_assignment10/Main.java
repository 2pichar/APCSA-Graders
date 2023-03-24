/**
 * Changes by Charles Ludden:
    - rewrite recursive average method
    - fix correct answers showing up in questions
    - continuously prompt user for trying another question
*/
package assignment10;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;
import java.lang.Math;
import java.util.*;

public class Main {
    String name = "";
    public static void main(String[] args) {

        //holds questions
        int rows = 10;
        int columns = 5;
        String[][] Questions = new String[rows][columns];
        //2D Array that holds all of the answers
        String[][] Answers = new String[rows][columns];
        // holds the users guess answers to questions (ArrayList)
        ArrayList<Integer> UserAnswers = new ArrayList<>();

        // Unit 1 Questions
        Questions[0][0] = "A recursive function must have: a) a primitive variable  b) a base case  c) a " +
                "for loop  d) a call to another method";
        Questions[0][1] = "Which of the following is true about Strings? a) Strings are immutable b) Data" +
                " of type String cannot be assigned null c) Setting two variables equal to each" +
                " other when one of the variables is a String causes a copy of the String to be" +
                " assigned to the other variable d) Strings are a primitive data type";
        Questions[0][2] = "What is wrong with the following code? (int guess = 42.07;) a) The type of the" +
                " variable should be a float or a double. b)The variable should be a String.  c" +
                ")Nothing the code is fine as-is. d) You cannot store an int in a double variab" +
                "le. e) The type should be “Double” not “int”. f) You cannot store a double in " +
                "an int variable. ";
        Questions[0][3] = "Different data types can store different amounts of data. In the options below" +
                ", which has the data types listed in order, from largest to smallest? a) doubl" +
                "e, String, boolean, int (b) int, double, boolean, String (c) String, double, i" +
                "nt, boolean (d) All the data types are the same size. (e) int, String, double," +
                " boolean";
        Questions[0][4] = "What data type should you use to hold whether a person passed or failed a clas" +
                "s? a) boolean, b) char. c) double, d) int, e) String";

        //Unit 2 Questions
        Questions[1][0] = "Which of the following is true about Strings? a) Strings are immutable b) Data" +
                " of type String cannot be assigned null c) Setting two variables equal to each" +
                " other when one of the variables is a String causes a copy of the String to be" +
                " assigned to the other variable d) Strings are a primitive data type";
        Questions[1][1] = "Which of the following statements about overloaded constructors is true? a) Co" +
                "nstructors for a class can be overloaded but they must all have different name" +
                "s b) Constructors for a class can be overloaded but they must all have a diffe" +
                "rent number of parameters, different order of parameters or different types of" +
                " parameters c) Constructors cannot be overloaded d) Constructors for a class c" +
                "an be overloaded but they must have different numbers of parameters";
        Questions[1][2] = "_____ data types can hold many pieces of information at a time. a) alphanumber" +
                "ic b) primitive c) null D) class";
        Questions[1][3] = "Different data types can store different amounts of data. In the options below" +
                ", which has the data types listed in order, from largest to smallest? a) doubl" +
                "e, String, boolean, int (b) int, double, boolean, String (c) String, double, i" +
                "nt, boolean (d) All the data types are the same size. (e) int, String, double," +
                " boolean";
        Questions[1][4] = "What data type should you use to hold whether a person passed or failed a clas" +
                "s? a) boolean, b) char. c) double, d) int, e) String";

        //Unit 3 Q's
        Questions[2][0] = "When do you use an else statement? a) To input a variable  b) None of the item" +
                "s listed. c) To run some code when an if statement is false  d) To run some co" +
                "de when an if statement is true";
        Questions[2][1] = "Which of the following is true about Strings? a) Strings are immutable b) Data" +
                " of type String cannot be assigned null c) Setting two variables equal to each" +
                " other when one of the variables is a String causes a copy of the String to be" +
                " assigned to the other variable d) Strings are a primitive data type";
        Questions[2][2] = "Which of the following boolean statements evaluate to true for x = 24 y = 53: " +
                " a) !(x <= y && x == y) b) !(x >= y) && x == y c) x >= y || x == y d) x >= y &" +
                "& x !=";
        Questions[2][3] = "Which of the following is equivalent to the boolean expression:               " +
                "                            !(!(A && B) || !(!A || B))   a) (!A && !B) || (A |" +
                "| !B)    b) (A && B) && (!A || B)   c) (A || !B) && (A && B)   d) (!A || !B) &" +
                "& (A && B)  ";
        Questions[2][4] = "What data type should you use to hold whether a person passed or failed a clas" +
                "s? a) boolean, b) char. c) double, d) int, e) String";

        //Unit 4 Q's
        Questions[3][0] = "If you have a loop that run ten times with a nested loop that also runs ten ti" +
                "mes, how many times will the nested loop run? A) 100 B) 1000 C) 2 D) 20";
        Questions[3][1] = "What does making the i value in a for loop start at 1 and go up 2 per run do? " +
                "A) go through all the even values B) go through all the odd values C) go throu" +
                "gh all values backward D) causes an error";
        Questions[3][2] = "What is wrong with the following code? (int guess = 42.07;) a) The type of the" +
                " variable should be a float or a double. b)The variable should be a String.  c" +
                ")Nothing the code is fine as-is. d) You cannot store an int in a double variab" +
                "le. e) The type should be “Double” not “int”. f) You cannot store a double in " +
                "an int variable.  ";
        Questions[3][3] = "Different data types can store different amounts of data. In the options below" +
                ", which has the data types listed in order, from largest to smallest? a) doubl" +
                "e, String, boolean, int (b) int, double, boolean, String (c) String, double, i" +
                "nt, boolean (d) All the data types are the same size. (e) int, String, double," +
                " boolean";
        Questions[3][4] = "What data type should you use to hold whether a person passed or failed a clas" +
                "s? a) boolean, b) char. c) double, d) int, e) String";


        //Unit 5 Q's
        Questions[4][0] = "A(n) ______ is the local variable in a method that holds the data sent in. a) " +
                "class b) formal parameter c) method d) actual parameter e) primitiven";
        Questions[4][1] = "A(n) ______ is the data sent to a method. a) class b) primitive c) actual para" +
                "meter d) formal parameter e) method";
        Questions[4][2] = "What is wrong with the following code? (int guess = 42.07;) a) The type of the" +
                " variable should be a float or a double. b)The variable should be a String.  c" +
                ")Nothing the code is fine as-is. d) You cannot store an int in a double variab" +
                "le. e) The type should be “Double” not “int”. f) You cannot store a double in " +
                "an int variable.  ";
        Questions[4][3] = "A ______ is a separate chunk of code that is given a name.a) Parameter b ) ret" +
                "urn c) block d) method e) void";
        Questions[4][4] = "What data type should you use to hold whether a person passed or failed a clas" +
                "s? a) boolean, b) char. c) double, d) int, e) String";

        //Unit 6 Q's
        Questions[5][0] = "A recursive function must have: a) a primitive variable  b) a base case  c) a " +
                "for loop  d) a call to another method";
        Questions[5][1] = "An enhanced for loop CANNOT be used on an array if: a) the array should be tra" +
                "versed in order b) each item should be looked at once c) comparing items to ea" +
                "ch other is required d) there are duplicate items";
        Questions[5][2] = "Assume arr has been declared as an array of Objects. Which of these will get t" +
                "he last Object in arr? a) arr[arr.size-1] b) arr[arr.length()] c) arr[arr.leng" +
                "th()-1] d) arr[arr.length-1]";
        Questions[5][3] = " Which of the following would you use to access the ArrayList element at posit" +
                "ion i? A) .set(i, e) B).remove(i) C)   .get(i) D) None of the answers listed.";
        Questions[5][4] = "int[] arr  {7, 2, 13, 4, 11, 3} If this array is sorted using the selection so" +
                "rt algorithm, what will the array look like after three swaps have been perfor" +
                "med in this algorithm?";

        //Unit 7 Q's
        Questions[6][0] = "Which key word is used to initialize an ArrayList? a) new  b) public  c) newAr" +
                "ray  d) new  e) nothing, you initialize it like a variable";
        Questions[6][1] = "Which loop is most appropriate to process an ArrayList and remove several elem" +
                "ents in the list? a) for-loop  b) for-each-loop c) None of the above d) All wo" +
                "rks equally";
        Questions[6][2] = "Which of the following is not true about ArrayList objects? a) ArrayList objec" +
                "ts can hold primitive type data  b) ArrayList objects can only hold class type" +
                " data  c)  Methods for insertion and deletion are built into the class  d) Arr" +
                "ayList is a class data type      a is correct";
        Questions[6][3] = "Which of the following shows the start of a Javadoc comment? a) /** b) Javadoc" +
                ".comment( c) //  d) /*";
        Questions[6][4] = "What does 'return by value' mean in Java? a) a value is returned as a certain " +
                "variable type b) a copy of the value/reference in the return statement is retu" +
                "rned c) a copy of the input value is sent to the method d) Idk";

        //Unit 8 Q's
        Questions[7][0] = "When you need to use a method, you ______ it. a)void b)call c)use d)return e)d" +
                "eclare";
        Questions[7][1] = "_____ is the process of finding and eliminating errors in code. A) Executing B" +
                ") Compiling C) Debugging D) Programming E) All of the options listed";
        Questions[7][2] = "For the boolean expression: (!A || B) && (A && B): A is true and B is false. W" +
                "hich of the following methods can be used to most efficiently solve this expre" +
                "ssion?           a) De Morgan's Law    b) Short Circuit Evaluation   c) Truth " +
                "Table   d) none of the above";
        Questions[7][3] = "To define an empty variable, ____ keyword can be used.   A)null    B)True   C)" +
                " False   D) int ";
        Questions[7][4] = "Given the following declaration:\n RegularPolygon polygon1 = new Polygon(4.0);" +
                " How do you increase the number of sides by 3?  A) addSides(3);  B) polygon1.a" +
                "ddSides(3);    C) polygon1.sides = polygon1.sides + 3";

        //Unit 9 Q's
        Questions[8][0] = "A recursive function must have: a) a primitive variable  b) a base case  c) a " +
                "for loop  d) a call to another method";
        Questions[8][1] = "A child class can call all of its parent's public methods a) True b) False";
        Questions[8][2] = "Which of the following is true about overloading and overriding methods? a) Ov" +
                "erriding methods does not need to have the same return type as the method in t" +
                "he parent class. b) When a child class has a local version of a method with th" +
                "e same return type that is defined in a parent class this is called overloadin" +
                "g.c) When a child class has a local version of a method with the same return t" +
                "ype that is defined in a parent class this is called overriding.d) Constructor" +
                "s can be overridden";
        Questions[8][3] = "_____ is the process of finding and eliminating errors in code. A) Executing B" +
                ") Compiling C) Debugging D) Programming E) All of the options listed.";
        Questions[8][4] = "Which of the following best describes the relationship between a class and an " +
                "object?  A) Objects are created using classes, which are similar to blueprints" +
                ".  B) A class is a piece of data which is contained in an object. C) An object" +
                " is used to create classes, which are primitive data types. D) A class is a sp" +
                "ecific variable in a program, which has behaviors defined by objects.";

        //Unit 10 Q's
        Questions[9][0] = "";
        Questions[9][1] = "";
        Questions[9][2] = "";
        Questions[9][3] = "";
        Questions[9][4] = "";

        // Unit 1 Answers
        Answers[0][0] = "B";
        Answers[0][1] = "A";
        Answers[0][2] = "A";
        Answers[0][3] = "";
        Answers[0][4] = "A";

        //Unit 2 Answers
        Answers[1][0] = "A";
        Answers[1][1] = "B";
        Answers[1][2] = "D";
        Answers[1][3] = "C";
        Answers[1][4] = "A";

        //Unit 3 Answers
        Answers[2][0] = "C";
        Answers[2][1] = "A";
        Answers[2][2] = "B";
        Answers[2][3] = "B";
        Answers[2][4] = "A";

        //Unit 4 Answers
        Answers[3][0] = "A";
        Answers[3][1] = "A";
        Answers[3][2] = "F";
        Answers[3][3] = "C";
        Answers[3][4] = "A";

        //Unit 5 Answers
        Answers[4][0] = "B";
        Answers[4][1] = "C";
        Answers[4][0] = "B";
        Answers[4][3] = "D";
        Answers[4][4] = "A";

        //Unit 6 Answers
        Answers[5][0] = "B";
        Answers[5][1] = "C";
        Answers[5][2] = "D";
        Answers[5][3] = "C";
        Answers[5][4] = " ";

        //Unit 7 Answers
        Answers[6][0] = "D";
        Answers[6][1] = "A";
        Answers[6][2] = "A";
        Answers[6][3] = "A";
        Answers[6][4] = "B";

        //Unit 8 Answers
        Answers[7][0] = "B";
        Answers[7][1] = "C";
        Answers[7][2] = "B";
        Answers[7][3] = "A";
        Answers[7][4] = "B";

        //Unit 9 Answers
        Answers[8][0] = "B";
        Answers[8][1] = "A";
        Answers[8][2] = "C";
        Answers[8][3] = "C";
        Answers[8][4] = "";

        //Unit 10 Answers
        Answers[9][0] = "A";
        Answers[9][1] = "B";
        Answers[9][2] = "B";
        Answers[9][3] = "";
        Answers[9][4] = "";


        /*for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            Answers[i][j] = Questions[i][j].substring(Questions[i][j].length() - 1);
            Questions[i][j] = Questions[i][j].substring(0, Questions[i][j].length() - 1);
        }
    }
 */


        /*for (int i = 0; i < rows; i++) {
        for (int j = 0; j < columns; j++) {
            System.out.println(Questions[num1][num2]);
            //System.out.println(Answers[i][j]);
        }
     }*/
     
        Scanner scan = new Scanner(System. in);
        System.out.println("Enter Your Name");
        String name = scan.nextLine();
        System.out.println("Do you have a Nick Name? If you do what is it? ");
        String nickName = scan.nextLine();
        if (nickName.equals("")) { // set nickname to the user's first name, but only if they don't specify a nickname
            nickName = name.split(" ")[0]; // get first name only; "FirstName LastName".split(" ") = {"FirstName", "LastName"}; [0] gets first name
        }
        System.out.println("Are you a student? (Y/N) ");
        String temp = scan.nextLine();
        if (temp.toUpperCase().equals("Y")) {
            System.out.println("What year are you (9-12)?");
            int year = scan.nextInt();
            scan.nextLine();
            Student s1 = new Student();
            System.out.println("You are a " + s1.yearToString(year));
        }
        System.out.println(
            "Welcome " + nickName + ", good luck on the quiz!"
        );

        // Prompts user with questions and determines wether or not to stop giving new
        // questions need to add prompt to get answer
        boolean x = true;
        while (x == true) {
            int num1 = (int)(Math.random() * 10);
            int num2 = (int)(Math.random() * 5);
            //System.out.println(num1  + " " + num2);
            System.out.println(Questions[num1][num2]);
            String answer = scan.nextLine();
            // check if answer is correct and adds a 1 or 0 to UserAnswers ArrayList
            if (answer.toUpperCase().equals(Answers[num1][num2])) 
                UserAnswers.add(1);
            else 
                UserAnswers.add(0);
            String anotherQ = "";
            while (!anotherQ.equals("Y") && !anotherQ.equals("N")) {
                System.out.println("Would you like to try another question? (Y/N)");
                anotherQ = scan.nextLine().toUpperCase();
            }
            x = anotherQ.toUpperCase().equals("Y");
            //System.out.println(anotherQ + x);
        }
        //convert ArrayList to Array
        Integer[] a = new Integer[UserAnswers.size()];
        UserAnswers.toArray(a);
        int sum = 0;
        for (int e : a) {
            sum += e;
        }
        System.out.println("You got " + sum + "/" + a.length + " right!");
        System.out.println(
            "Your grade: " + String.format("%.2f%%", average(a, a.length) * 100)
        );
        scan.close();
    }


    // Recursive function to calculate the score as %
    public static double average(Integer[] a, int start) {
        if (start > 0) {
            double av = average(a, start - 1);
            return (a[start - 1] + (av * (start - 1))) / start;
        } else {
            return 0;
        }
    }

}
