package assignment10;

public class Vehicle{
    
    public int max_speed;
    public int mpg; //miles per gallon
    
    public Vehicle(int max_speed, int mpg){
        this.max_speed = max_speed;
        this.mpg = mpg;
    }

    public Vehicle(){
        this(60, 22);
    }

    public int increase_max_speed(int increase){
        max_speed += increase;
        return max_speed;
    }

    public String toString(){
        return ("Max Speed: " + max_speed + "mph" + "\nMiles Per Gallon: " + mpg);
    }
}