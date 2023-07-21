package assignment10;

import java.util.ArrayList;
import java.util.Scanner;
public class Runner{

    public static void main(String[] args) {
        MyClass myClass = new MyClass(10, "Hello");
        myClass.print();
        System.out.println("Factorial of 5: " + myClass.factorial(5));

        ArrayList<MyClass> myClassList = new ArrayList<>();
        myClassList.add(new MyClass(1, "One"));
        myClassList.add(new MyClass(2, "Two"));
        myClassList.add(new MyClass(3, "Three"));

        for (int i = 0; i < myClassList.size(); i++) {
            myClassList.get(i).print();
        }

        int[][] myArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};

        for (int[] row : myArray) {
            for (int num : row) {
                System.out.print(num + " ");
            }
            System.out.println();
        }

        MySubclass mySubclass = new MySubclass(20, "World", "Extra String");
        mySubclass.print();
        System.out.println("Factorial of 3: " + mySubclass.factorial(3));
        System.out.println("Extra String: " + mySubclass.getExtraString());

        MyClass[] myClassArray = {new MyClass(4, "Four"), new MyClass(5, "Five"), new MyClass(6, "Six")};

        for (MyClass myObj : myClassArray) {
            myObj.print();
        }
        mySubclass.cheat();
    }
}

