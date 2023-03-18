package assignment10;

import java.util.*;

public class Child extends Test {
    private int n;
    private int x;
    public Child(){
        super();
        System.out.println("Child()");
    }
    public Child(int n){
        super(n);
        this.n = n;
        x = 1;
        System.out.println("Child(int)");
    }
    public Child(int n, int x){
        super(n);
        this.n = n;
        this.x = x;
        System.out.println("Child(int, int)");
    }
    public void other(){
        int[][] arr = new int[n][x];
        String[] arr2 = new String[3];
        ArrayList<String> arr3 = new ArrayList<String>();

        for(int i = 0; i < arr.length; i++){
            for(int j = 0; j < arr[i].length; j++){
                arr[i][j] = i + j;
            }
        }

        for(int i = 0; i < arr2.length; i++){
            arr2[i] = "Hello (" + i + ")";
        }

        for(int i = 0; i < 10; i++){
            arr3.add("Hello (A" + i + ")");
        }
        
        for(String a : arr2){
            System.out.println(a);
        }
    }
    public void method(){
        System.out.println("this is a child method");
    }
    public boolean equals(Object o){
        System.out.println("equals(Object)");
        return false;
    }
}