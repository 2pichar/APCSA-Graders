package assignment10;

import java.util.ArrayList;
import java.util.Scanner;
//Scanner scan = new Scanner(System.in);
public class Child extends Human {
    private int age;
    private boolean boy;
    private ArrayList < Integer > grades = new ArrayList<Integer>();
    public Child() {
        this.age = 10;
        this.boy = true;
    }
    public Child(int age) {
        this.age = age;
        this.boy = true;
    }
    public Child(int age, boolean boy) {
        this.age = 10;
        this.boy = boy;
    }



    public void readGrades() {
        grades.add(95);
        grades.add(87);
        grades.add(79);
        grades.add(100);
        grades.add(89);
        grades.add(92);
    }
    public void averageGrade() {
        int sum = 0;
        for (int i = 0; i < grades.size(); i++) {
            sum += grades.get(i);
        }
        System.out.println(sum / grades.size());
    }
    public String eat() {
        return "Child is eating";
    }
    public String sleep() {
        return "Child is sleeping";
    }
    public String work() {
        return "Child is working";
    }

    /* public repeatDay() {
        int n = scan.nextLine();
        //if (n =< 5) {
        eat();
        work();
        sleep();
        repeatDay();
    }
    Create 2 for loops{}
        String[3][3] seatingChart = new String [1, 2, 3, 4],
                                                [1, 2, 3, 4];
                                                */

}
