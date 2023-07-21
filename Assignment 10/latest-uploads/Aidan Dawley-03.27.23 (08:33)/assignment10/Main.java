package assignment10;

import java.util.ArrayList;
import java.util.Scanner;
public class Main {

    public static void main(String[] args) {
    Scanner scan = new Scanner(System.in); 
        System.out.println("Hello, Welcome to the soccer team explorer. Would you like to view a 1)Team or a 2)Player");
        int choose = scan.nextInt();
        ArrayList<String> teams = new ArrayList<String>();
        teams.add("1)PSG");
        teams.add("2)RM");
        ArrayList<String> players = new ArrayList<String>();
        players.add("1)Messi");
        players.add("2)Neymar");
        players.add("3)Mbappe");
        players.add("4)Benzema");
        players.add("5)Hazard");
        players.add("6)Tchouameni");
        
    if(choose == 1)
    {
       System.out.println("Choose a team:");
       for (String s: teams) 
{
  System.out.println(s);
}
System.out.println("Are your options");
int b = scan.nextInt();
Team yo = new Team(b);
System.out.println(yo.getName());
System.out.println(yo.getClubRank() + " is the teams current rank in their league");
    
    }
    else if (choose == 2)
    {
        System.out.println("Choose a player by number:");
        for (int i = 0; i < players.size(); i++) 
        {
        String a = (players.get(i) + " ");
        System.out.print(a);
        }
         int c = scan.nextInt();
        Player yo = new Player(c);
        System.out.println(yo.getName());
        System.out.println(yo.getNameTwo());
        System.out.println(yo.posit());
        System.out.println(yo.mystery(5));
    }
    
    else {
        System.out.println("Use a different number");
    }
    }
}