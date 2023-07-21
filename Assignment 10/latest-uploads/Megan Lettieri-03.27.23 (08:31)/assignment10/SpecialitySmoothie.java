package assignment10;

public class SpecialitySmoothie extends Smoothie
{
    private String boba = "";
    private String toppings = "";

    public SpecialitySmoothie()
    {
        super();
        boba = "black boba";
        toppings = "whipped cream";
    }

    public SpecialitySmoothie(String flavor1, String flavor2, String yogurt, String size, String boba, String toppings)
    {
        super(flavor1, flavor2, yogurt, size);
        this.boba = boba;
        this.toppings = toppings;
    }

    public double getPrice()
    {  
        double price = super.getPrice() + 2;
        return price;
    }

    public int getWaitingTime()
    {
        int time = super.getWaitingTime();
        if(!boba.equals("") || !toppings.equals(""))
        {
            time += 5;
        }
        return time;
    }

    public String toString()
    {
        return super.toString() + " with " + boba + " and " + toppings;
    }


    
}