package assignment10;

public class Cake
{
    //instance variables
    public String flavor = "";
    public boolean hasFrosting = false;
    public boolean isSliced = false;

    //constructors
    public Cake()
    {
        flavor = "vanilla";
        hasFrosting = false;
    }

    public Cake(String f, boolean hF)
    {
        flavor = f;
        hasFrosting = hF;
    }

    //accessor and mutator methods
    public String getFlavor()
    {
        return flavor;
    }

    public boolean getFrostingStatus()
    {
        return hasFrosting;
    }

    public void setFlavor(String f)
    {
        flavor = f;
    }

    public void setFrostingStatus(boolean hF)
    {
        hasFrosting = hF;
    }

    //unique methods
    public void slice(int s)
    {
        System.out.println("The cake has been split into " + s + " slices! :)");
        isSliced = true;
    }

    public void deliver()
    {
        System.out.println("Your order of cake has been delivered! Enjoy <3");
    }

    //toString
    public String toString()
    {
        String result = "a " + flavor + " cake";
        //checking if the user wanted frosting
        if (hasFrosting == true)
        {
            result += " with frosting";
        }
        //checking if the user sliced their cake
        if (isSliced == true)
        {
            result += " (sliced)";
        }
        result += " for a price of 20 dollars";
        return result;
    }
}