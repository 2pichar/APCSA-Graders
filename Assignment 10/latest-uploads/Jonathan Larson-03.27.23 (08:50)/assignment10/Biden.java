package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

public class Biden extends Joe {
    private ArrayList<ArrayList<String>> icecream2 = new ArrayList<ArrayList<String>>();
    private ArrayList<String> icecream = new ArrayList<String>();
    private String cone;

    // default constructor
    public Biden(){
        super();
        this.cone = "cone";
        System.out.println("Biden's constructor");
        // Initialize the nested ArrayLists
        for (int i = 0; i < 5; i++) {
            icecream2.add(new ArrayList<String>());
        }

        for (int i = 0; i < 5; i++) {
                   String flavor = super.getFlavor_at(i);
        int index = i % 5;
        icecream2.get(index).add(flavor);
    }
    }
    public Biden(String name, int num_flavors, String cone) {
        super(name, num_flavors);
        this.cone = cone;
        System.out.println("Biden's constructor");

        // Initialize the nested ArrayLists
        for (int i = 0; i < num_flavors; i++) {
            icecream2.add(new ArrayList<String>());
        }

        for (int i = 0; i < num_flavors; i++) {
            icecream2.add(new ArrayList<String>());
        }
        
        for (int i = 0; i < num_flavors; i++) {
                   String flavor = super.getFlavor_at(i);
        int index = i % 5;
        icecream2.get(index).add(flavor);
    }
}

public String getCone() {
    return this.cone;
}

public void heatCone() {
    this.cone = "hot " + this.cone;
    System.out.println("The cone is now " + this.cone);
}

// method that uses recursion to help with the heatCone method
public void heatCone(int num) {
    if (num == 0) {
        return;
    }
    this.cone = "hot " + this.cone;
    System.out.println("The cone is now " + this.cone);
    heatCone(num - 1);
}
// overriden method from Joe.java
public String getFlavors2() {
    String out = "Biden's flavors:";
    for (ArrayList<String> flavor : this.icecream2) {
        out += flavor + " ";
    }
    return out;
}

//a sorting method to get one of your arrays in order and use binary search to get the index of an item
public int binarySearch(ArrayList<String> arr, String x) {
    int l = 0, r = arr.size() - 1;
    while (l <= r) {
        int m = l + (r - l) / 2;
        int res = x.compareTo(arr.get(m));
        // Check if x is present at mid
        if (res == 0)
            return m;
        // If x greater, ignore left half
        if (res > 0)
            l = m + 1;
        // If x is smaller, ignore right half
        else
            r = m - 1;
    }
    return -1;
}

}