package assignment10;

public class Shoebox {
    private String color;
    private boolean full;

    public Shoebox(){
        color = "black";
        full = false;
    }

    public Shoebox (String c, boolean box){
        color = c;
        full = box;
    }
    public void setColor(String c){
        color = c;
    }
    public void setfull(boolean f){
        full = f;
    }
    public String getColor() {
        return color;
    }
    public boolean getFull() {
        return full;
    }
    public String materials() {
        if (color != "white") {
            return "This box is made of 50% recycled cardboard!";
        } else {
            return "This box is made of 100% recycled cardboard!";
        }
    }
    public String toString() {
        if (full == true) {
            return "This shoebox on your shelf is the colour " + color + " and currently its full";
        } 
        else {
            return "This shoebox on your shelf is the colour " + color + " and currently its empty";
        }
    }
}
