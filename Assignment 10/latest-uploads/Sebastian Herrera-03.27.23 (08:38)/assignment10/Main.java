package assignment10;

import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        plant[] arr = new plant[5];
        plant plant1 = new plant("rose");
        plant plant2 = new plant("banana", "orange");
        plant plant3 = new plant("blueberry bush", "red", true, 56);
        plant plant4 = new plant();
        plant plant5 = new plant("avocado");
        arr[0] = plant1;
        arr[1] = plant2;
        arr[2] = plant3;
        arr[3] = plant4;
        arr[4] = plant5;  
        System.out.println(plant1.findAverageHeight(arr));     

        printAllSameDigit(plant3.getHeight());

        
    }

    public static void printAllSameDigit(int height) {
        if (height > 0) {
            printAllSameDigit(height - 10);
        }
        if (height > 0) {
            System.out.print(height + " ");
        }
    }
}
