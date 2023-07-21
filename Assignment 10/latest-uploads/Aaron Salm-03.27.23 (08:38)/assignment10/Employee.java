package assignment10;

public class Employee{
    private String name;
    private int age;
    private int pay;
    private String vacation;
    public String status;
    
    public Employee(){
        name = "Employee";
        age = 25;
        pay = 100000;
    }
    public Employee(String n, int a, int p){
        name = n;
        age = a;
        pay = p;
    }
    public void addVacation(String v){
        vacation = v;
    }
    public void addStatus(String st){
        status = st;
    }
    public void setAge(int age1){
        age = age1;
    }
    public int getAge(){
        return age;
    }
    public String toString(){
        String result = "Name: " + name + " - Age: " + age + " - Pay: " + pay + " - Vacation Time Remaining: " + vacation + " - Status: " + status;
        return result;
    }
}
