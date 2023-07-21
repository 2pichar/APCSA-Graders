package assignment10;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Runner {
    public static void main(String[] args) throws IOException {
        Scanner sc = new Scanner(System.in);
        System.out.println("Type p to make one pizza or type o to create an entire order");
        String input = sc.next();
        if (input.equalsIgnoreCase("p")) {
            System.out.println("Enter your pizza toppings here:");
            String toppings = sc.next();
            Pizza p;
            if (toppings.equalsIgnoreCase("veggie")) {
                System.out.println("Do you want gluten-free? (y/n)");
                String gfInput = sc.next();
                boolean isGlutenFree = false;
                if (gfInput.equalsIgnoreCase("y")) {
                    isGlutenFree = true;
                }
                p = new VeggiePizza("", "medium", "Coke", "mushrooms", isGlutenFree);
                System.out.println("Do you want to add more veggies? (y/n)");
                String moreVeggiesInput = sc.next();
                if (moreVeggiesInput.equalsIgnoreCase("y")) {
                    System.out.println("Enter additional veggies separated by spaces:");
                    String additionalVeggies = sc.next();
                    ((VeggiePizza) p).addVeggies(additionalVeggies);
                }
            } else {
                p = new Pizza(toppings);
            }
            System.out.println("Your pizza has the following toppings: " + p.getToppings());
            System.out.println("Your pizza size is: " + p.getSize());
            System.out.println("Your drink is: " + p.getDrink());
        } else if (input.equalsIgnoreCase("o")) {
            System.out.println("How many people are you ordering for?");
            int people = sc.nextInt();
            System.out.println("How many items will each person order?");
            int items = sc.nextInt();
            Pizza[][] orders = Pizza.readOrder(people, items);
            Pizza.printOrder(orders);
        }
    }
}
