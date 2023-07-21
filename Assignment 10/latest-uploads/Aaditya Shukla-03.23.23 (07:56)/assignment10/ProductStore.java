package assignment10;

import java.util.ArrayList;
import java.util.Scanner;


public class ProductStore {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to Apple, Please enter the product model! (Iphone 12 Pro): ");
        String models = scan.nextLine();
        System.out.print("Cool! Now, enter the color of the product (ex. Blue) Please enter here: ");
        String colors = scan.nextLine();
        System.out.print("Enter the amount of storage you want: ");
        int storages = scan.nextInt();
        scan.nextLine();


        Iphone iphone = new Iphone(models, colors, storages);


        System.out.print("Enter the CPU you want: ");
        String CPU = scan.nextLine();
        System.out.print("Enter the GPU you want: ");
        String GPU = scan.nextLine();
        System.out.println("Enter the operating system you want: ");
        String operating = scan.nextLine();


        Macbook combo = new Macbook(models, colors, storages, CPU, GPU, operating);


        iphone.printModel();


        iphone.printColStorage();


        combo.printDetails();


        //ArrayList
        ArrayList<String> colorScheme = new ArrayList<>();
        colorScheme.add("Matte Black");
        colorScheme.add("Midnight");
        colorScheme.add("Silver");
        colorScheme.add("White");


        System.out.println("Color Schemes:");
        for (int i = 0; i < colorScheme.size(); i++) {
            System.out.println("- " + colorScheme.get(i));
        }


        //2D ArrayList
        String[][] phones = {
                {"Iphone 12", "Blue", "64"},
                {"Iphone 10", "Black", "128"},
                {"Iphone 13", "Green", "256"},
                {"Iphone 8", "White", "32"},
                {"Iphone 14", "Black", "128"},
                {"Iphone 13 Pro", "Mint", "64"},
                {"Iphone 11 Pro", "Red", "64"},
                {"Iphone 10 Pro", "Blue", "128"},
                {"Iphone 13", "Black", "256"},
                {"Iphone 7", "White", "32"},
                {"Iphone 6", "White", "64"},
                {"Iphone 15", "White", "1000"},
                {"Iphone 11 Pro Max", "Yellow", "500"},
                {"Iphone 13 Pro Max", "White", "256"},
                {"Iphone 14 Pro Max", "Green", "1000"},
            };


        System.out.println("We also offer other great products:");
        for (String[] morePhones : phones) {
            for (int i = 0; i < morePhones.length; i++) {
                System.out.print(morePhones[i] + " ");
            }
            System.out.println();
        }


        int[] productNumbers = {1, 2, 3, 4, 5};
        System.out.println("Number of products at this store:");
        System.out.println(sum(productNumbers, productNumbers.length - 1));
    }


    //Recursion
    public static int sum(int[] arr, int index) {
        if (index == 0) {
            return arr[index];
        } else {
            return arr[index] + sum(arr, index - 1);
        }
    }
}



