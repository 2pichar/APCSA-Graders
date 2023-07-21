package assignment10;

public class Iphone {
    private String model;
    private String color;
    private int storage;


    public Iphone(String model, String color, int storage) {
        this.model = model;
        this.color = color;
        this.storage = storage;
    }


    public void printModel() {
        System.out.println("Model: " + model);
    }


    public void printColStorage() {
        System.out.println("Color: " + color);
        System.out.println("Storage: " + storage);
    }
}

