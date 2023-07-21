package assignment10;

public class Smoothie
{
    private String flavor1;
    private String flavor2;
    private String yogurt;
    private String size;

    private double price;
    private int time;

    public Smoothie()
    {
        this("strawberry", "banana", "whole milk", "medium");
    }

    public Smoothie(String flavor1, String flavor2, String yogurt, String size)
    {
        this.flavor1 = flavor1;
        this.flavor2 = flavor2;
        this.yogurt = yogurt;
        this.size = size;
    }

    public double getPrice()
    {  
        if(size.equals("extra large"))
        {
            price = 18.50;
        }
        else if(size.equals("large"))
        {
            price = 16;
        }
        else if(size.equals("medium"))
        {
            price = 14.50;
        }
        else if(size.equals("small"))
        {
            price = 12;
        }
        return price;
    }

    public void setSize(String s)
    {
        size = s;
    }

    public int getWaitingTime()
    {
        if(size.equals("extra large"))
        {
            time = 20;
        }
        else if(size.equals("large"))
        {
            time = 15;
        }
        else if(size.equals("medium"))
        {
            time = 12;
        }
        else if(size.equals("small"))
        {
            time = 8;
        }
        return time;
    }

    public String toString()
    {
        return size + " " + flavor1 + " " + flavor2 + " smoothie with " + yogurt + " yogurt";
    }


}