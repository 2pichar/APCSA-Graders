package assignment10;

import java.util.ArrayList;

public class Paladin extends Soldier
{
    ArrayList<Paladin> activePaladins1 = new ArrayList<Paladin>();
    private String skillMove = "Reinforce";

    
    /*Long constructor*/
    public Paladin(int hp, double strength1, double armor1)
    {
        super(hp, strength1, armor1, "Paladin");

        activePaladins1.add(this);
    }

    /*Default constructor*/
    public Paladin()
    {
        super(50,10,30,"Paladin");

        activePaladins1.add(this);
    }

    /*Getters*/
    public String getSkillMove()
    {
        return skillMove;
    }

    public double getArmor()
    {
        return super.getArmor();
    }

    public double getStrength()
    {
        return super.getStrength();
    }
    
    public String getClassType()
    {
        return super.getClassType();
    }


    /*These variables are used to help determine the value for reinforceBuff()*/
    double x = getArmor();
    double sum = 0;

    /*Calculates the armor buff that the Paladin will give*/
    public double reinforceBuff()
    {
        if (x == 0)
       {
           x = getArmor();
           return sum * 0.1;
       }

       sum += x;
       x--; 
       return reinforceBuff();
    }
    
    /*Simple attack method based on strength. Overriden*/
    public int attack()
    {
        return super.attack();
    }
    

    public String toString()
{
    return super.toString();
}


}