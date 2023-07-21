package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class runner {

    public static void main(String[] args) {
        String restart = "restart";
        while (restart.equals("restart"))
        {
        System.out.println("Hello user! This program allows you to create your own animals and build a mini ecosystem. These animals can be real or fictional (ex deer or dragon).");
        System.out.println("We will build your first animal.");
        String cont = "y";
        Scanner scan = new Scanner(System.in);
        int animalAmount = 0;
        ArrayList<Animal> animals = new ArrayList<Animal>();

        while (cont.equals("y"))
        {
            animalAmount += 1;
            System.out.println("Type y to build your own animal or n to create a default animal.");
            String decision = scan.nextLine();
            //BUILDING ANIMAL
            if (decision.equals("y"))
            {
            System.out.println("What is this animal's name?");
            String name = scan.nextLine();
            System.out.println("\n" + "Okay, what size is this animal? (small/medium/large)");
            String size = scan.nextLine();
            //making sure the size is a valid input
            while (!(size.equals("small")||size.equals("medium")||size.equals("large")))
            {
                System.out.println("Not a valid size. Enter another size.");
                size = scan.nextLine();
            }
            //assigning the inputted size to a number for the constructor
            int sizeNum;
            if (size.equals("small"))
            {
                sizeNum = 1;
            }
            else if (size.equals("medium"))
            {
                sizeNum = 2;
            }
            else
            {
                sizeNum = 3;
            }
            System.out.println("\n" + "Type h if your animal is an herbivore, c if they are a carnivore, and o if they are an omnivore.");
            String foodType = scan.nextLine();
            ////making sure it is a valid input
            while (!(foodType.equals("h")||foodType.equals("c")||foodType.equals("o")))
            {
                System.out.println("Not a valid input. Make sure the predator is not an herbivore. Enter another letter.");
                foodType = scan.nextLine();
            }
            //assigning value to booleans for the constructor
            boolean carnivore = false;
            boolean herbivore = false;
            if (foodType.equals("c"))
            {
                carnivore = true;
            }
            else if (foodType.equals("h"))
            {
                herbivore = true;
            }
            System.out.println("\n" + "Okay, now input the foods your animal will eat. For example, if " + name + " is an herbivore you can type \"grain\", press enter, and then type \"cattail.\" Type x when you are finished.");
            ArrayList<String> foodSources = new ArrayList<String>();
            String input = scan.nextLine();
            while (!input.equals("x"))
            {
                foodSources.add(input);
                input = scan.nextLine();
            }
            System.out.println("Type f if this animal is fictional and n if they are real.");
            String fictional = scan.nextLine();
            if (fictional.equals("f"))
            {
                System.out.println("What is this animal's special power? Type a description.");
                String power = scan.nextLine();
                System.out.println("Enter three fictional worlds/stories where this animal exists (one per line).");
                String[] places = new String[3];
                places[0] = scan.nextLine();
                places[1] = scan.nextLine();
                places[2] = scan.nextLine();
                System.out.println("\nYour fictional animal is finished!\n");
                Animal userAnimal = new FictionalAnimal(sizeNum, name, foodSources, carnivore, herbivore, power, places);
                animals.add(userAnimal);
                System.out.println(userAnimal);
            }
            else 
            {
            System.out.println("\nYour animal is finished!\n");
            Animal userAnimal = new Animal(sizeNum, name, foodSources, carnivore, herbivore);
            animals.add(userAnimal);
            System.out.println(userAnimal);
            }
            }
            else
            {
                Animal unknown = new Animal();
                animals.add(unknown);
                System.out.println(unknown);
            }

            //need 2 animals
            if (animalAmount >= 2)
            {
                System.out.println("You now have " + animalAmount + " animals. You can build your ecosystem with 2 or more animals.");
            }
            else
            {
                System.out.println("You must make another animal to be able to build your ecosystem.");
            }
            //seeing if they want to repeat the process
            if (animalAmount >= 2)
            {
                System.out.println("Type y to make another animal. Type x to build your ecosystem.");
            }
            else
            {
                System.out.println("Type y to make another animal.");
            }
            cont = scan.nextLine();
            //checking for a valid input
            while (!(cont.equals("y")||cont.equals("x")))
            {
                System.out.println("Not a valid input. Try again.");
                cont = scan.nextLine();
            }
            System.out.println("");
        }
        //BUILDING ECOSYSTEM
        System.out.println("Now that you have " + animalAmount + " animals, you can assign predators or find new food sources for your animals. Type p to assign a predator, n to find new food sources, or c to change an animal's name. Type x to quit and get a summary of your ecosystem.");
        String input = scan.nextLine();
        //while the user is still making changes this will loop
        while (!input.equals("x"))
        {
            if (input.equals("p"))
            {
                System.out.println("Enter the name of the animal you created that will be the predator.");
                String predator = scan.nextLine();
                //checking that this name is actually one of the animals the user created
                int indexPredator = 0;
                boolean found = false;
                while (!found)
                {
                    for (int i = 0; i < animals.size(); i++)
                    {
                        if (animals.get(i).getName().equals(predator))
                        {
                            indexPredator = i;
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Not a valid predator. Enter another name.");
                        predator = scan.nextLine();
                    }
                }
                System.out.println("Enter the name of the animal you created that will be the prey.");
                String prey = scan.nextLine();
                //checking that this name is actually one of the animals the user created
                int indexPrey = 0;
                found = false;
                while (!found)
                {
                    for (int i = 0; i < animals.size(); i++)
                    {
                        if (animals.get(i).getName().equals(prey))
                        {
                            indexPrey = i;
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Not a valid prey. Enter another name.");
                        prey = scan.nextLine();
                    }
                }
                animals.get(indexPredator).makePredator(animals.get(indexPrey));
                System.out.print(animals.get(indexPrey).getName() + " has been added as a food source for " + animals.get(indexPredator).getName() + "." + "\n");

                //testing if user wants to quit, make another predator, or make another food source
                System.out.println("Type p to assign a predator, n to find new food sources, or c to change an animal's name (only type c if you have created a fictional animal). Type x to quit and get a summary of your ecosystem.");
                input = scan.nextLine();
            }
            else if (input.equals("n"))
            {
                System.out.println("What animal do you want to find new food sources for?");
                String animal = scan.nextLine();
                int indexAnimal = 0;
                boolean found = false;
                while (!found)
                {
                    for (int i = 0; i < animals.size(); i++)
                    {
                        if (animals.get(i).getName().equals(animal))
                        {
                            indexAnimal = i;
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Not a valid animal. Enter another name.");
                        animal = scan.nextLine();
                    }
                }
                animals.get(indexAnimal).addFoodSources();
                System.out.println("Okay, a new list of food sources had been created for " + animals.get(indexAnimal).getName() +"." + "\n");
                System.out.println("Type p to assign a predator, n to find new food sources, or c to change an animal's name (only type c if you have created a fictional animal). Type x to quit and get a summary of your ecosystem.");
                input = scan.nextLine();
            }
            else if (input.equals("c"))
            {
                System.out.println("Which animal's name do you want to change? Only pick a fictional animal. If you have not created a fictional animal type n.");
                String name = scan.nextLine();
                if (!name.equals("n"))
                {
                int indexName = 0;
                boolean found = false;
                while (!found)
                {
                    for (int i = 0; i < animals.size(); i++)
                    {
                        if (animals.get(i).getName().equals(name))
                        {
                            indexName = i;
                            found = true;
                            break;
                        }
                    }
                    if (!found)
                    {
                        System.out.println("Not a valid animal. Enter another name.");
                        name = scan.nextLine();
                    }
                }
                animals.get(indexName).setName((FictionalAnimal.changeName(animals.get(indexName).getName())).toLowerCase());
                System.out.println("This animal's name has been changed." + "\n");
                }

            System.out.println("Type p to assign a predator, n to find new food sources, or c to change an animal's name (only type c if you have created a fictional animal). Type x to quit and get a summary of your ecosystem.");
            input = scan.nextLine();
            }
        }

        String output = "";
        for (int i = 0; i < animals.size(); i++)
        {
            output += animals.get(i).toString() + "\n";
        }
        System.out.println(output + "\n");

        System.out.println("Type \"restart\" to restart." + "\n");
        restart = scan.nextLine();
        }
    }
}
