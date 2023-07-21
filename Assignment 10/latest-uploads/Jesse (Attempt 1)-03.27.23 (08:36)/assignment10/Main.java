package assignment10;

//whole idea is investing simulator
// Runner acts as broker (UI) have a var for money
//Limit investment options to (Gold, Silver, Property (dont say real estate cuz it has a space), Stocks, and Cash)
//Runner ideas: make function to show what % of a portfolio an investment is //
import java.util.Scanner;
import java.util.ArrayList;
public class Main{
    private static String[] sectors = {"Energy", "Industrials", "Health Care", "Financials", "Technology", "Communications"};
    private static String[][] stockList = {{"XOM", "CVX", "SHEL", "OXY", "PXD"}, {"UPS", "BA", "LMT", "CAT", "GE"}, {"JNJ", "PFE", "CVS", "MRK", "AMGN"}, {"V", "JPM", "MA", "MS", "WFC", "BAC", "C", "RY"}, {"AAPL", "MSFT", "NVDA", "AMD", "ADBE", "QCOM", "TSM", "TXN"}, {"GOOG", "META", "DIS", "VZ", "T", "NFLX", "EA", "RBLX"}};
    private static double[][] prices = {{103.41, 154.52, 55.97, 58.48, 189.18}, {185.29, 197.9, 497.9, 219.44, 91.59}, {151.13, 40.18, 72.37, 104.23, 233.1}, {222.59, 126.84, 354.27, 85.84, 36.61, 26.97, 25.2, 92.66}, {158.93, 277.66, 271.91, 100.28, 396, 124.15, 94.95, 180.28}, {106.26, 204.28, 95.83, 37.37, 18.46, 320.37, 116.04, 42.07}};
    private static ArrayList<Investment> Portfolio = new ArrayList<Investment>();

    public static void main(String[] args) {

        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to the investing simulator!");
        System.out.println("What is your name?");
        String name = scan.nextLine();
        System.out.println("Enter the amount of money you would like to start with. (Rounded to 2 decimal places)");
        double money = scan.nextDouble();

        String ans = "";
        while(!ans.equals("stop") || money <= 0){
            System.out.println("\nYou have $" + money + " remaining. To purchase assets, enter \"purchase\". If you would like to know what assets are available for purchase, enter \"list\". To view your portfolio, enter \"view\". If you would like to end the simulation and calculate your returns, enter \"stop\" ");
            scan.nextLine();
            ans = scan.nextLine();

            if(ans.equals("purchase")){
                System.out.println("Enter which type of asset you would like to purchase");
                String typ = scan.nextLine().toLowerCase();
                if(typ.equals("stock")){
                    System.out.println("Enter the ticker of the stock you wish to purchase");
                    String tick = scan.nextLine().toUpperCase();
                    System.out.println("What sector is it in?");
                    String sec = scan.nextLine();
                    System.out.println("Enter the amount of shares you wish to purchase");
                    int shares = scan.nextInt();
                    double price = (double) (Math.round((shares * getSharePrice(tick)) * 100) / 100);
                    Portfolio.add(new Stock(tick, sec, price));
                    money -= price;
                }
                else{
                    System.out.println("How much " + typ + " would you like to purchase? (in dollars)");
                    double amount = scan.nextDouble();
                    Portfolio.add(new Investment(typ, amount));
                    money -= amount;
                }
            }
            else if(ans.equals("list")){
                System.out.println("Gold, Silver, Property, and Stocks are available for purchase. To see which stocks are available for purchase, enter \"show\"");
                String res = scan.nextLine().toLowerCase();
                if(res.equals("show")){
                    displayStock();
                }
            }
            else if(ans.equals("view")){
                System.out.print("Investments: ");
                for(Investment a : Portfolio){
                    System.out.print(a.toString());
                }
            }
        }

        System.out.println("How many years would you like your investments to mature");
        int y = scan.nextInt();
        System.out.println("Your portfolio will be worth $" + getReturns(y) + " after " + y + " years.");
        System.out.print("Thanks for playing!");
    }

    public static void displayStock(){
        System.out.println("Stocks: ");
        for(int r = 0; r < stockList.length; r++){
            System.out.print("\n\t" + sectors[r] + ":");
            for(int c = 0; c < stockList[r].length; c++){
                System.out.print("\n\t\tTicker: " + stockList[r][c] + "\tShare Price: " + prices[r][c]);
            }
        }
    }
    
    public static double getSharePrice(String t){
        for(int r = 0; r < stockList.length; r++){
            for(int c = 0; c < stockList[r].length; c++){
                if(t.equals(stockList[r][c])){
                    return prices[r][c];
                }
            }
        }
        return 1;
    }
    
    public static double getReturns(int y){
        double result = 0;
        for(Investment b : Portfolio){
            result += b.generateResult(y);
        }
        //return (double) (Math.round(result * 100) / 100);
        return result;
    }
}    
