package assignment10;

import java.util.ArrayList;

public class Animal 
{
    private int size;
    private String name;
    private ArrayList<String> foodSources = new ArrayList<String>();
    private boolean carnivore;
    private boolean herbivore;
    private static String[][] totalFoodSources = {{"bugs", "mice", "rabbits", "geese", "pigs", "deer", "elk"}, {"berries", "grains", "grass", "dandelions", "cattail", "mushrooms", "apples"}};


    //default constructor
    public Animal()
    {
        size = 2;
        name = "unknown";
        //assigns 4 or less random food sources for an omnivore
        for (int r = 0; r < totalFoodSources.length; r++)
        {
            for (int times = 0; times < 2; times++)
            {
                foodSources.add(totalFoodSources[r][(int)(Math.random()*7)]);
            }
        }
        //checks for foodSources duplicates
        for (int i = 0; i < foodSources.size(); i++)
        {
            for (int j = foodSources.size()-1; j > i; j--)
            {
                if (foodSources.get(i) == foodSources.get(j))
                {
                    foodSources.remove(j);
                }
            }
        }
        carnivore = false;
        herbivore = false;
    }
    //complete constructor
    public Animal(int size, String name, ArrayList<String> foodSources, boolean carnivore, boolean herbivore)
    {
        this.size = size;
        this.name = name;
        this.foodSources = foodSources;
        this.carnivore = carnivore;
        this.herbivore = herbivore;
    }

    //unique method makes this animal the predator of whatever is inputed in the parameter
    public void makePredator(Animal prey)
    {
        if (size < prey.getSize() || !herbivore)
        {
            foodSources.add(prey.getName());
        }
        else 
        {
            System.out.println(prey.getName() + " is not a valid food source.");
        }
    }
    //method to add food sources (traverse 2d array)
    public void addFoodSources()
    {
        for (int l = foodSources.size()-1; l >= 0; l--)
        {
            foodSources.remove(l);
        }
        for (int i = 0; i < totalFoodSources.length; i++)
        {
            if (carnivore && i == 0)
            {
                for (int c = 0; c < totalFoodSources[i].length; c++)
                {
                    foodSources.add(totalFoodSources[i][c]);
                }
            }
            else if (herbivore && i == 1)
            {
                for (int h = 0; h < totalFoodSources[i].length; h++)
                {
                    foodSources.add(totalFoodSources[i][h]);
                }
            }
            else if (!(carnivore||herbivore))
            {
                for (int o = 0; o < totalFoodSources[i].length/2; o++)
                {
                    foodSources.add(totalFoodSources[i][o]);
                }            
            }
        }
    }
    
    //getters and setters
    public int getSize()
    {
        return size;
    }
    public String getName()
    {
        return name;
    }
    public void setName(String name)
    {
        this.name = name;
    }
    
    
    //toString
    public String toString()
    {
        String output = "";
        if (carnivore)
        {
            if (size == 1)
            {
            output += name + " is a small sized animal. " + name + " is a carnivore who eats ";
            }
            else if (size == 2)
            {
                output += name + " is a medium sized animal. " + name + " is a carnivore who eats ";
            }
            else
            {
                output += name + " is a large sized animal. " + name + " is a carnivore who eats ";
            }
        }
        else if (herbivore)
        {
            if (size == 1)
            {
            output += name + " is a small sized animal. " + name + " is an herbivore who eats ";
            }
            else if (size == 2)
            {
                output += name + " is a medium sized animal. " + name + " is an herbivore who eats ";
            }
            else
            {
                output += name + " is a large sized animal. " + name + " is an herbivore who eats ";
            }
        }
        else
        {
           if (size == 1)
            {
            output += name + " is a small sized animal. " + name + " is an omnivore who eats ";
            }
            else if (size == 2)
            {
                output += name + " is a medium sized animal. " + name + " is an omnivore who eats ";
            }
            else
            {
                output += name + " is a large sized animal. " + name + " is an omnivore who eats ";
            }
        }

        if (foodSources.size() == 1)
        {
            output += foodSources.get(0) + ".";
        }
        else if (foodSources.size() == 2)
        {
            output += foodSources.get(0) + " and " + foodSources.get(1) + ".";
        }
        else
        {
            for (int i = 0; i < foodSources.size()-1; i++)
            {
                output += foodSources.get(i) + ", ";
            }
            output += "and " + foodSources.get(foodSources.size()-1) + ".";
        }
        return output;

    }
}