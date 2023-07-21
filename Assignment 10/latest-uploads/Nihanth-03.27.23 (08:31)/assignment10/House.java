package assignment10;

public class House {

    private int bedrooms;
    private int bathrooms;
    private String type;
    private int squareft;
    private int price;
    private final double homestype[] = {0,0};

    public House(){
        bedrooms = 3;
        bathrooms = 2;
        type = "House";
        squareft = 1300;
        homestype[0]++;
    }

    public void apar(){
        homestype[1]++;
    }

    public House(int bed, int bath, String type, int sqft, int price){
        bedrooms = bed;
        bathrooms = bath;
        this.type = type;
        squareft = sqft;
        this.price = price;
    }

    public void appreciate(int percent){
        
        price += (price/percent);
    }

     public static double loan(double amount, double rate, int year) {
        if(year > 0){
            year = year -1;;
          double newAmount = amount + (amount * rate);
          return loan(newAmount, rate, year);
        }
        return amount;
    }

    public String toString(){
        String s = "";
        s += bedrooms + " bedrooms, " + bathrooms + " bathrooms, " + type + " ," + squareft + " sqft, $" + price;
        return s;
    }

}