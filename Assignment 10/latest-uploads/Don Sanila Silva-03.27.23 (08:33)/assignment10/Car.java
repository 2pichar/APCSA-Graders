package assignment10;

public class Car {
    protected String brand;
    protected String model;
    protected int year;

public Car (String brand, String model){
    this.brand = brand;
    this.model = model;
    this.year = 2021;
}
    public Car(String brand, String model, int year) {
        this.brand = brand;
        this.model = model;
        this.year = year;
    }

    public void printDetails() {
        System.out.println("Brand: " + brand);
        System.out.println("Model: " + model);
        System.out.println("Year: " + year);
    }

    public void printGreatChoice() {
        System.out.println("Excellent choice!");
    }
}