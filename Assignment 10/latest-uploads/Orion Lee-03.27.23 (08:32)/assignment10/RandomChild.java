package assignment10;

public class RandomChild extends Randomx{
    private int max;
    private int min;
    
    public RandomChild(){
        super();
        max = 10;
        min = -10;
    }

    public RandomChild(int rows, int cols, boolean pAF, int mx, int mn){
        super(rows, cols, pAF);
        max = mx;
        min = mn;
    }
    public void changeMax(int mx){
        max = mx;
    }
    public void changeMin(int mn){
        min = mn;
    }

    public void fillArray(){
        super.fillArrayMaxMin(max, min);
    }

    public void insaneRandom(){
        super.sort2D();
        for (int r = 0; r < super.getInts().length; r++){
            int[] xD = super.breakArray(r);
            for (int i: xD){
                System.out.print(i + " ");
            }
            System.out.println();
            System.out.println(super.binary2D(xD, 0, xD.length-1, ((int)(Math.random()*max-min+1)+min)));
        }
    }
}