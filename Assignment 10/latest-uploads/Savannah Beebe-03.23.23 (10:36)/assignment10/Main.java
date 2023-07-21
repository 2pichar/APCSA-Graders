package assignment10;

import java.util.Scanner;
import java.util.ArrayList;
public class Main 
{
public static void main(String[] args) 
    {
        ArrayList<Pet> listOfPets= new ArrayList<Pet>();
        String[] initialList= new String[8];
        String[][] map= new String[4][4];

        Scanner scan= new Scanner(System.in);
        listOfPets.add(new Pet());
        listOfPets.add(new SmallPet());
        listOfPets.add(new Pet("Cat", 10, "Bob"));
        listOfPets.add(new Pet("bird", 20, "george"));
        listOfPets.add(new Pet("raccoon", 10, "sally"));
        listOfPets.add(new SmallPet(5, "lettuce","gerbil", 2, "peanut"));
        listOfPets.add(new SmallPet(1, "pellets", "fish", 1, "nemo"));
        listOfPets.add(new SmallPet(15, "carrots", "rabbit", 4, "hop"));

        for(int j=0; j<listOfPets.size(); j++)
        {
            initialList[j]=listOfPets.get(j).getName().substring(0,1);
        }
        int mapPlace=0;
        for(int m=0; m<4; m++)
        {
            for(int k=0; k<4; k++)
            {
                if(((k+m)%2)==0)
                {
                    map[m][k]=initialList[mapPlace];
                    mapPlace++;
                }
                else 
                {
                   map[m][k]="-";
                }
            }
        }


        System.out.println("Would you like to see all of your pets?");
        String answer1= scan.nextLine();
        if((answer1.equals("yes"))||(answer1.equals("y")))
        {
            for(int i=0; i<listOfPets.size(); i++)
            {
                System.out.println(listOfPets.get(i).toString());
                System.out.println();
            }
        }
        System.out.println("would you like to see all of the pets' initials?");
        String answer2= scan.nextLine();
        if((answer2.equals("yes"))||(answer2.equals("y")))
        {
            for(String s: initialList)
            {
                System.out.println(s + " ");
            }
            System.out.println();
        }
        System.out.println("Would you like to see a map locating all of the pets?");
        String answer3= scan.nextLine();
        if((answer3.equals("yes"))||(answer3.equals("y")))
        {
            for(int w=0; w<4; w++)
            {
                for(int q=0; q<4; q++)
                {
                    System.out.print(map[w][q] + " ");
                }
                System.out.println();
            }
        }
        System.out.println();
        System.out.println("Would you like to see a timeline for your pet?");
        String answer4= scan.nextLine();
        if((answer4.equals("yes"))||(answer4.equals("y")))
        {
            System.out.println("Which pet from 1-8?");
            int petNum= scan.nextInt()-1;
            System.out.println();
            System.out.println(listOfPets.get(petNum).timeLine(listOfPets.get(petNum).getAge()));
        }
    }
}



