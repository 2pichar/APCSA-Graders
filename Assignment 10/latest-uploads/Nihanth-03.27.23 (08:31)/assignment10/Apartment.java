package assignment10;

public class Apartment extends House {
    
    private int facilitiesRating;
    private String city;
    private int rent;

    public Apartment(){
        super();
        rent = 2500;
        city = "NEW YORK CITY";
        super.apar();
    }
    public Apartment(int bed, int bath, String type, int sqft,int price, int facilitiesRating, String city, int rent){
        super(bed,bath,type,sqft,0);
        this.facilitiesRating = facilitiesRating;
        this.city = city;
        this.rent = rent;
        super.apar();
    }

    public int getRent(){
        return rent;
    }

    public int getFacilitiesRating(){
        return facilitiesRating;
    }

    public String toString(){
        String s = "";
        s += super.toString() + " for rent: $" + rent + " in " + city + " with " + facilitiesRating + " star facilities.\n";
        return s;
    }
}