package assignment10;

import java.util.*;
public class runner
{
          private static Scanner scan;
    private static ArrayList<Part> parts = new ArrayList<>();
      private static String instruct;
    
    public static void main(String[] args)
  {
      scan = new Scanner(System.in);
      instruct = "";
        parts.add(new CPU("Ryzen 5 3500", "AMD", 189.99, 6, 3.6));
        parts.add(new CPU("Core i7-11700K", "Intel", 243.99, 8, 3.6));
        
        
        while(!instruct.equals("q")){
      System.out.println("Type \"s\" to add a CPU, \"t\" to test methods, \"q\" to quit.");
      instruct = scan.nextLine();
      if(instruct.equals("s"))
      {
        addCPU();
        //System.out.println("Do you want to overclock? Yes or No (This is broken as of right now. idk if im gonna fix this so just say no lol)");
        instruct = scan.nextLine();
      }
      else if(instruct.equals("t"))
      {
        testMethods();
        }
      else if(!instruct.equals("q"))
      {
        System.out.print("Instruction not recognized");
      System.out.println();
      }
      if(instruct.equals("Yes"))
      {
          String tempParts = "";
          //Arraylist loop (I dont know if this will work but this is using another variable but its basically the same thing as the original arraylist i think)
            for(int i = 0; i < parts.size(); i++)
            {
                tempParts += "\n" + (i+1) + ". " + parts.get(i).toString();
            }
            System.out.println(tempParts);
            System.out.println("Enter which CPU number you want to overclock");
        int cpuOverclock = scan.nextInt();
        System.out.println("What do you want to overclock it to?");
        Double tempForOverclock = scan.nextDouble();
        if(parts.get(cpuOverclock) instanceof CPU) {    
        ((CPU)parts.get(cpuOverclock)).setOverclock(tempForOverclock);
        }
        else
        {
        System.out.println("This part is not a CPU");
        }

    }
  }
  }

public static void testMethods() {
    while (!instruct.equals("q") && !instruct.equals("m")) {
        System.out.println("Type a method to call (toString, calculateTotalPrice, table, isExpensive, or equals). Or type \"m\" for main menu, \"q\" to quit");
        instruct = scan.nextLine();
        if (instruct.equals("toString")) 
        {
            System.out.println(parts.toString());
        } 
        else if (instruct.equals("equals")) 
        {
            String tempParts = "";
            for(int i = 0; i < parts.size(); i++)
            {
                tempParts += "\n" + (i+1) + ". " + parts.get(i).toString();
            }
            System.out.println(tempParts);
            System.out.println("Enter the number of the 1st CPU you want to compare:");
        int cpu1 = scan.nextInt();
        System.out.println("Enter the number of the 2nd CPU you want to compare:");
        int cpu2 = scan.nextInt();

        if(parts.get(cpu1-1).equals(parts.get(cpu2-1)))
        {
            System.out.println("They are equal.");
        }
        else
        {
            System.out.println("They are not equal");
        }
        }
        else if (instruct.equals("calculateTotalPrice")) 
        {
            System.out.println("The total price is: " + calculateTotalPrice(parts));
        } 
        else if (instruct.equals("table")) 
        {
            String[][] table = table(parts);
            System.out.println(toString2D(table));
        } 
       
        else if(instruct.equals("isExpensive"))
        {
            String tempParts = "";
            for(int i = 0; i < parts.size(); i++)
            {
                tempParts += "\n" + (i+1) + ". " + parts.get(i).toString();
            }
            System.out.println(tempParts);
                System.out.println("Enter which cpu to test this method.");
        int discountCpuName = scan.nextInt();
    double cpuPrice = parts.get(discountCpuName-1).getPrice();
    System.out.println(cpuPrice);
    System.out.println(Part.isExpensive(cpuPrice));
        }
        
    }
}




public static String[][] table(ArrayList<Part> parts) {
    String[] cpuNames = new String[parts.size()];
    int cpuCount = 0;
    //array loop
    for (Part p : parts) {
        if (p instanceof CPU) {
            CPU cpu = (CPU) p;
            cpuNames[cpuCount] = cpu.getName();
            cpuCount++;
        }
    }
    String[][] tableStuff = new String[cpuCount][5];
    //2d array loop
    for (int i = 0; i < cpuCount; i++) {
        CPU cpu = null;
        for (int j = 0; j < parts.size(); j++) {
            Part p = parts.get(j);
            if (p instanceof CPU && p.getName().equals(cpuNames[i])) {
                cpu = (CPU) p;
                break;
            }
        }
        tableStuff[i][0] = cpu.getName();
        tableStuff[i][1] = cpu.getManufacturer();
        tableStuff[i][2] = Double.toString(cpu.getPrice());
        tableStuff[i][3] = Integer.toString(cpu.getNumCores());
        tableStuff[i][4] = Double.toString(cpu.getClockSpeed());
    }
    return tableStuff;
}

public static String toString2D(String[][] parts) {
    String seeBoard = "";
    for (int i = 0; i < parts.length; i++) {
        for (int j = 0; j < 5; j++) {
            seeBoard += parts[i][j] + " ";
        }
        seeBoard += "\n";
    }
    return seeBoard;
}



  public static void addCPU()
  {
       System.out.println("Enter the amount of CPUs you want to add");
 int numCPUs = scan.nextInt();
 
 for(int i = 0; i < numCPUs; i++)
 {
     System.out.println("Enter CPU " + (i + 1) + " info:");
     scan.nextLine();
     System.out.println("Name: ");
     String name = scan.nextLine();
     System.out.println("Manufacturer: ");
     String manufacturer = scan.nextLine();
     System.out.println("Price: ");
     double price = scan.nextDouble();
     System.out.println("Number of cores: ");
     int numCores = scan.nextInt();
     System.out.println("Clock Speed: ");
     double clockSpeed = scan.nextDouble();
     parts.add(new CPU(name, manufacturer, price, numCores, clockSpeed));
 }
  }
 
public static double calculateTotalPrice(ArrayList<Part> parts1) {
        double total = 0;
        for (int i = 0; i < parts1.size(); i++) {
            total += parts1.get(i).getPrice();
            if (parts1.get(i) instanceof CPU && i==parts1.size()) {
                CPU cpu = (CPU) parts1.get(i);
                ArrayList<Part> cpuParts = new ArrayList<Part>();
                cpuParts.add(cpu);
                total += calculateTotalPrice(cpuParts);
            }
        }
        return total;
    }

}