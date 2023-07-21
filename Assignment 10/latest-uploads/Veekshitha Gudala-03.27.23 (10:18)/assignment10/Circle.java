package assignment10;

import java.util.ArrayList;
import java.util.Arrays;

public class Circle extends Shapes {
    //3 unique variables
    private double radius; //holds radius of circle
    private double xCoordinate; //holds x coordinate of the center of the circle
    private double yCoordinate; //holds y coordinate of the center of the circle

    //default contructor
    public Circle() {
        super();
        this.radius = 1;
        this.xCoordinate = 0;
        this.yCoordinate = 0;
    }

    // constructor 2 takes radius, and coordinates and sets name and color to
    // default from superclass
    public Circle(double radius, double xCoordinate, double yCoordinate) {
        super();
        this.radius = radius;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    //contructor 3 does same thing as constructor 2 but also takes name and color
    public Circle(
        String type,
        String color,
        double radius,
        double xCoordinate,
        double yCoordinate
    ) {
        super.setType(type);
        super.setColor(color);
        this.radius = radius;
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;
    }

    //mutators
    public void setRadius(double radius) {
        this.radius = radius;
    }
    public void setXcoordinate(double xCoordinate) {
        this.xCoordinate = xCoordinate;
    }
    public void setYcoordinate(double yCoordinate) {
        this.yCoordinate = yCoordinate;
    }

    //accessors
    public double getRadius() {
        return radius;
    }
    public double getXcoordinate() {
        return xCoordinate;
    }
    public double getYcoordinate() {
        return yCoordinate;
    }

    //unique method gets circumference of the circle
    public double getCircumference() {
        return (2 * 3.14 * radius);
    }



    //overridden method
    public String toString() {
        String str = super.toString();
        return str + "\nShape radius: " + radius + "\nShape center coordinate: (" +
                xCoordinate + ", " + yCoordinate + ")";
    }

}