package assignment10;

public class DinnerParty extends Party {
    private int[][] seatingArrangement;
    private int[] food;
    //2d array with 1 for occupied and 0 for vacant seats

    public DinnerParty() {
        super();
        this.seatingArrangement = int[][]
    }
    public DinnerParty(int in) {
        super(in);
        this.seatingArrangement = int[][]
    }
    public DinnerParty(int in, String loc) {
        super(in, loc);
        this.seatingArrangement = int[][]
    }
    public DinnerParty(int in, String loc, String[] list) {
        super(in, loc, list);
        this.seatingArrangement = int[][]
    }
    public DinnerParty(int in, String loc, String[] list, int[][] arrangement) {
        super(in, loc, list);
        this.seatingArrangement = arrangement;
    }

    public String printSeating() {
       String out = "";
        for(int i = 0; i < this.seatingArrangement.length; i++) {
           for(int j = 0; j < this.seatingArragement[i].length; j++) {
               out+=seatingArrangement[i][j] + " ";
           }
        out+="\n";
        }
    return out;  
    }

 public void throwParty() {
        System.out.println("A party is being thrown at " + this.location + "!" + "\n Guests: " + this.printGuests() + "\nSeating Arrangement:" + this.printSeating() );

    }




}

