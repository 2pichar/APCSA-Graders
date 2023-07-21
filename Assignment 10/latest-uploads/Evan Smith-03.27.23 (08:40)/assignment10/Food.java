package assignment10;

public class Food
{
    //variables + constructors
    private String taste;
    private int ingredN;
    private int percent;

    public Food ()
    {
        taste = "Sweet";
        ingredN = 1;
        percent = 0;
    }

    public Food (String t, int i, int p)
    {
        taste = t;
        ingredN;
        percent = p;
    }

    public int eat (String a)
    {
        percent = 0;
        eat()
        System.out.println("You have eaten 100% of " + a);
    }
}