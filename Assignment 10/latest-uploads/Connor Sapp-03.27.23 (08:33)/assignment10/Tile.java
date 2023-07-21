package assignment10;

public class Tile{
    public boolean dug;
    private int xPos;
    private int yPos;

    public Tile(){
        dug = false;
    }

    public Tile(boolean d){
        dug = d;
    }

    public String toString(){
        if(dug)
            return "🕳 ";
        return "🌱";
    }

    public boolean getDug(){
        return dug;
    }

    public void digUp(){
        dug = true;
        System.out.println("\nThere was nothing there.\n");
    }
    
}