package assignment10;

public class House {

    private int bedrooms;
    private int bathrooms;
    private double size;
    private String color;
    private boolean rent;

    public House(){
        bedrooms = 3;
        bathrooms = 3;
        size = 2100.0;
        color = "White";
        rent = false;
    }

    public House (int beds, int baths, double sqft, String col, boolean renting){
        bedrooms = beds;
        bathrooms = baths;
        size = sqft;
        color = col;
        rent = renting;
    }


    public String makeHouse(){
        String s = ("Here is your residence! It has " + bedrooms + " bedrooms and " + bathrooms + " bathrooms, containing a total area of " + size + ". The exterior is painted " + color + "! ");
        if(rent){
            s += ("Yes, this residence is currently available to rent!");
        }
        return s;
    }

    public double findValue(double sqft){
        double a = 500 * sqft;
        return a;

    }

    public static double findLoan(double princamount, double rate, int year) {
        if(year > 0){
            year = year -1;;
          double newAmount= princamount + (princamount * rate);
          return findLoan(newAmount, rate, year);
        }
        return princamount;
    }











    
}