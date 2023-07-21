package assignment10;

import java.util.Scanner;
import java.util.ArrayList;
import java.util.Arrays;

public class Main {

    public static void main(String[] args) {
        //one array traversing with for each loop
        Shapes[] shapesArray = {
            new Shapes(),
            new Shapes("triangle", "green"),
            new Shapes("rectangle", "orange", 2, 2),
            new Circle(),
            new Circle(4, 5, -2.5),
            new Circle("circle", "red", 5, 3, 3)
        };
        System.out.println("Array traversing with a for each loop: ");
        for (Shapes s : shapesArray) {
            System.out.println(s.toString());
        }


        //one arrayList traversing with for loop
        ArrayList<Shapes> shapesArrayList = new ArrayList();
        Shapes s1 = new Shapes();
        shapesArrayList.add(s1);
        Shapes s2 = new Shapes("triangle", "green");
        shapesArrayList.add(s2);
        Shapes s3 = new Shapes("rectangle", "orange", 4, 3);
        shapesArrayList.add(s3);
        Shapes s4 = new Circle();
        shapesArrayList.add(s4);
        Shapes s5 = new Circle(4, 5, -2.5);
        shapesArrayList.add(s5);
        Shapes s6 = new Circle("circle", "red", 5, 3, 3);
        shapesArrayList.add(s6);
        System.out.println("\n\nArrayList traversing with a for loop: ");
        for (int i = 0; i < shapesArrayList.size(); i++) {
            System.out.print(
                shapesArrayList.get(i).getType() + ": " + shapesArrayList.get(i).getArea() +
                ", "
            );
        }
        System.out.println("\n\n");


        //2D array traversed
        Shapes[][] shapes2dArray = new Shapes[2][3];
        shapes2dArray[0][0] = s1;
        shapes2dArray[0][1] = s2;
        shapes2dArray[0][2] = s3;
        shapes2dArray[1][0] = s4;
        shapes2dArray[1][1] = s5;
        shapes2dArray[1][2] = s6;
        System.out.println("2D Array traversed: ");
        for (int r = 0; r < shapes2dArray.length; r++) {
            for (int c = 0; c < shapes2dArray[0].length; c++) {
                System.out.print(shapes2dArray[r][c].getType() + "   ");
            }
            System.out.println();
        }

        //calling recursive function
        int num = shapesArrayList.size();
        System.out.println("\n\nRecursive function: ");
        System.out.println(
            "Recursive Total Area: " + getTotalArea(shapesArrayList, num)
        );

    }


    //recursive fuction: finds total Area of all the shapes in the list
    public static double getTotalArea(ArrayList<Shapes> shapesArrayList, int index) {
        if (index - 1 < 0) {
            return 0;
        } else {

            System.out.println(
                "Index: " + index + "  Area: " + shapesArrayList.get(index - 1).getArea()
            );
            return shapesArrayList.get(index - 1).getArea() + getTotalArea(
                shapesArrayList,
                index - 1
            );

        }

    }

}
