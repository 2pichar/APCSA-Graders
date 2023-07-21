package assignment10;

import java.util.ArrayList;

public class Toppings extends Base
{
    ArrayList<String> toppingsList = new ArrayList<String>();
    private String[][] shelf = {{"chocolate sprinkles", "cookie dough", "coconut flakes"},
                                {"rainbow sprinkles", "gummy bears", "chocolate chips"},
                                {"cherry", "berries", "chopped nuts"}};  
    
    String sauces[] = {"chocolate", "caramel", "strawberry", "whipped cream"};

    private String topping1 = "";
    private String topping2;
    private String topping3;
    private String sauce = "";

    public Toppings(){
        topping1 = shelf[0][0];
        topping2 = shelf[0][1];
        topping3 = shelf[0][2];
    }

    public void setToppings(String a, String b, String c){
        topping1 = a;
        topping2 = b;
        topping3 = c;
    }

    public void setSauce(String s){
        sauce = s;
    }

    public String printShelf(){
        String output = "";
        for (int r = 0; r < shelf.length; r++){
            for (int c = 0; c < shelf[0].length; c++){
                output += shelf[r][c] + ",\t";
            }
            output += "\n";
        }
        return "\nHere is what's in our shelf:\n" + output;
    }

    public String printSauces(){
        String output = "";
        for (int i = 0; i < sauces.length; i++){
            output += sauces[i] + ",\t";
        }
        return output;
    }

    public String findTopping(String tp){
        for (int r = 0; r < shelf.length; r++){
            for (int c = 0; c < shelf[0].length; c++){
                if (shelf[r][c].equals(tp)){
                    return tp + " added.";
                }
            }
        }
        return "ERROR : topping not found";
    }

    public String findSauce(String sc){
        for (int i = 0; i < sauces.length; i++){
            if (sauces[i].equals(sc)){
                return sc + "added.";
            }
        }
        return "ERROR : sauce not found";
    }

    public double cost(){
        if (!topping1.equals("")) {
            price += 20;
        }
        return price/100;
    }
}