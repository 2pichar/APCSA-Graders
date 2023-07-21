package assignment10;

public class tree extends plant {
    private boolean hasFruit;
    private int numFruit = 0;

    public tree () {
        super();
        hasFruit = false;
    }

    public tree (boolean has) {
        super();
        hasFruit = has;
    }

    public tree (String str) {
        super(str);
        hasFruit = false;
    }

    public tree (String str, String str2, boolean bool) {
        super (str, str2);
        hasFruit = bool;
    }

    public int getHeight() {
        return super.getHeight();
    }

    public String getName() {
        return super.getName();
    }
    
    public void setNumFruit(int num) {
        if (num >= 0) {
        numFruit = num;            
        }
        else {
        System.out.println("That's not a valid number");
        }
    }

    public String trim() {
      return super.trim();
    }

    public String pickFruit() {
        if (hasFruit == true && numFruit >= 1) {
            if (numFruit == 1) {
                return "You picked " + numFruit + " fruit!";
            }
            return "You picked " + numFruit + " fruits!";
        }
        else {
            return "Your tree doesn't have any fruit to pick!";
        }
    }

    public tree[][] createGrove(int row, int column) {
        tree[][] arr = new tree[row][column];
        for (int s = 0; s < arr.length; s++) {
            for (int c = 0; c < arr[s].length; c++) {
                arr[s][c] = new tree(hasFruit);
            }
        }

        return arr; 
    }
}