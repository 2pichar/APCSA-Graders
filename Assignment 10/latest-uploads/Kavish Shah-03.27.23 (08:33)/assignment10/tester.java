package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class tester {
    public static void printinventorybackwards(int n)
  {
    if (n > 0) { 
      printinventorybackwards(n - 1);
    }
      System.out.print(n);
    }
    public static void main(String[] args) {

    Scanner scan = new Scanner(System.in);

    ArrayList<Shoebox> emptyboxes = new ArrayList<Shoebox>();
    ArrayList<Shoebox> boxes = new ArrayList<Shoebox>();
    Shoes[] shoes = new Shoes[20];
    Shoes[][] allshoes = new Shoes[5][6];

  
    System.out.println("Welcome to your automated shoe inventory analyst!");
    System.out.println("First, input the amount of shoes you would like to store!(preferably between 10 and 20):");
    int amount = scan.nextInt();
    String[] materials = new String[amount];
    int[][] grid  = new int[5][10];
    System.out.println("Now it's time to fill up your store with shoes!");
    for (int i = 0; i < amount; i++){
        Shoebox s1 = new Shoebox();
        System.out.println("Shoebox color: "); // ask why the next line isn't working
        String color = scan.nextLine();
        s1.setColor(color);
        System.out.println("Is the box full(true) or empty(false)?: ");
        boolean full = scan.nextBoolean();
        s1.setfull(full);
        if (full == true) {
            Shoes s2 = new Shoes();
            System.out.println("Shoe size: ");
            int size = scan.nextInt();
            s2.setShoeSize(size);
            System.out.println("What is this shoe made of? (plastic, leather, or polyester): ");
            String material = scan.nextLine();
            s2.setMaterial(material);
            materials[i] = material;
            allshoes[i][i] = s2;
        } else {
            emptyboxes.add(s1);
        }
    }
    while (true) {
        System.out.println("Press 0 for feature, Press 1 for feature 1 and Press 2 for feature 2, Press 3 for feature 3 and Press 4 to exit:");
        int num = scan.nextInt();
        if (num == 0) {
            int counter = 0;
            for (String i : materials) {
                System.out.println(i);
            }
        } else if (num == 1) {
            for (int i = 0; i < emptyboxes.size(); i++) {
                System.out.println(emptyboxes.get(i).getColor());
            }
        } else if (num == 2) {
            printinventorybackwards(20);
        } else if (num == 3) {
            double averagesize = 0;
            for (int r = 0; r < allshoes.length; r++) 
            {
                double sum = 0;
                for (int c = 0; c < allshoes[0].length; c++)
                {
                sum += allshoes[r][c].getSize();
                }
                averagesize = sum / allshoes[0].length;
            }
        }
    }
    // array containing the recycling content of each of the shoes- iterating will output number of 50% and number of 100%s
    // arraylist containing the empty shoeboxes
    }
}