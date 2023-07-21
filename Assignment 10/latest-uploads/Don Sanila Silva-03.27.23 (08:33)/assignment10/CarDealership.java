package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

public class CarDealership {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Welcome to the El Toro Car Dealership! Please enter the brand of your desired car here (example Toyota, Lexus, Honda, etc): ");
        String brand = scanner.nextLine();
        System.out.print("Nice pick! Please enter the model of your desired car here(example Camry would be a model of Toyota, Civic would be a model of Honda, etc): ");
        String model = scanner.nextLine();
        System.out.print("Excellent Choice! Finally, please enter the year of your desired car: ");
        int year = scanner.nextInt();
        scanner.nextLine();

        Car car = new Car(brand, model, year);

        System.out.print("Enter the number of doors on your desired car: ");
        int numDoors = scanner.nextInt();
        scanner.nextLine();
        System.out.print("Enter the color of your desired car: ");
        String color = scanner.nextLine();

        Sedan sedan = new Sedan(brand, model, year, numDoors, color);

        System.out.println("Car Details:");
        car.printDetails();

        System.out.println("Sedan Details:");
        sedan.printDetails();

        ArrayList<String> features = new ArrayList<>();
        features.add("Sunroof");
        features.add("Ambient Lighting");
        features.add("Backup camera");
        features.add("Bluetooth");
        features.add("Massage seats");
        features.add("Recliner");
        features.add("Heated seats");

        System.out.println("Features:");
        for (int i = 0; i < features.size(); i++) {
            System.out.println("- " + features.get(i));
        }

        String[][] cars = {
                {"Toyota", "Camry", "2018"},
                {"Honda", "Civic", "2019"},
                {"Ford", "Fusion", "2020"},
                {"Lexus", "RX", "2017"},
                {"Mercedes", "AMG GT", "2020"},
                {"BMW", "M6", "2018"},
                {"Volkswagen", "Passat", "2015"},
                {"Jeep", "Wrangler", "2016"},
                {"Volvo", "XC40", "2017"},
                {"Mazda", "CX-30", "2014"},
                {"Chevy", "Corvette", "2018"},
                {"Dodge", "SRT-Hellcat", "2021"},
                {"Porsche", "GT3", "2022"},
                {"Hyundai", "Sonata", "2020"},
                {"Tesla", "Model Y", "2020"},

        };

        System.out.println("We also offer this cars at our dealership! Check them out!:");
        for (String[] carInfo : cars) {
            for (int i = 0; i < carInfo.length; i++) {
                System.out.print(carInfo[i] + " ");
            }
            System.out.println();
        }

        int[] numbers = {1, 2, 3, 4, 5};
        System.out.println("Amount of cars at this dealership:");
        System.out.println(sum(numbers, numbers.length - 1));
    }

    public static int sum(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        } else {
            return arr[index] + sum(arr, index - 1);
        }
    }
}
