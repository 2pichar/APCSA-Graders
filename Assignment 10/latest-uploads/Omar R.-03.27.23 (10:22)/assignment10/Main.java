package assignment10;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System. in);
        ArrayList<Apartment> apartments = new ArrayList<>();
        Apartment[] filteredApartments;
        String[][] apartmentTable;
        String yOrN = "";
        int counter = 0;
        int minPrice = 0;
        int maxPrice = 0;
        int filterInput = 0;
        int aptNum = 0;
        int numOfMonths = 0;

        while (true) {
            System.out.println("\nChoose an option:");
            System.out.println("1. Add an apartment");
            System.out.println("2. Display all apartments");
            System.out.println("3. Calculate rent for an apartment");
            System.out.println("4. Exit");
            System.out.print("Option: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline left-over

            if (choice == 1) {
                // User input for creating an instance of the SubClass
                System.out.println("\nEnter the apartment address:");
                String address = scanner.nextLine();
                System.out.println("Enter the number of rooms:");
                int numberOfRooms = scanner.nextInt();
                System.out.println("Enter the monthly rent:");
                int monthlyRent = scanner.nextInt();
                System.out.println("Does the apartment have a balcony? (yes/no)");
                scanner.nextLine(); // Consume newline left-over
                String balconyInput = scanner.nextLine();
                boolean hasBalcony = balconyInput.equalsIgnoreCase("yes");

                Apartment apartment = new Apartment(
                    address,
                    numberOfRooms,
                    monthlyRent,
                    hasBalcony
                );
                apartments.add(apartment);
                System.out.println("\nApartment added successfully!");

            } else if (choice == 2) {
                // Display all apartments
                filteredApartments = null;
                while (true) {
                    System.out.println("\nChoose a filter:");
                    System.out.println("1. Price Range");
                    System.out.println("2. None of the Above");
                    System.out.print("Filter: ");
                    filterInput = scanner.nextInt();
                    if (filterInput > 0 && filterInput <= 2) {
                        break;
                    } else {
                        System.out.println("Invalid choice. Please choose a valid option.");
                    }
                }
                if (filterInput == 1) {
                    while (true) {
                        System.out.print("\nMinimum: ");
                        minPrice = scanner.nextInt();
                        System.out.print("Maximum: ");
                        maxPrice = scanner.nextInt();
                        if (minPrice >= 0 && maxPrice >= minPrice) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please choose a valid option.");
                        }
                    }
                    counter = 0;
                    for (int i = 0; i < apartments.size(); i++) {
                        if (apartments.get(i).getRent() < maxPrice) {
                            counter++;
                        }
                    }
                    filteredApartments = new Apartment[counter];
                    counter = 0;
                    for (Apartment apt : apartments) {
                        if (apt.getRent() >= minPrice && apt.getRent() <= maxPrice) {
                            filteredApartments[counter] = apt;
                            counter++;
                        }
                    }
                    counter = 0;
                    for (Apartment filteredOutput : filteredApartments) {
                        System.out.println("\nApartment " + (
                            counter + 1
                        ) + ":");
                        filteredOutput.printDetails();
                        counter++;
                    }
                    while (true) {
                        System.out.println("\nWould you like it in table form? (y/n)");
                        yOrN = scanner.nextLine();
                        if (yOrN.toLowerCase().equals("y") || yOrN.toLowerCase().equals("n")) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please choose a valid option.");
                        }
                    } 
                    if (yOrN.toLowerCase().equals("y")) {
                    apartmentTable = null;
                    apartmentTable = new String[counter][2];
        counter = 0;
        System.out.println();
        for (Apartment filteredOutput : filteredApartments) {
                      apartmentTable[counter][0] = ("Address: " + filteredOutput.getAddress() + "\t");
                      counter++;  
                    }
                    counter = 0;
                    for (Apartment filteredOutput : filteredApartments) {
                      apartmentTable[counter][1] = ("Rent: " + filteredOutput.getRent());
                      counter++;  
                    }
        for(String[] r : apartmentTable) {
          for(String n : r) {
            System.out.print(n + "\t");
         }
        }
         System.out.println();

        }
                } else {
                    System.out.println("\nList of apartments:");
                    for (int i = 0; i < apartments.size(); i++) {
                        System.out.println("\nApartment " + (
                            i + 1
                        ) + ":");
                        apartments.get(i).printDetails();
                    }
                    // Checks for apartments
                    if (apartments.size() == 0) {
                        System.out.println("\nThere are currently no apartments.");
                    }
                }

            } else if (choice == 3) {
                if (apartments.size() > 0) {
                    while (true) {
                        System.out.println("\nFrom the following apartments:");
                        for (int i = 0; i < apartments.size(); i++) {
                            System.out.println("\nApartment " + (
                                i + 1
                            ) + ":");
                            apartments.get(i).printDetails();
                        }
                        System.out.println("\nWhich apartment number?");
                        aptNum = scanner.nextInt();
                        if (aptNum <= apartments.size() && aptNum > 0) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please choose a valid option.");
                        }
                    }
                    while (true) {
                        System.out.println(
                            "How many months are you looking to calculate the rent for?"
                        );
                        numOfMonths = scanner.nextInt();
                        if (numOfMonths > 0) {
                            break;
                        } else {
                            System.out.println("Invalid choice. Please choose a valid option.");
                        }
                    }
                    System.out.println(
                        "\nThe rent for Apartment " + aptNum + " for " + numOfMonths + " months is $" +
                        apartments.get(aptNum - 1).calcRent(numOfMonths)
                    );
                } else {
                    System.out.println("There are currently no apartments.");
                }

            } else if (choice == 4) {
                System.out.println("\nExiting the program...");
                break;
            } else {
                System.out.println("\nInvalid choice. Please choose a valid option.");
            }
        }

        scanner.close();
    }
}
