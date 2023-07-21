package assignment10;

public class Sedan extends Car {
    private int numDoors;
    private String color;
    private int seats;

public Sedan(String brand, String model, int year, int numDoors, String color, int seats) {
    super(brand, model, year);
    this.numDoors = 4;
    this.color = color;
}
    public Sedan(String brand, String model, int year, int numDoors, String color) {
        super(brand, model, year);
        this.numDoors = numDoors;
        this.color = color;
    }

    //Overridden method
    public void printDetails() {
        super.printDetails();
        System.out.println("Number of doors: " + numDoors);
        System.out.println("Color: " + color);
    }

    public static void drive() {
        System.out.println("Driving sedan...");
    }
}