package assignment10;

public class Car extends Vehicle{
    
    public String manufacturer;
    public int model;

    public Car(String manufacturer, int model){
        this.manufacturer = manufacturer;
        this.model = model;
    }

    public Car(){
        this("Toyota", 01);
    }

    public int model_number(int model){
        boolean b = true;
        if(b == true){
            return model;
        }
        return (model_number(model + 1));
    }

    public String toString(){
        return (super.toString() + "\nManufacturer: " + manufacturer + "\nModel Number: " + model);
    }

}