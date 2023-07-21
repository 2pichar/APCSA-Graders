package assignment10;

import java.util.ArrayList;
public class Runner 
{
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);

    String[] options;
    ArrayList<String> sandwiches = new ArrayList<String>();
    String option1;

    System.out.println("alright what do you want\n[sandwich] [burger] [pizza]");
    String ag = scan.nextLine();
    option1(ag);

    private String option1 (String a)
    {
        if (a.equals("burger"))
        {
            System.out.println("nah");
        }
        else if (a.equals("pizza"))
        {
            System.out.println("nah");
        }
        else if (a.equals("sandwich"))
        {
            System.out.println("ooooo alright what toppings do you want?");
        }
    }
  }

}