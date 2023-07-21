package assignment10;

public class Shapes {
    //4 unique variables
    private String type; //holds type of shape
    private String color; //holds color of shape
    private double len; //holds the length of the shape
    private double wid; //holds the width of the shape

    //default contructor
    public Shapes() {
        this.type = "circle";
        this.color = "blue";
        this.len = 1;
        this.wid = 1;
    }

    public Shapes(String type, String color) {
        this.type = type;
        this.color = color;
    }

    //constructor 2 with 4 parameters (name, color, length, width)
    public Shapes(String type, String color, double len, double wid) {
        this.type = type;
        this.color = color;
        this.len = len;
        this.wid = wid;
    }

    //mutators
    public void setType(String type) {
        this.type = type;
    }
    public void setColor(String color) {
        this.color = color;
    }
    public void setLen(double len) {
        this.len = len;
    }
    public void setWid(double wid) {
        this.wid = wid;
    }

    //accessors
    public String getType() {
        return type;
    }
    public String getColor() {
        return color;
    }
    public double getLen() {
        return len;
    }
    public double getWid() {
        return wid;
    }

    // unique methods finds area of the shape if it is a triangle, square, or
    // rectangle
    public double getArea() {
        String shapeType = type.toLowerCase();
        if (shapeType.equals("rectangle") || shapeType.equals("square")) {
            return (len * wid);
        } else if (shapeType.equals("triangle")) {
            return (0.5 * len * wid);
        } else if (len == wid && shapeType.equals("circle")) {
            return (3.14 * len * wid);
        } else {
            return 0;
        }

    }

    //overridden method
    public String toString() {
        String str = "Shape type: " + type + "\nShape color: " + color;
        return str;
    }

}