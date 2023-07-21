package assignment10;

public class Jedi extends Character {
    private int lightsaberPower;

    public Jedi(String name, int health, int power, int lightsaberPower) {
        super(name, health, power);
        this.lightsaberPower = lightsaberPower;
    }

    public Jedi(String name) {
        this(name, 100, 10, 20);
    }

    public void attack(Character enemy) {
        System.out.println(name + " attacks " + enemy.getName() + " with power " + (power + lightsaberPower));
        enemy.defend(power + lightsaberPower);
    }

    public void forcePush(Character enemy) {
        System.out.println(name + " uses Force Push on " + enemy.getName());
        enemy.defend(power);
    }
}