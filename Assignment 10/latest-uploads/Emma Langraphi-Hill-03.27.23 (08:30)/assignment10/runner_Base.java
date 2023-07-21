package assignment10;

import java.util.Scanner;

public class runner_Base {
    
    private static Base c;
    private static Toppings t;

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        //start of program, asks for the flavor of the ice cream
        System.out.println("Let's create a dessert!");
        System.out.println("Pick a flavor for your ice cream!");
        String fl = scan.nextLine();
        c = new Base();
        c.setFlavor(fl);

        //sets number of scoops
        System.out.println("How many scoops do you want?");
        int sc = scan.nextInt();
        
        //asks if user wants a cone, and if not they get a cup
        System.out.println("Do you want a cone?(y/n)");
        if (scan.nextLine().equals("y")){
            c = new Base(fl, sc, true);
        } else if (scan.nextLine().equals("n")){
            c = new Base(fl, sc, false);
        }
        
        if (1 == 1){
            System.out.println("\n" + c.toString());
        }

        //asks user if they would like to add 3 different toppings
        System.out.println("\nWould you like to add 3 scoops of toppings?(y/n)");
        String top = scan.nextLine();
        t = new Toppings();
        if (top.equals("y")){
            System.out.println(t.printShelf());
            System.out.println("Type which topping you would like to add (you can add the same topping more than once)");
            String one = scan.nextLine();
            System.out.print(t.findTopping(one));
            System.out.println(" What other toppings?");
            String two = scan.nextLine();
            System.out.print(t.findTopping(two));
            System.out.println(" And for your last topping?");
            String three = scan.nextLine();
            System.out.print(t.findTopping(three));
            t.setToppings(one, two, three);
        } else if (top.equals("n")){
            System.out.println("\n" + c.toString());
        }

        //if the user has more than one scoop of ice cream, it asks if they would like a second flavor of ice cream
        if (c.getScoops() > 1) {
            System.out.println("\n\nWould you like to add a second ice cream flavor?(y/n)");
            if (scan.nextLine().equals("y")){
                System.out.println("What's your second flavor?");
                c.addFlavor(scan.nextLine());
                System.out.println("\n" + c.toString());
            }
        }

        //finally asks the user if they would like to add a sauce topping
        System.out.println("\nWould you like to add a sauce?(y/n)");
        String sauc = scan.nextLine();
        if (sauc.equals("y")) {
            System.out.println(t.printSauces());
            System.out.println("Type which sauce you would like to add");
            String sce = scan.nextLine();
            System.out.println(t.findSauce(sce));
            System.out.println("\n" + c.toString());
        } else {
            System.out.println("\n" + c.toString());
        }

        System.out.println("\nType in a lucky number to see if you win our 10% discount!");
        int num = scan.nextInt();
        System.out.println(c.luckyNum(num));
        System.out.println("\nThank you for visiting our shop!");
  }
    }

