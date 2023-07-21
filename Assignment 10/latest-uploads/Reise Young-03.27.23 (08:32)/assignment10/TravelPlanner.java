package assignment10;

import java.util.ArrayList;
import java.util.Scanner;


public class TravelPlanner {
   public static void main(String[] args) {
       Scanner scanner = new Scanner(System.in);
      
       // 2D Array example
       String[][] countries = {{"Canada", "USA", "Mexico"}, {"France", "Germany", "Italy"}};
       for (String[] continent : countries) {
           for (String country : continent) {
               System.out.print(country + " ");
           }
           System.out.println();
       }
      
       // Recursive function example
       int factorial = calculateFactorial(5);
       System.out.println("Factorial of 5 is: " + factorial);
      
       // ArrayList example
       ArrayList<TravelDestination> destinations = new ArrayList<>();
       destinations.add(new TravelDestination("Hawaii", "USA", new ArrayList<String>() {{
           add("Beach activities");
           add("Hiking");
           add("Snorkeling");
       }}, 7));
       destinations.add(new TravelDestination("Tokyo", "Japan", new ArrayList<String>() {{
           add("Sightseeing");
           add("Shopping");
           add("Eating");
       }}, 5));
       destinations.add(new TravelDestination("Paris", "France", new ArrayList<String>() {{
           add("Museum visits");
           add("Wine tasting");
           add("Café hopping");
       }}, 4));
      
       // For each loop example
       for (TravelDestination destination : destinations) {
           destination.displayInfo();
           destination.recommendActivities();
           System.out.println();
       }
      
       // Standard for loop example with user input
       System.out.print("Enter a location to search for: ");
       String location = scanner.nextLine();
       for (int i = 0; i < destinations.size(); i++) {
           if (destinations.get(i).getLocation().equals(location)) {
               destinations.get(i).displayInfo();
           }
       }
      
       scanner.close();
   }
  
   public static int calculateFactorial(int num) {
       if (num == 0) {
           return 1;
       }
       return num * calculateFactorial(num - 1);
   }
}
