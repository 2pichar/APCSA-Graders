package assignment10;

public class Sandwich extends Food 
{
    private String bread;
    private double height;

    public Sandwich ()
    {
        bread = "White";
        height = 4.0;
    }

    public Sandwich (String b, double h)
    {
        bread = b;
        height = h;
    }

    int [][] sandwich = new int [2][3];
}