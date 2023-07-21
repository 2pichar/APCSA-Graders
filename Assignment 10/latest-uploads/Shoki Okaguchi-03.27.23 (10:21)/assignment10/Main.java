package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter the number of humans to create: ");
        int numMyClass = sc.nextInt();
        MyClass[] arr = new MyClass[numMyClass];

        for (int i = 0; i < numMyClass; i++) {
            System.out.println("Enter the details for the person " + (i + 1) + ":");
            System.out.print("ID(numbers): ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            arr[i] = new MyClass(id, name);
        }

        ArrayList<MySubClass> list = new ArrayList<>();
        System.out.print("\nEnter the number of people to create: ");
        int numMySubClass = sc.nextInt();

        for (int i = 0; i < numMySubClass; i++) {
            System.out.println("Enter the details for the person " + (i + 1) + ":");
            System.out.print("ID(numbers): ");
            int id = sc.nextInt();
            sc.nextLine();
            System.out.print("Name: ");
            String name = sc.nextLine();
            System.out.print("Salary: ");
            double salary = sc.nextDouble();
            sc.nextLine();
            System.out.print("Workplace: ");
            String designation = sc.nextLine();
            list.add(new MySubClass(id, name, salary, designation));
        }

        int[][] matrix = { { 1, 2, 3 }, { 4, 5, 6 }, { 7, 8, 9 } };

        System.out.println("\nFactorial of 5 is " + factorial(5));

        for (MyClass obj : arr) {
            System.out.println(obj.getName());
        }

        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i));
            list.get(i).printSalary();
        }

         for (int[] row : matrix) {
        for (int element : row) {
            System.out.print(element + " ");
        }
        System.out.println();
    }

    sc.close();
}

public static int factorial(int num) {
    if (num <= 1) {
        return 1;
    } else {
        return num * factorial(num - 1);
    }
}
}


