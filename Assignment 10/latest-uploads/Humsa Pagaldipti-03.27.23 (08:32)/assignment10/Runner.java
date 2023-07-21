package assignment10;

import java.util.Scanner;
import java.util.ArrayList;
public class Runner 
{
    private static Scanner scan;
    public static int amount;
    public static String[][] flavorMenu = {{"cake flavor:", "frosting flavor:"},
                                    {"vanilla", "vanilla"},
                                    {"chocolate", "chocolate"},
                                    {"strawberry", "buttercream"}};       
    public static ArrayList<String> birthdays = new ArrayList<String>();         
    public static boolean finished = false;                    
    public static String[] themes = {"rainbow", "superheros", "princesses", "flowers", "animals", "colleges", "birthday"};

    public static void main(String[] args)
    {
        scan = new Scanner(System.in);
        while (finished == false)
        {
            System.out.println("Welcome to Humsa's Bakery! :D What is your name?");
            String name = scan.nextLine();
            if (!(birthdays.contains(name)))
            {
                birthdays.add(name);
            }
            System.out.println("What would you like to order today?\nEnter 'cake' or 'cupcakes'");
            String userOrder = (scan.nextLine()).toLowerCase();
            if (userOrder.equals("cake"))
            {
                Cake c = new Cake();
                //print out menu(s)
                for (int r = 0; r < flavorMenu.length; r++)
                {
                    for (int col = 0; col < flavorMenu[0].length; col++)
                    {
                        System.out.print(flavorMenu[r][col] + " \t");
                    }
                    System.out.println();
                }
                System.out.println("Which cake flavor would you like?");
                c.setFlavor((scan.nextLine()).toLowerCase());
                System.out.println("Would you like frosting on your cake? (yes / no)");
                if (((scan.nextLine()).toLowerCase()).equals("yes"))
                {
                    c.setFrostingStatus(true);
                }
                System.out.println("To recap, you ordered " + c.toString());
                c.deliver();
                System.out.println("Would you like to order something else? (yes / no)");
                if (((scan.nextLine()).toLowerCase()).equals("no"))
                {
                    finished = true;
                }
            }
            else if (userOrder.equals("cupcakes"))
            {
                Cupcake cc = new Cupcake();
                System.out.println("How many cupcakes would you like?");
                amount = scan.nextInt();
                scan.nextLine();
                cc.setAmount(amount);
                //print out menus
                for (int row = 0; row < flavorMenu.length; row++)
                {
                    for (int colu = 0; colu < flavorMenu[0].length; colu++)
                    {
                        System.out.print(flavorMenu[row][colu] + " \t");
                    }
                    System.out.println();
                }
                System.out.println("Which cupcake flavor would you like?");
                cc.setFlavor((scan.nextLine()).toLowerCase());
                System.out.println("Would you like frosting on your cupcakes? (yes / no)");
                if (((scan.nextLine()).toLowerCase()).equals("yes"))
                {
                    cc.setFrostingStatus(true);
                    System.out.println("Which frosting flavor would you like?");
                    cc.setFrostingFlavor(scan.nextLine());
                }
                    System.out.println("Which theme would you like?");
                    for (int t = 0; t < themes.length; t++)
                    {
                        System.out.println(themes[t]);
                    }
                cc.setTheme(scan.nextLine());
                System.out.println("To recap, you ordered " + cc.toString() + " for a price of " + cc.calcPrice(amount) + " dollars");
                cc.deliver();
                System.out.println("Would you like to order something else? (yes / no)");
                if (((scan.nextLine()).toLowerCase()).equals("no"))
                {
                    finished = true;
                }
            }
        }
        System.out.println("Here are the names of today's loyal customers :)");
        for (int n = 0; n < birthdays.size(); n++)
        {
            System.out.println(birthdays.get(n));
        }
        System.out.println("Have a nice day!");
    }
}
