package assignment10;

import java.util.ArrayList;

public class Treasure extends Tile{
    private String name;
    private String icon;
    private int value;
    private static ArrayList<Treasure> backpack = new ArrayList<Treasure>();
    private static int bagValue; 

    public Treasure(){
        String[] names = {"pebble", "doubloon", "old fossil", "rusted dagger", "rusted shield", "royal crown", "precious gem", "diamond ring", "magic orb", "ancient statue"};
        String[] icons = {"🪨","🪙 ","🦴","🗡️ ","🛡️ ","👑","💎","💍","🔮","🗿"};
        int rand = ((int)(Math.random()*10));
        name = names[rand];
        icon = icons[rand];
        value = rand*100;
    }

    public Treasure(String n, String i, int v){
        name = n;
        icon = i;
        value = v;
    }


    public String toString(){
        if(getDug())
            return icon;
        return "🌱";
    }

    public void digUp(){
        dug = true;
        System.out.println("\nYou found a " + name + "!\n");
        backpack.add(this);   
        bagValue += this.value;
    }

    public static void getBag(){
        System.out.println("What a good haul! You found:");
        System.out.println();
        for(int i = 0; i < backpack.size(); i++){
            System.out.println(backpack.get(i).icon + " " + backpack.get(i).name + " - $" + backpack.get(i).value);
        }

        System.out.println();
        System.out.println("Your excavation yielded a profit of $" + bagValue + "!");

    
    }

}