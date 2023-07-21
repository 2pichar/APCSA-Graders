package assignment10;

public class Investment{
    private String type;
    private double amount;
    //Risk Levels for types: 1, 1, 2, 3
    private String[] types = {"Gold", "Silver", "Cash", "Property"};
    private int[] risk = {1, 1, 2, 4};
    final double gPrice = 1995.34;
    final double sPrice = 23.06;

    public Investment(){
        type = "Unknown";
        amount = 0;
    }

    public Investment(String t, double a){
        type = t.substring(0, 1).toUpperCase() + t.substring(1).toLowerCase();
        amount = a;
    }

    //Risk scale 1-5 (1 being safest, 5 being riskiest)
    public int gradeRisk(){
        int[] risk = {1, 1, 2, 4};
        for(int i = 0; i < 4; i++){
            if(type.equals(types[i])){
                return risk[i];
            }
        }
        return 1;
    }

    //Make factorial recursion, then change it to my calculation from there
    //Calculates what one investment will be in a y amount of years
    //public double matureInvestment(int years){
   
    //-------------------------------------------------------------------------------------------
    
    public String toString(){
        if(type.toLowerCase().equals("gold")){
            double oz = amount / gPrice;
            double round = (double) Math.round(oz * 100) / 100;
            return "\n\tType: " + type + "\n\tWeight: " + round + " oz.\n\tValue: $" + amount + "\n";
        }
        else if(type.toLowerCase().equals("silver")){
            double oz = amount / sPrice;
            double round = (double) Math.round(oz * 100) / 100;
            return "\n\tType: " + type + "\n\tWeight: " + round + " oz.\n\tValue: $" + amount + "\n";
        }

         return "\n\tType: " + type + "\n\tValue: $" + (double) (Math.round(amount * 100) / 100) + "\n";
    }   

    public String getType(){
        return type;
    }

    public double getAmount(){
        return amount;
    }    

    public void setType(String t){
        type = t;
    }
    
    public void setAmount(int a){
        amount = a;
    }

    public double generateResult(int years)
    {
        if (years == 0){
            return 1;
        }
        else{
            double x = this.getAmount() / 10;
            double y = this.gradeRisk() / 10;
            return x * generateResult(years - 1);
        }
    }    
}