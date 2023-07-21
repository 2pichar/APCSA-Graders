package assignment10;


public class Macbook extends Iphone {
    private String cpu;
    private String gpu;
    private String OS;


    public Macbook(String model, String color, int storage, String cpu, String gpu, String OS) {
        super(model, color, storage);
        this.cpu = cpu;
        this.gpu = gpu;
        this.OS = OS;
    }


    //Overridden method
    public void printDetails() {
        super.printModel();
        super.printColStorage();
        System.out.println("CPU: " + cpu);
        System.out.println("GPU: " + gpu);
        System.out.println("OS: " + OS);
    }


    public static void operate() {
        System.out.println("Computer is turning on");
    }
}
