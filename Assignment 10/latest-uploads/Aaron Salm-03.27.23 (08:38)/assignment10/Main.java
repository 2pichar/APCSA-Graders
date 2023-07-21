package assignment10;

import java.util.*;


public class Main {
    private static String getInput(String prompt, String validOpts[])
    {
        Scanner scan = new Scanner(System.in);
        System.out.println(prompt);
        String input = scan.nextLine();
        boolean found = false;
        for (String s : validOpts) {
            if (input == null)
                break;
            if (input.equals(s)) {
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Bad Input");
            input = getInput(prompt,validOpts);
        }
        return input;
    }
    public static void main (String[] args){
    Scanner scan = new Scanner(System.in);
    ArrayList<Employee> employees = new ArrayList<Employee>();
    String input1 = "";
    String input2 = "";
    input2 = "a";
    String outerOpts[] = { "a", "b", "c", "d"};
    while(input2.equals("a") || input2.equals("b") || input2.equals("c")){
        input2 = getInput("Thank you for joining us! Type 'a' to add employees, type 'b' to edit employees, type 'c' to print out all your employees, type 'd' to quit",outerOpts);

        if(input2.equals("a")){
            System.out.println("\nAlright, type 'a' if you want to add a normal employee or type 'b' if you want to add a board member (It is highly recommended to add board members first before normal employees)");
            String input3 = scan.nextLine();
            if(input3.equals("a")){
                System.out.println("Good choice, what is the name of the employee?");
                String name1 = scan.nextLine();
                System.out.println("Now, how old is that employee?");
                int age1 = scan.nextInt();
                System.out.println("Finally, what is the yearly income of that employee?");
                int pay1 = scan.nextInt();
                scan.nextLine();
                Employee e = new Employee(name1, age1, pay1);
                employees.add(e);
            } else if(input3.equals("b")){
                System.out.println("Good choice, what is the name of the board member?");
                String name2 = scan.nextLine();
                System.out.println("Now, how old is that board member?");
                int age2 = scan.nextInt();
                System.out.println("What is the yearly income of that board member?");
                int pay2 = scan.nextInt();
                scan.nextLine();
                System.out.println("Finally, what is the position that board member has?");
                String pos2 = scan.nextLine();

                Employee e = (Employee)new BoardMember(name2, age2, pay2, pos2);
                employees.add(e);
            } else{
                System.out.println("stop putting in a different letter then what i say");
            }
            for(int i = 0; i < employees.size(); i++){
                if(employees.get(i).getAge() < 21){
                    employees.get(i).setAge(21);
                }
            }
            continue;
        } else if(input2.equals("b")){
            System.out.println("\nNice choice, type 'a' to add a status to an employee or board member, type 'b' to add vacation time to an employee, type 'c' to add a return time for a board member, or type 'd' to give employees bonuses.");
            String input4 = scan.nextLine();
            if(input4.equals("a")){
                System.out.println("Alright, type the employee number of the employee you want to change the status of.");
                int employeenum1 = scan.nextInt();
                scan.nextLine();
                System.out.println("Are they a board member or not? (Type 'yes' if they are, otherwise type 'no')");
                String employeetype1 = scan.nextLine();
                if(employeetype1.equals("yes")){
                    System.out.println("Now, type what you want their status to be now.");
                    String status1 = scan.nextLine();
                    System.out.println("Finally, type how important this status is on a scale of 1 to 10.");
                    String importance1 = scan.nextLine();
                    BoardMember b = (BoardMember) employees.get(employeenum1);
                    b.addStatus(status1, importance1);
                } else if(employeetype1.equals("no")){
                    System.out.println("Now, type what you want their status to be now.");
                    String status2 = scan.nextLine();
                    employees.get(employeenum1).addStatus(status2);
                } else{
                    System.out.println("stop typing things i say not to type");
                    continue;
                }
                continue;
            } else if(input4.equals("b")){
                System.out.println("Alright, type the employee number of the employee you want to change the vacation time of.");
                int employeenum2 = scan.nextInt();
                scan.nextLine();
                System.out.println("Now, type the new amount of vacation time for this employee.");
                String vacation1 = scan.nextLine();
                employees.get(employeenum2).addVacation(vacation1);
                continue;
            } else if(input4.equals("c")){
                System.out.println("Alright, type the employee number of the board member you want to add a return time to.");
                int employeenum3 = scan.nextInt();
                scan.nextLine();
                System.out.println("Now, type the return time of this board member.");
                String returntime1 = scan.nextLine();
                BoardMember b2 = (BoardMember) employees.get(employeenum3);
                b2.addReturn(returntime1);
                continue;
            } else if(input4.equals("d")){
                System.out.println("Alright, type how many bonuses you want to give to your employees");
                int employeebonuses = scan.nextInt();
                int[] bonuses = new int[employeebonuses];
                System.out.println("Now, put in order the bonuses you want to give each employee");
                for(int j = 0; j < bonuses.length; j++){
                    bonuses[j] = scan.nextInt();
                }
                scan.nextLine();
                int counter1 = 0;
                for(int b1 : bonuses){
                    if(b1 <= 0){
                        b1 = 500;
                    }
                    BoardMember b3 = (BoardMember) employees.get(counter1);
                    b3.addBonuses(b1);
                    counter1++;

                }
                
        
            }
        } else if(input2.equals("c")){
            if(employees.size() <= 0){
                System.out.println("No employees");
            }
            for(int z = 0; z < employees.size(); z++){
                BoardMember b4 = (BoardMember) employees.get(z);
                String output = b4.toString();
                System.out.println("Number: " + z + " - " + output);
            }
        }

    
    }
}
}
