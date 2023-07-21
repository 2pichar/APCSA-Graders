package assignment10;

public class Mansion extends House {

    private double lotSize;
    private double worth;

    public Mansion(){
        super();
        lotSize = 20000.0;
        worth = 3910000.0;
    }

    public Mansion(int beds, int baths, double sqft, String col, boolean renting, double lot, double val){
        super(beds,baths,sqft,col,renting);
        lotSize = lot;
        worth = val;

    }

    public String makeHouse(){
        String s = "";
        s+= super.makeHouse();
        s+= ("In addition, the lotsize is " + lotSize + "sqaure feet and the house worth is " + worth + "dollars. ");
        return s;
    }

    public String calcWorth(){
        String w = "";
        if (worth <= 2000000 && worth >= 1000000){
            w += ("Your residence is worth the normal amount!");
        }
        if (worth > 2000000 && worth <= 5000000){
            w += ("Your residence a worth a little more than the rest in the area!");
        }
        if (worth > 5000000 && worth<= 10000000){
            w += ("Your residence has quite a high value!");
        }
        if (worth > 10000000){
            w += ("Your residence is one of the most valuable in the whole area!");
        }
        return w;
    }

}