package assignment10;

public class Place {
   protected String name;
   protected String location;
  
   public Place(String name, String location) {
       this.name = name;
       this.location = location;
   }
  
   public String getName() {
       return name;
   }
  
   public String getLocation() {
       return location;
   }
  
   public void displayInfo() {
       System.out.println("Name: " + name);
       System.out.println("Location: " + location);
   }
}