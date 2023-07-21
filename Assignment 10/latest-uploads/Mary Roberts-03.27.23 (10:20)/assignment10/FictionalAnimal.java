package assignment10;

import java.util.ArrayList;

public class FictionalAnimal extends Animal
{
    private static String[][] totalFoodSources = {{"Carnivore", "bugs", "mice", "fairies", "rabbits", "geese", "gnomes", "pigs", "deer", "elk", "unicorn", "centaur"}, {"Herbivores", "berries", "grains", "grass", "Mandrakes", "dandelions", "golden apples", "cattail", "red weed", "mushrooms",}};
    private String power;
    private String[] existingPlaces = new String[3];

    //constructors
    public FictionalAnimal()
    {
        super();
        power = "unknown";
        existingPlaces[0] = "unknown";
        existingPlaces[1] = "unknown";
        existingPlaces[2] = "unknown";
    }
    public FictionalAnimal(int size, String name, ArrayList<String> foodSources, boolean carnivore, boolean herbivore, String power, String[] places)
    {
        super(size, name, foodSources, carnivore, herbivore);
        this.power = power;
        existingPlaces[0] = places[0];
        existingPlaces[1] = places[1];
        existingPlaces[2] = places[2];
    }

    //recursive unique method that reverses the animal's name
    public static String changeName(String name)
    {
        if (name.length() == 0)
        {
            return "";
        }
        else
        {
            return name.substring(name.length()-1, name.length()) + changeName(name.substring(0, name.length()-1));
        }
    }

    //toString
    public String toString()
    {
        String output = super.toString();
        output += " " + getName() + "'s special power is: " + power + ". This animal exists in ";
        for (String var : existingPlaces)
        {
            output += var + " and ";
        }
        return output.substring(0, output.length()-5) + ".";
    }

    
}