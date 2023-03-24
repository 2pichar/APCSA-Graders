package assignment10;

class Person {
    String name;
    String nickName;

    public Person(){
        name = "John Doe";
        nickName = "Dude";
    }

    public Person(String name, String nickName){
        this.name = name;
        this.nickName = nickName;
    }

    public String getName(){
        return name;
    }
    public String getNickName(){
        return nickName;
    }
    
    public String toString(){
        String s = "Name: " + name + ", \nNickname: " + nickName;
        return s;
    }
}