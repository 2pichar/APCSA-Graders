package assignment10;

import java.util.ArrayList;

class MySubclass extends MyClass {
    private String extraString;
    private String cheatcode;

    public MySubclass(int myInt, String myString, String extraString) {
        super(myInt, myString);
        this.extraString = extraString;
    }

    public MySubclass() {
        super();
        this.extraString = "";
    }

    public void print() {
        System.out.println("MySubclass: " + super.getMyInt() + " " + super.getmyString() + " " + extraString);
    }

    public String getExtraString() {
        return extraString;
    }

    public void cheat(){
        cheatcode = "cheatcode";
        System.out.println(cheatcode + "cheatcode");
        ArrayList[][] table = new ArrayList[10][10];
        for(int i = 0; i < table.length;i++){
         System.out.print(table[i][i] + " ");
        }
        System.out.println("");
        ArrayList<Integer> e = new ArrayList<Integer>();
          for(int i = 0; i < 10;i++){
        e.add(0);
        System.out.print(e.get(i));
        }
    }
}