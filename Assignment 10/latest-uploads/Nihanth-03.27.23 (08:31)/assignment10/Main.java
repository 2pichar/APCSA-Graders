package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);
        String s = "";
        ArrayList<House> homes = new ArrayList<House>();

        while(!s.equals("e")){
                System.out.println("HI, WOULD YOU LIKE TO CREATE A HOUSE OR A APARTMENT?ENTER H FOR HOUSE, A FOR APARTMENT, e for exit");
                s = scan.nextLine();
                if(s.equals("H")){
                    System.out.println("Would you like a standard house: type in d for standard house: ");
                    String scan1 = scan.nextLine();
                    if(scan1.equals("d")){
                        House h1 = new House();
                        homes.add(h1);
                    } else {
                        System.out.println("Enter the number of bedrooms: ");
                        int b1 = scan.nextInt();
                        System.out.println("Enter the number of bathrooms: ");
                        int b2 = scan.nextInt();
                        System.out.println("Enter the type of the house: ");
                        String t = scan.nextLine();
                        System.out.println("Enter the sqft: ");
                        int sq = scan.nextInt();
                        System.out.println("Enter the price of the House: ");
                        int p = scan.nextInt();

                        House h1 = new House(b1,b2,t,sq,p);

                    }
                    
                }  else if(s.equals("A")){


                    System.out.println("Would you like a standard apartment: type in s for standard apartment: ");
                    String scan1 = scan.nextLine();
                    if(scan1.equals("s")){
                        Apartment a1 = new Apartment();
                        homes.add(a1);
                    } else {
                        System.out.println("Enter the number of bedrooms: ");
                        int b1 = scan.nextInt();
                        System.out.println("Enter the number of bathrooms: ");
                        int b2 = scan.nextInt();
                        System.out.println("Enter the type of the house: ");
                        String t = scan.nextLine();
                        System.out.println("Enter the sqft: ");
                        int sq = scan.nextInt();
                        System.out.println("Enter the price of the House: ");
                        int p = scan.nextInt();
                        System.out.println("Enter the city of the Apartment: ");
                        String c = scan.nextLine();
                        System.out.println("Enter the facilities rating: ");
                        int r = scan.nextInt();
                        System.out.println("Enter the rent: ");
                        int rent = scan.nextInt();
                        Apartment a1 = new Apartment(b1,b2,t,sq,p,r,c,rent);
                        homes.add(a1);
                    } 
                } else if(s.equals("e")){
                    break;
                }
        }


        for(int i = 0; i < homes.size();i++){
            System.out.println((homes.get(i)).toString());
        }

        System.out.println("Would you like a loan for your house? Enter y for yes, n for no");
        String scan3 = scan.nextLine();

        if(scan3.equals("n")){
            System.out.println("Exited. Thanks for using our program\n");
        } else {
            System.out.println("Enter amount: ");
            double am = scan.nextDouble();
            System.out.println("Enter rate: ");
            double r = scan.nextDouble();
            System.out.println("Enter years: ");
            int y = scan.nextInt();
            System.out.println(House.loan(am,r,y));
        }


    }
}
