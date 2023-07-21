package assignment10;

import java.util.ArrayList;
public class Soldier
{

private int healthPoints;
private double strength;
private double armor;
private String classType = "";



public Soldier(int hp, double strength1, double armor1, String classType1)
{

if(hp > 0 && hp <= 100)
{
    healthPoints = hp;
}
else
{
    healthPoints = 50;
}

if(strength1 > 0 && strength1 <= 15)
{
    strength = strength1;
}
else
{
    strength = 5.0;
}

if(armor1 > 0 && armor1 < 50)
{
    armor = armor1;
}
else
{
    armor = 15.0;
}

if(classType1.equals("Soldier") || classType1.equals("Paladin"))
{
    classType = classType1;
} 
else
{
    classType = "Soldier";
}

}

public Soldier()
{
    this(50, 5.0, 15.0, "Soldier");
}

/*Getters*/
public int getHP()
{
    return healthPoints;
}

public double getArmor()
{
    return armor;
}

public double getStrength()
{
    return strength;
}

public String getClassType()
{
    return classType;
}

/*Setter*/
public void setArmor(double x)
{
    if(x >= 0 && x <= 50)
    {
        armor = x;
    }
}

/*Simple attack method based on strength*/
public int attack()
{
    int damage = 0;
    if(strength > 12)
    {
        damage = 30;
    }
    if(strength > 9)
    {
        damage = 25;
    }
    if(strength > 6)
    {
        damage = 15;
    }
    if(strength > 3)
    {
        damage = 10;
    }
    if(strength > 0)
    {
        damage = 5;
    }

    return damage;
}


public String toString()
{
    return "~~~~~~~~~~~~~~\n" + classType + ": " + healthPoints + "\nArmor: " + armor + "\nStrength: " + strength + "\n~~~~~~~~~~~~~~\n";
}



}