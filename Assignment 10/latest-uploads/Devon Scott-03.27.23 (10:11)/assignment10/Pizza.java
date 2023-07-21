package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

public class Pizza {
    protected String toppings;
    protected static String size;
    protected static String drink;
    static Pizza[][] array = new Pizza[0][0];

    public Pizza() {
        toppings = "cheese";
        size = "medium";
        drink = "Sprite";
    }

    public Pizza(String t, String s, String d) {
        toppings = t;
        size = s;
        drink = d;
    }

    public Pizza(String t) {
        toppings = t;
        size = "medium";
        drink = "Sprite";
    }

    public static Pizza[][] readOrder(int people, int items) {
        Pizza[][] orders = new Pizza[people][items];
        Scanner sc = new Scanner(System.in);
        for (int i = 0; i < people; i++) {
            System.out.println("Enter person" + (i+1) + "'s order here");
            for (int j = 0; j < items; j++) {
                String input = sc.next();
                orders[i][j] = new Pizza(input);
            }
        }
        return orders;
    }

    public static void printOrder(Pizza[][] orders) {
        for (int i = 0; i < orders.length; i++) {
            System.out.println("Order for person " + (i + 1) + ":");
            for (int j = 0; j < orders[i].length; j++) {
                System.out.println("  - " + orders[i][j].getToppings());
            }
        }
    }

    public static void setSize(String l) {
        size = l;
    }

    public String getSize() {
        return size;
    }

    public static void setDrink(String d) {
        drink = d;
    }

    public String getDrink() {
        return drink;
    }

    public String getToppings() {
        return toppings;
    }
}
