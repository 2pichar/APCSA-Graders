package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        
        Scanner scan = new Scanner(System.in);
        String a = "";
        ArrayList<House> residences = new ArrayList<House>();

        System.out.println("Welcome to the house builder! Would you like a House or a Mansion? Type h or m respectively.");
        a = scan.nextLine();
        if (a.equals("h")){
            System.out.println("Would you like a standard house, or a customizable one: type in s for standard, c for custom.");
            String b = scan.nextLine();
            if (b.equals("s")){
                House h1 = new House();
                residences.add(h1);
            } else {
                System.out.println("Enter the number of bedrooms: ");
                int b1 = scan.nextInt();
                System.out.println("Enter the number of bathrooms: ");
                int b2 = scan.nextInt();
                System.out.println("Enter the size of the house as a double in sqft: ");
                double b3 = scan.nextDouble();
                System.out.println("Enter the color you want for the exterior: ");
                String b4 = scan.nextLine();
                System.out.println("Would you like to rent it? y or n: ");
                String b5 = scan.nextLine();
                boolean b6 = true;
                if (b5.equals("n")){
                    b6 = false;
                }
                House h1 = new House(b1, b2, b3, b4, b6);
                residences.add(h1);

            }

        }
        
        else {
            System.out.println("Would you like a standard mansion, or a customizable one: type in s for standard, c for custom.");
            String c = scan.nextLine();
            if (c.equals("s")){
                Mansion m1 = new Mansion();
                residences.add(m1);
            }
            else {
                System.out.println("Enter the number of bedrooms: ");
                int c1 = scan.nextInt();
                System.out.println("Enter the number of bathrooms: ");
                int c2 = scan.nextInt();
                System.out.println("Enter the size of the house as a double in sqft: ");
                double c3 = scan.nextDouble();
                System.out.println("Enter the color you want for the exterior: ");
                String c4 = scan.nextLine();
                System.out.println("Would you like to rent it? y or n: ");
                String c5 = scan.nextLine();
                boolean c6 = true;
                if (c5.equals("n")){
                    c6 = false;
                }
                System.out.println("Enter the lot size of the house as a double in sqft: ");
                double c7 = scan.nextDouble();
                System.out.println("Enter the value of your house as a double: ");
                double c8 = scan.nextDouble();
                Mansion m1 = new Mansion(c1, c2, c3, c4, c6, c7, c8);
                residences.add(m1);

            }

        }
        for(int i = 0; i < residences.size();i++){
            System.out.println((residences.get(i)).makeHouse());
        }

        System.out.println(residences);
        
    }

}
