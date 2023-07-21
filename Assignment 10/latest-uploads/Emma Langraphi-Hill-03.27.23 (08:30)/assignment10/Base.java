package assignment10;

public class Base
{
    private String flavor;
    public String flavor2 = "";
    private int scoops = 0;
    private boolean isCone;
    public double price = 400;
    private int luckynum;
    
    public Base(){
        flavor = "vanilla";
        scoops = 2;
        isCone = true;
    }

    public Base(String f, int s, boolean c){
        flavor = f;
        scoops = s;
        isCone = c;
    }

    public void setFlavor(String f){
        flavor = f;
    }
    
    public void setScoops(int s){
        scoops = s;
    }

    public void setIsCone(boolean c){
        isCone = c;
    }

    public String getFlavor(){
        return flavor;
    }
    
    public int getScoops(){
        return scoops;
    }

    public String getIsCone(){
        String output = "";
        if (isCone){
            output = "in a cone";
        } else if (!isCone){
            output = "in a cup";
        }
        return output;
    }

    public double cost(){   
        if (isCone == true){
            price += 120;
        }

        if(scoops > 1){
            price += 3*scoops;
        }
        return price/100;
    }

    public void addFlavor(String f){
        flavor2 = f;
    }

    public String luckyNum(int n){
        if (n > 100){
            luckyNum(n/2);
        } else if (n < 100) {
            if (n < 0) {
                return "Sorry you did not win the discount.";
            } else if (n % 2 == 0) {
                return "You have won the 10% discount!";
            } else {
                return "Sorry you did not win the discount.";
            }
        }
        return "Sorry you did not win the discount.";
    }

    public String toString(){
        if (!flavor2.equals("")){
            return "Your dessert has " + scoops + " scoops of " + flavor + " and " + flavor2 + " ice cream and is " + getIsCone() + ". Your total is $" + cost();
        } else {
            return "Your dessert has " + scoops + " scoops of " + flavor + " ice cream and is " + getIsCone() + ". Your total is $" + cost();
        }
    }
}