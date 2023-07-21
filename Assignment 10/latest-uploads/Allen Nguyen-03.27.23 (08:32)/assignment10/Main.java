package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

 public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Basketball game program where you will chose the location, the teams, and the score that will simulate a basketball game.");
        System.out.println("Enter the location of the NBA game: ");
        String location = scanner.nextLine();
        System.out.println("Enter the total score of the NBA game: ");
        int score = scanner.nextInt();
        scanner.nextLine();
        System.out.println("Enter the name of the first team: ");
        String team1 = scanner.nextLine();
        System.out.print("Enter the name of the second team: ");
        String team2 = scanner.nextLine();

        NBA game = new NBA(location, score, team1, team2);

        // For Each Loop that prints out the players playing
        System.out.println("Here are the players thatare playing in the game.");
        String[] players = {"LeBron James", "Stephen Curry", "Kevin Durant", "Anthony Davis"};
        for (String player : players) {
            System.out.println(player);
        }

        // For Loop with ArrayList that adds coaches
    System.out.println("Here are the coaches that are coaching in this game.");
        ArrayList<String> coaches = new ArrayList<>();
        coaches.add("Greg Popovich");
        coaches.add("Darvin Ham");
        coaches.add("Steve Kerr");
        for (int i = 0; i < coaches.size(); i++) {
            System.out.println(coaches.get(i));
        }

       game.startGame();
       game.displayTeams();
       game.endGame();

        
    }
}
