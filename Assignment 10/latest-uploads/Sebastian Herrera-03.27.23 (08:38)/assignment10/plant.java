package assignment10;

import java.util.ArrayList;
public class plant {
    private String name;
    private String color;
    private boolean wellKept;
    private int height; 

    public plant () {
        name = "rose bush";
        color = "green";
        wellKept = false;
        height = 7;
    }

    public plant (String str) {
        name = str;
        color = "green";
        wellKept = false;
        height = 7;
    }

    public plant (String str, String str2) {
        name = str;
        color = str2;  
        wellKept = false;
        height = 7;
    }

    public plant (String str, String str2, boolean bool, int h) {
        name = str;
        color = str2;
        wellKept = bool;
        height = h;
    }

    public int getHeight() {
        return height;
    }

    public String getName () {
        return name;
    }

    public int findAverageHeight(plant[] arr) {
        int sum = 0;
        for (plant s : arr) {
            sum = sum + s.getHeight();
        }
        return sum /= arr.length;
    }

    public String trim() {
       if (wellKept == false) {
        wellKept = true;
        return "Your " + name + "looks nice and tidy!";
        }
        else {
        return name + "is already well kept!";
        }
    }

    public String healthy(boolean b) {
        if (b) {
            return "Your " + name + " is healthy! Amazing!";
        }
        else {
            return "Uh oh, you should check on your " + name + " some more";
        }
    }

    public ArrayList<plant> sortAlph(ArrayList<plant> arf) {
        for (int s = 0; s < arf.size(); s++) {
            plant temp = arf.get(s);
            int temper = s;
            for (int c = temper; c > 0; c--) {
                 if (temp.getName().compareTo(arf.get(temper - 1).getName()) >= 0) {
                     arf.set(temper, arf.get(temper - 1));
                     temper--;
                 }
                 else {
                     break;
                 }
            }
            arf.set(temper, temp);
        }
        return arf;
    }
}
