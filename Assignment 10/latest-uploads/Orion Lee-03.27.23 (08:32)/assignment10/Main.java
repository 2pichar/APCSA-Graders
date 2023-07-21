package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Randomx> arrRan = new ArrayList<Randomx>();
        ArrayList<RandomChild> arrRanChild = new ArrayList<RandomChild>();
        String input = "";
        while (!input.equals("STOP")){
            System.out.println("What would you like to do? Enter \"ran\" to create a random and add it to the list, \"ran child\" to create a random child and add it the the other list, \"print\" to print out both array lists, \"sort\" to sort all of the lists, \"search\" to search for a value, \"completly random\" to do something completly random, and \"STOP\" to stop");
            input = scan.nextLine();
            if (input.equals("ran")){
                System.out.println("\"n\" for normal or \"c\" with constructors");
                input = scan.nextLine();
                if (input.equals("n")){
                    Randomx ran = new Randomx();
                    ran.fillArray();
                    arrRan.add(ran);
                }
                if (input.equals("c")){
                    System.out.println("Enter number of rows: ");
                    int rows = scan.nextInt();
                    System.out.println("Enter number of colums: ");
                    int cols = scan.nextInt();
                    System.out.println("Do you want to print after you fill this list?(\"y\" for yes \"n\" for no)");
                    scan.nextLine();
                    String input2 = scan.nextLine();
                    if (input2.equals("y")){
                        Randomx ran = new Randomx(rows, cols, true);
                        ran.fillArray();
                        arrRan.add(ran);
                    } else{
                        Randomx ran = new Randomx(rows, cols, false);
                        ran.fillArray();
                        arrRan.add(ran);
                    }
                    
                }
            } else if (input.equals("ran child")){
                System.out.println("\"n\" for normal or \"c\" with constructors");
                input = scan.nextLine();
                if (input.equals("n")){
                    RandomChild ran = new RandomChild();
                    ran.fillArray();
                    arrRanChild.add(ran);
                }
                if (input.equals("c")){
                    System.out.println("Enter number of rows: ");
                    int rows = scan.nextInt();
                    System.out.println("Enter number of colums: ");
                    int cols = scan.nextInt();
                    System.out.println("Enter the maximum random value: ");
                    int mx = scan.nextInt();
                    System.out.println("Enter the minimum random value: ");
                    int mn = scan.nextInt();
                    System.out.println("Do you want to print after you fill this list?(\"y\" for yes \"n\" for no)");
                    scan.nextLine();
                    String input2 = scan.nextLine();
                    if (input2.equals("y")){
                        RandomChild ran = new RandomChild(rows, cols, true, mx, mn);
                        ran.fillArray();
                        arrRanChild.add(ran);
                    }else {
                        RandomChild ran = new RandomChild(rows, cols, false, mx, mn);
                        ran.fillArray();
                        arrRanChild.add(ran);
                    }
                }
            } else if (input.equals("print")){
                for (int i = 0; i < arrRan.size(); i++){
                    System.out.println(arrRan.get(i));
                }
                for (int i = 0; i < arrRanChild.size(); i++){
                    System.out.println(arrRanChild.get(i));
                }
            } else if (input.equals("sort")){
                for (int i = 0; i < arrRan.size(); i++){
                    arrRan.get(i).sort2D();
                }
                for (int i = 0; i < arrRanChild.size(); i++){
                    arrRanChild.get(i).sort2D();
                }
            } else if (input.equals("search")){
                for (int i = 0; i < arrRan.size(); i++){
                    arrRan.get(i).sort2D();
                }
                for (int i = 0; i < arrRanChild.size(); i++){
                    arrRanChild.get(i).sort2D();
                }
                System.out.println("Please enter what you are searching for: ");
                int x = scan.nextInt();
                System.out.println("Please enter if you want to search through random (\"r\") or random child (\"rc\"): ");
                scan.nextLine();
                input = scan.nextLine();
                System.out.println("Please enter the random you want to search: ");
                int rd = scan.nextInt();
                System.out.println("Please enter the row to search: ");
                int rw = scan.nextInt();
                if (input.equals("r")){
                    System.out.println(arrRan.get(rd-1).binary2D(arrRan.get(rd-1).breakArray(rw), 0, arrRan.get(rd-1).breakArray(rw).length-1, x));
                }
                if (input.equals("rc")){
                    System.out.println(arrRanChild.get(rd-1).binary2D(arrRanChild.get(rd-1).breakArray(rw), 0, arrRanChild.get(rd-1).breakArray(rw).length-1, x));
                }
            } else if (input.equals("completly random")){
                for (int i = 0; i < arrRanChild.size(); i++){
                    arrRanChild.get(i).insaneRandom();
                }
            }
        }
        
    }

}
