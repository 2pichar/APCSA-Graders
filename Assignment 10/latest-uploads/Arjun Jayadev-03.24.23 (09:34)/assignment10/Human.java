package assignment10;

public class Human {
    private int age;
    private boolean parent;


    public Human() {
        age = 30;
        parent = false;
    }
    public Human(int age, boolean parent) {
        this.age = age;
        this.parent = parent;
    }

    public void senior(int age) {
        if (age > 60) {
            System.out.println("Senior citizen");
        } else {
            System.out.println("Not a senior citizen");
        }
    }
    public void arrayReadWrite() {
        int[] a = {
            10,
            20,
            30,
            40,
            50,
            60,
            70,
            80,
            90,
            100
            };
        if (age % 10 == 0) {
            System.out.println("The array is ");
            for (int value : a) {
                System.out.println(value);
            }
        }
    }

     public String eat() {
        return "Human is eating";
    }
     public String sleep() {
        return "Human is sleeping";
    }
    public String work() {
        return "Human is working";
    }

    public void setAge(int age) {
        this.age = age;
    }
    public void setFather(boolean parent) {
        this.parent = parent;
    }
}
