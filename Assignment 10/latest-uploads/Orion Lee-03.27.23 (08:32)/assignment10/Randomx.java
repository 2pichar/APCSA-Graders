package assignment10;

public class Randomx{
    private int[][] ranInts;
    private boolean printAfterFill;
    
    public Randomx(){
        ranInts = new int[10][10];
        printAfterFill = false;
    }
    public Randomx(int rows, int cols, boolean pAF){
        ranInts = new int[rows][cols];
        printAfterFill = pAF;
    }
    public int[][] getInts(){
        return ranInts;
    }
    public void fillArray(){
        for (int r = 0; r < ranInts.length; r++){
            for (int c = 0; c < ranInts[0].length; c++){
                ranInts[r][c] = (int)(Math.random()*21)-10;
            }
        }
        if (printAfterFill){
            System.out.println(this.toString());
        }
    }
    public void fillArrayMaxMin(int max, int min){
        for (int r = 0; r < ranInts.length; r++){
            for (int c = 0; c < ranInts[r].length; c++){
                ranInts[r][c] = (int)(Math.random()*(max-min+1))+min;
            }
        }
        if (printAfterFill){
            System.out.println(this.toString());
        }
    }
    public String toString(){
        String ret = "";
        for (int r = 0; r < ranInts.length; r++){
            ret += "\t";
            for (int c = 0; c < ranInts[r].length; c++){
                ret += ranInts[r][c] + " ";
            }
            ret += "\n";
        }
        return ret;
    }
    public int binary2D(int arr[], int left, int right, int x){
        if (right >= left && left <= arr.length-1){
            int mid = left + (right-1)/2;
            if (arr[mid] == x){
                return mid;
            }
            if (arr[mid] > x){
                return binary2D(arr, left, mid - 1, x);
            } else {
                return binary2D(arr, mid + 1, right, x);
            }
        }
        return -1;
    }
    public int[] breakArray(int row){
        int[] arr = new int[ranInts[row].length];
        for (int c = 0; c < ranInts[row].length; c++){
            arr[c] = ranInts[row][c];
        }
        return arr;
    }

    public void sort2D(){
        for (int r = 0; r < ranInts.length; r++){
            int[] arr = new int[ranInts[r].length];
            for (int c = 0; c < ranInts[r].length; c++){
                arr[c] = ranInts[r][c];
            }
            for (int i = 1; i < arr.length; i++){
                int j = i;
                while (j > 0 && arr[j-1] > arr[j]){
                    int tempary = arr[j];
                    arr[j] = arr[j-1];
                    arr[j-1] = tempary;
                    j = j-1;
                }
            }
            for (int c = 0; c < ranInts[r].length; c++){
                ranInts[r][c] = arr[c];
            }
        }
    }
}