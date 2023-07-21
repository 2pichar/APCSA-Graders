package assignment10;

import java.util.ArrayList;

public class MyClass {
    private int myInt;
    private String myString;

    public MyClass(int myInt, String myString) {
        this.myInt = myInt;
        this.myString = myString;
    }

    public MyClass() {
        this.myInt = 0;
        this.myString = "";
    }

    public int getMyInt()
    {
        return myInt;
    }
       public String getmyString()
    {
        return myString;
    }
    public void print() {
        System.out.println("MyClass: " + myInt + " " + myString);
    }

    public int factorial(int n) {
        if (n == 0) {
            return 1;
        } else {
            return n * factorial(n-1);
        }
    }
}
