package assignment10;

import java.lang.reflect.*;

public class Test {
    private int n;
    private int m;
    
    public Test (){
        // This is a comment
        System.out.println("Test()");
    }
    public Test(int n){
        this.n = this.m = n;
        System.out.println("Test(int)");
    }
    public void recursive(int n){
        if (n == 0) return;
        System.out.println("n = " + n);
        recursive(n-1);
    }
    public void method(){
        System.out.println("this is a test method");
    }
}