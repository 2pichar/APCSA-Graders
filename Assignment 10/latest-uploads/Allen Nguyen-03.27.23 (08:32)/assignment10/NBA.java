package assignment10;

import java.util.ArrayList;

public class NBA extends BasketballGame {
private String team1;
private String team2;

public NBA() {
    this.team1 = "Unknown";
    this.team2 = "Unknown";

}
public NBA(String location, int score, String team1, String team2) {
    super(location, score);
    this.team1 = team1;
    this.team2 = team2;
}


public void startGame() {
    System.out.println("The NBA game between " + team1 + " and " + team2 + " has started at " + getLocation());
}

public void displayTeams() {
    System.out.println("The teams playing in this NBA game are: " + team1 + " and " + team2);
}
}



