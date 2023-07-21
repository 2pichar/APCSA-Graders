package assignment10;

public class MySubClass extends MyClass {
    private double salary;
    private String designation;

    public MySubClass(int id, String name, double salary, String designation) {
        super(id, name);
        this.salary = salary;
        this.designation = designation;
    }

    public MySubClass() {
        super();
        this.salary = 0.0;
        this.designation = "";
    }

    @Override
    public String getName() {
        return "Employee Name: " + super.getName();
    }

    public void printSalary() {
        System.out.println("Salary: " + this.salary);
    }

    @Override
    public String toString() {
        return "MySubClass [salary=" + salary + ", designation=" + designation + ", getId()=" + getId() + ", getName()="
                + getName() + "]";
    }
}
