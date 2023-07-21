package assignment10;

import java.util.*;
public class Main {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        System.out.println("Hello! What kind of party would you like to throw? (1 for regular, 2 for dinner)" );
        Scanner scan = new Scanner(System.in);
        int in = scan.nextInt();
        
        if (in!= 1 || in!=2) {
            System.out.println("Invalid answer. Please restart the program.");
        } else {
            if(in == 1) {
                System.out.println("Basic party initialized. Please enter your number of guests below:");
                int guests = scan.nextInt();
                System.out.println("Now enter the names of your guests:"); 
                String[] names = new String[guests];
                   for(int i = 0; i < guests; i++){
                    names[i] = scan.nextLine();
                    
                }
            } else if (in == 2) {
                System.out.println("Dinner party initialized.");
            }
        }
        



        String list[] = new String[]{"Joe", "Bob", "Tommy", "Tim", "James"};
        Party party = new Party(5, "Joe's House", list);
        
        party.throwParty();
    }

}
