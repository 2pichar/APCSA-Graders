package assignment10;

public class Stock extends Investment{
    private String ticker;
    private String sector;
    public String[] sectors = {"Energy", "Industrials", "Health Care", "Financials", "Technology", "Communications"};
    public String[][] stocks = {{"XOM", "CVX", "SHEL", "OXY", "PXD"}, {"UPS", "BA", "LMT", "CAT", "GE"}, {"JNJ", "PFE", "CVS", "MRK", "AMGN"}, {"V", "JPM", "MA", "MS", "WFC", "BAC", "C", "RY"}, {"AAPL", "MSFT", "NVDA", "AMD", "ADBE", "QCOM", "TSM", "TXN"}, {"GOOG", "META", "DIS", "VZ", "T", "NFLX", "EA", "RBLX"}};
    public double[][] prices = {{103.41, 154.52, 55.97, 58.48, 189.18}, {185.29, 197.9, 497.9, 219.44, 91.59}, {151.13, 40.18, 72.37, 104.23, 233.1}, {222.59, 126.84, 354.27, 85.84, 36.61, 26.97, 25.2, 92.66}, {158.93, 277.66, 271.91, 100.28, 396, 124.15, 94.95, 180.28}, {106.26, 204.28, 95.83, 37.37, 18.46, 320.37, 116.04, 42.07}};

    
    public Stock(){
        super();
        ticker = "unknown";
        sector = "none";
    }   

    //v needs to be # of shares * share price
    public Stock(String t, String s, double v){
        super("Stock", v);
        ticker = t;
        sector = s;
    }

    public int gradeRisk(){
        int[] risk = {2, 1, 4, 3, 5, 3};
        int i = 0;
        for(String b : sectors){
            if(sector.equals(b)){
                return risk[i];
            }
            i++;
        }
        return 1;
    }

    //----------------------------------------------------------------------------------

    public String toString(){
        return "\n\tType: Stock\n\tSymbol: " + ticker.toUpperCase() + "\n\tSector: " + sector + "\n\tValue: $" + this.getAmount() + "\n";
    }
    
    public String getTicker(){
        return ticker;
    }

    public String getSector(){
        return sector;
    }

    public void setTicker(String t){
        ticker = t;
    }

    public void setSector(String s){
        sector = s;
    }
}