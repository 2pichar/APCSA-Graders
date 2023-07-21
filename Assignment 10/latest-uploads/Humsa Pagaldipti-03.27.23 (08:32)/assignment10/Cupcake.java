package assignment10;

public class Cupcake extends Cake
{
    //instance variables
    public int amount = 0;
    public int price = 0;
    public String theme = "";
    //themes menu
    public String[] themes = {"rainbow", "superheros", "princesses", "flowers", "animals", "colleges", "birthday"};
    public String frostingFlavor = "";
    //menu of cake flavors and frosting flavors
    public static String[][] flavorMenu = {{"cake flavor:", "frosting flavor:"},
                                    {"vanilla", "vanilla"},
                                    {"chocolate", "chocolate"},
                                    {"strawberry", "buttercream"}};
    //constructors
    public Cupcake()
    {
        super();
        amount = 6;
        theme = "rainbow";
    }

    public Cupcake(String f, boolean hF, String fF)
    {
        super(f, hF);
        frostingFlavor = fF;
        amount = 6;
        theme = "rainbow";
    }

    public Cupcake(String f, boolean hF, String fF, int a, String t)
    {
        super(f, hF);
        frostingFlavor = fF;
        amount = a;
        //checking that the theme user wanted is available
       for (String s : themes)
        {
            if (s.equals(t))
            {
                theme = t;
            }
        }
        if (!(theme.equals(t)))
        {
            System.out.println("That theme is not available :( Please see our themes menu and select a theme from those options!");
            for (int i = 0; i < themes.length; i++)
            {
                System.out.println(themes[i]);
            }
        }
    }

    //accessors and mutators
    public int getAmount()
    {
        return amount;
    }

    public String getTheme()
    {
        return theme;
    }

    public String getFrostingFlavor()
    {
        return frostingFlavor;
    }

    public void setAmount(int a)
    {
        amount = a;
    }

    public void setTheme(String t)
    {
        for (String s : themes)
        {
            if (s.equals(t))
            {
                theme = t;
            }
        }
        if (!(theme.equals(t)))
        {
            System.out.println("That theme is not available :( Please see our themes menu and select a theme from those options!");
            for (int j = 0; j < themes.length; j++)
            {
                System.out.println(themes[j]);
            }
        }
    }

    public void setFrostingFlavor(String fF)
    {
        //check if frosting flavor is in the flavors 2d array
        for (int row = 0; row < flavorMenu.length; row++)
        {
            if (flavorMenu[row][1].equals(fF))
            {
                frostingFlavor = fF;
            }
        }
        if (!(frostingFlavor.equals(fF)))
        {
            System.out.println("That frosting flavor is not available :( Please see our flavors menu and select a frosting flavor from those options!");
            //print out flavorMenu
            for (int h = 0; h < flavorMenu.length; h++)
            {
                for (int u = 0; u < flavorMenu[0].length; u++)
                {
                    System.out.print(flavorMenu[h][u] + " \t");
                }
                System.out.println();
            }
        }
    }
    //overriden method
    public void deliver()
    {
        System.out.println("Your order of cupcakes has been delivered! Enjoy <3");
    }

    //unique method
    public int calcPrice(int a)
    {
        if (a == 0)
        {
            return price;
        }
        else
        {
            return 5 + calcPrice(a - 1);
        }
    }
    //toString
    public String toString()
    {
        String result = amount + " " + flavor + " cupcakes" + " (" + theme + ")";
        if (hasFrosting == true)
        {
            result += " with " + frostingFlavor + " frosting";
        }
        return result;
    }

}