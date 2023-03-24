package assignment10;

class Student extends Person{
        String school;
        int year;

    public Student(){
        year = 9;
        school = "El Toro";
    }

    public Student(int year, String school){
        this.year = year;
        this.school = school;
    }

    public String toString(){
        String name = getName();
        String s = "Student Name: " + getName() + ", \nNickname: " + getNickName();
        return s;
    }

    public String yearToString(int year){
        String yearString = "";
        if (year == 9)
        yearString = "Freshman";
        else if (year == 10)
        yearString = "Sophmore";
        else if (year == 11)
        yearString = "Junior";
        else 
        yearString = "Senior";
    
    return yearString;
    }

}