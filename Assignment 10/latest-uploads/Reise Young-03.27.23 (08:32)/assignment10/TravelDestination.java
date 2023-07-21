package assignment10;

import java.util.ArrayList;

public class TravelDestination extends Place {
   private ArrayList<String> activities;
   private int days;
  
   public TravelDestination(String name, String location, ArrayList<String> activities, int days) {
       super(name, location);
       this.activities = activities;
       this.days = days;
   }
  
   public ArrayList<String> getActivities() {
       return activities;
   }
  
   public int getDays() {
       return days;
   }
  
   @Override
   public void displayInfo() {
       super.displayInfo();
       System.out.println("Activities: " + activities);
       System.out.println("Days: " + days);
   }
  
   public void recommendActivities() {
       System.out.println("Recommended activities:");
       for (String activity : activities) {
           System.out.println("- " + activity);
       }
   }
}


