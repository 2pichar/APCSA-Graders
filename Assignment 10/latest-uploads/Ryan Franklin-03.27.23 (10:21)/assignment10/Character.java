package assignment10;

public class Character {
protected String name;
protected int health;
protected int power;
public Character(String name, int health, int power) {
    this.name = name;
    this.health = health;
    this.power = power;
}

public Character(String name) {
    this(name, 100, 10);
}

public String getName() {
    return name;
}

public int getHealth() {
    return health;
}

public int getPower() {
    return power;
}

public void attack(Character enemy) {
    System.out.println(name + " attacks " + enemy.getName() + " with power " + power);
    enemy.defend(power);
}

public void defend(int power) {
    int damage = power - (int)(Math.random() * 5);
    health -= damage;
    if (health > 0) {
        System.out.println(name + " takes " + damage + " damage, remaining health: " + health);
    } else {
        System.out.println(name + " has been defeated.");
    }
}

public void takeDamage(int damage) {
    if (health > 0) 
    {
        System.out.println(name + " takes " + damage + " damage, remaining health: " + health);
        health -= damage;
        if (health <= 0) {
            System.out.println(name + " has been defeated.");
        }
    } 
}

public boolean isAlive() {
    return health > 0;
}

public void rest() {
    System.out.println(name + " rests and recovers some health.");
    health += 20;
    if (health > 100) {
        health = 100;
    }
}

public void drinkPotion() {
    System.out.println(name + " drinks a health potion and recovers some health.");
    health += 50;
    if (health > 100) {
        health = 100;
    }
}

public void levelUp() {
    System.out.println(name + " levels up and gains more power.");
    power += 5;
}

public void printStatus() {
    System.out.println(name + "'s current status: Health - " + health + ", Power - " + power);
}
}