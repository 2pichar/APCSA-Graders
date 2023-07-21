package assignment10;

import java.util.ArrayList;

public class BasketballGame {
private String location;
private int score;

public BasketballGame() {
    this.location = "Unknown";
    this.score = 0;
}

public BasketballGame(String location, int score) {
    this.location = location;
    this.score = score;
}

public void startGame() {
    System.out.println("The basketball game has started at " + location);
}

public void endGame() {
    System.out.println("The basketball game has ended with a final score of " + score);
}

public String getLocation() {
    return location;
}

public void setLocation(String location) {
    this.location = location;
}

public int getScore() {
    return score;
}

public void setScore(int score) {
    this.score = score;
}
}