package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class runner_Smoothie 
{
    public static Smoothie s;

    ArrayList<Smoothie> smoothie = new ArrayList<Smoothie>();

    public static void main(String[] args) 
    {
       Scanner scan = new Scanner(System.in);

       int flag = 1;

       System.out.println("Welcome to the Smoothie Bar. Would you like the house special (x) or to build your own (y)?");
       String input = scan.nextLine();
       if(input.equals("x"))
       {
           Smoothie s = new Smoothie();
           System.out.println(s);
           System.out.println("That will be " + s.getPrice() + " dollars");
           System.out.println("Would you like to change the size? (y/n)");
           String ansr = scan.nextLine();
           if(ansr.equals("y"))
           {
                System.out.println("What size do you want?");
                String siz = scan.nextLine();
                s.setSize(siz);
                System.out.println(s);
                System.out.println("That will now be " + s.getPrice() + " dollars");
           }
           System.out.println("Would you like to add boba or a topping? (y/n)");
           String ans = scan.nextLine();
           if(ans.equals("y"))
           {
               SpecialitySmoothie ss = new SpecialitySmoothie();
               System.out.println(ss);
               System.out.println("That will now be " + ss.getPrice() + " dollars");
               System.out.println("That will take " + ss.getWaitingTime() + " minutes");
               System.out.println("Thank you, have a nice day");
           }
           else 
           {
               System.out.println("That will take " + s.getWaitingTime() + " minutes");
               System.out.print("Thank you, have a nice day");
           }

       }
       while(input.equals("y") && flag == 1)
       {
            System.out.println("What flavors would you like? (Enter 2)");
            String flav1 = scan.nextLine();
            String flav2 = scan.nextLine();

            System.out.println("What kind of yogurt would you prefer?");
            String yog = scan.nextLine();

            System.out.println("What size?");
            String size = scan.nextLine();

            Smoothie s = new Smoothie(flav1, flav2, yog, size);
            System.out.println(s);

            System.out.println("That will be " + s.getPrice() + " dollars");

            System.out.println("Would you like to change the size? (y/n)");
            String ansr = scan.nextLine();
            if(ansr.equals("y"))
            {
                System.out.println("What size do you want?");
                size = scan.nextLine();
                s.setSize(size);
                System.out.println(s);
                System.out.println("That will now be " + s.getPrice() + " dollars");
            }

            System.out.println("Would you like to add boba or a topping? (y/n)");
            String ans = scan.nextLine();
            if(ans.equals("y"))
            {
                System.out.println("What kind of boba would you like?");
                String bob = scan.nextLine();
                System.out.println("What kind of toppings would you like?");
                String top = scan.nextLine();

                SpecialitySmoothie ss = new SpecialitySmoothie(flav1, flav2, yog, size, bob, top);
                System.out.println(ss);
                System.out.println("That will now be " + ss.getPrice() + " dollars");
                System.out.println("That will take " + ss.getWaitingTime() + " minutes");
                System.out.print("Thank you, have a nice day");
            }
            else
            {
                System.out.println("That will take " + s.getWaitingTime() + " minutes");
                System.out.println("Thank you, have a nice day");
            }
            flag = 0;
            
       }
       if(!input.equals("x") && !input.equals("y")) 
       {
           System.out.print("Sorry, that input wasn't recognized. Have a good day.");
       }

    }

}
