package assignment10;

import java.util.Scanner;
import java.util.ArrayList;
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        ArrayList<Paladin> activePaladins = new ArrayList<Paladin>();
        ArrayList<Soldier> activeSoldiers = new ArrayList<Soldier>();
        Soldier[] team = new Soldier[5];
        Soldier[][] team1 = new Soldier[2][5];
        
        /*true/false depending on if you recruited a paladin*/
        boolean hasPaladin = false;

        /*input values by user for armor, strength and HP for Soldier*/
        double inpArmor;
        double inpStrength;
        int inpHealthPoints;

        /*input values by user for armor, strength and HP for Paladin*/
        double inpArmorP;
        double inpStrengthP;
        int inpHealthPointsP;

        /*tracks every unit created*/
        int counter = 0; 
        /*tracks every soldier created*/
        int scounter = 0;
        /*tracks every paladin created*/
        int pcounter = 0;


        /*Beginning of experience. User will be prompted to create a unit from the given choices and fill in its stats. 
        All units will be added to their respective lists and the overall team lists*/
        while(counter < 5)
        {

            System.out.println("\nWhich unit do you wish to recruit? \nSoldier\nPaladin");
            if(scan.nextLine().toUpperCase().equals("SOLDIER"))
            {
                
                System.out.println("How many hitpoints do you want this unit to have? (0-100)");
                inpHealthPoints = scan.nextInt();
                System.out.println("What armor rating do you want this unit to have? (0-50)");
                inpArmor = scan.nextDouble();
                System.out.println("What strength rating do you want this unit to have? (0-15)");
                inpStrength = scan.nextDouble();


                team[counter] = new Soldier(inpHealthPoints, inpStrength, inpArmor, "Soldier");
                team1[0][scounter] = new Soldier(inpHealthPoints, inpStrength, inpArmor, "Soldier");
                activeSoldiers.add(team[counter]);
                scounter++;
                counter++;
            }
            else if(scan.nextLine().toUpperCase().equals("PALADIN"))
            {
                System.out.println("How many hitpoints do you want this unit to have? (0-100)");
                inpHealthPointsP = scan.nextInt();
                System.out.println("What armor rating do you want this unit to have? (0-50)");
                inpArmorP = scan.nextDouble();
                System.out.println("What strength rating do you want this unit to have? (0-15)");
                inpStrengthP = scan.nextDouble();

                team[counter] = new Paladin(inpHealthPointsP, inpStrengthP, inpArmorP);
                team1[1][pcounter] = new Paladin(inpHealthPointsP, inpStrengthP, inpArmorP);
                Paladin d = new Paladin(inpHealthPointsP, inpStrengthP, inpArmorP);
                activePaladins.add(d);
                activeSoldiers.add(d);
                pcounter++;
                counter++;
                hasPaladin = true;
            }

            
            
        }
        
        /*Prompts the user if they want to see the team they have just created*/
        System.out.println("Display team? (Y / N)"); 
        if(scan.nextLine().toUpperCase().equals("YES") || scan.nextLine().toUpperCase().equals ("Y"))
        {
            for(Soldier i : team)
            {
                System.out.print(i.getClassType() + " ");
            }
        }

       /*Prompts the user if they want to see the team they have just created. This list is organized by class type*/
        System.out.println("\n\nDisplay organized team? (Y / N)");
        if(scan.nextLine().toUpperCase().equals("YES") || scan.nextLine().toUpperCase().equals ("Y"))
        {
            for(int r = 0; r < team1.length; r++)
         {
             if(r==0)
             {
                 System.out.print("Soldiers: ");
             }
             if(r==1)
             {
                 System.out.print("\nPaladins: ");
                 for(int j = 0; j < pcounter; j++)
                 {
                     System.out.print(team1[r][j].getClassType() + j + " ");
                 }
             }
             else
             {
                 for (int c = 0; c < scounter; c++)
             {
                    System.out.print(team1[r][c].getClassType() + c + " ");

             }
             }
         }
        }
        
        /*If there is a paladin, prompt the user if they want to reinforce their team. Might instead make this a method that is a one time use during the loop portion of the runner.
        Might make into method instead.*/
        if(hasPaladin)
        {
            System.out.println("\n\nIt appears you have a Paladin in your party. Do you wish to reinforce your troops? (Y / N)");
            if(scan.nextLine().toUpperCase().equals("YES") || scan.nextLine().toUpperCase().equals ("Y"))
            {
                reinforce(activePaladins, team);
            }
        }

        /*Part of program where User decides what to do*/
        String decision = "";
        while(!decision.equals("q"))
        {
            int unit;
            System.out.println("\n\nSelect an Action (1-4) or 'q' to quit \n1. Display Team\n2. Display Organized Team\n3. Check stats for a unit\n4. Check attack power for a unit");
            decision = scan.nextLine();

            if(decision.equals("1"))
            {
                for(Soldier i : team)
                {
                System.out.print(i.getClassType() + " ");
                }
            }
            else if(decision.equals("2"))
            {
                for(int r = 0; r < team1.length; r++)
                {
                    if(r==0)
                    {
                        System.out.print("Soldiers: ");
                    }
                if(r==1)
                {
                 System.out.print("\nPaladins: ");
                 for(int j = 0; j < pcounter; j++)
                 {
                     System.out.print(team1[r][j].getClassType() + j + " ");
                 }
                }
                else
                {
                 for (int c = 0; c < scounter; c++)
                  {
                    System.out.print(team1[r][c].getClassType() + c + " ");

                  }
                }
              }
            }
            else if(decision.equals("3"))
            {
                System.out.println("Which unit, from 0-4, would you like to inspect?");
                unit = scan.nextInt();
                System.out.println(team[unit]);
            }
            else if(decision.equals("4"))
            {
                System.out.println("Which unit, from 0-4, would you like to inspect?");
                unit = scan.nextInt();
                System.out.println("This unit's attack power is: " + team[unit].attack() + " damage");
            }
        }
    }

    

    

    /*Method that will reinforce the units in the team based off the highest armor value of the paladins in the team*/
    public static void reinforce(ArrayList<Paladin> activePaladins, Soldier[] team)
    {
        Paladin strongest = activePaladins.get(0);
    
         for(int i = 0; i < activePaladins.size(); i++)
         {
             if(activePaladins.get(i).getArmor() > strongest.getArmor())
             {
                 strongest = activePaladins.get(i);
             }
             
         }

         for(int j = 0; j < team.length; j++)
         {
             team[j].setArmor(team[j].getArmor() * strongest.reinforceBuff());
         }
    }


}
