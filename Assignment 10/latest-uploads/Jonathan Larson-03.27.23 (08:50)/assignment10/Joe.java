package assignment10;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.Arrays;



public class Joe {
    private String name;
    private ArrayList<String> icecream = new ArrayList<String>();
    ArrayList<ArrayList<String>> icecream2 = new ArrayList<ArrayList<String>>();

    //defualt constructor
    public Joe() {
        this.name = "Joe";
        int num_flavors = 5;
        this.icecream.add("chocolate");
        this.icecream.add("vanilla");
        this.icecream.add("strawberry");
        this.icecream.add("mint");
        this.icecream.add("coffee");

        for (int i = 0; i < 5; i++) {
            icecream2.add(new ArrayList<String>(Arrays.asList("0", "0", "0", "0", "0")));
        }
        for (int i = 0; i < num_flavors; i++) {
            int index = i % 5;
            icecream2.get(index).set(i, icecream.get(i));
        }
    }
    public Joe(String name, int num_flavors) {
        // set dimensions of 2d arraylist with 0 values
        for (int i = 0; i < 5; i++) {
            icecream2.add(new ArrayList<String>(Arrays.asList("0", "0", "0", "0", "0")));
        }
        Scanner scan = new Scanner(System.in);
        this.name = name;
        //2d arraylist should have every 5 flavors in each line
        System.out.println(name + "'s constructor");
        for (int i = 0; i < num_flavors; i++) {
            System.out.println("Enter flavor " + i + ": ");
            String flavor = scan.nextLine();
            icecream.add(flavor);
            int index = i % 5;
            icecream2.get(index).set(i, flavor);
        }
    }

    public String getName() {
        return this.name;
    }

    public String getFlavors() {
        String out = "";
        for (String flavor : icecream) {
            out += flavor + " ";
        }
        return out;
    }

    public String getFlavor_at(int index) {
        return icecream.get(index);
    }

    public String getFlavors2() {
        String out = "Joe's flavors:";
        for (ArrayList<String> flavor : this.icecream2) {
            out += flavor + " ";
        }
        return out;
    }
}

