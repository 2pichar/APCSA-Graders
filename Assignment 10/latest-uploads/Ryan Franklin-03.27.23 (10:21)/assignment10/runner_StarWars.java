package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

public class runner_StarWars {
    public static void main(String[] args) {

        // ArrayList for Characters
        ArrayList<Character> characters = new ArrayList<>();

        // Adding new characters to ArrayList
        Character c1 = new Character("Luke Skywalker", 100, 15);
        Jedi j1 = new Jedi("Obi-Wan Kenobi", 120, 12, 25);
        Jedi j2 = new Jedi("Darth Vader", 150, 20, 30);
        characters.add(c1);
        characters.add(j1);
        characters.add(j2);

        // Creating a 2D ArrayList of type Character
        ArrayList<ArrayList<Character>> characterGrid = new ArrayList<>();

        // Adding new rows to the 2D ArrayList
        ArrayList<Character> row1 = new ArrayList<>();
        row1.add(c1);
        row1.add(j1);
        characterGrid.add(row1);

        ArrayList<Character> row2 = new ArrayList<>();
        row2.add(j2);
        characterGrid.add(row2);

        // Accessing elements from the ArrayList and 2D ArrayList
        Scanner scanner = new Scanner(System.in);
        boolean isGameOver = false;
        while (!isGameOver) {
            for (ArrayList<Character> row : characterGrid) {
                for (Character c : row) {
                    System.out.println(c.getName() + " has " + c.getHealth() + " health and " + c.getPower() + " power");
                }
            }
            System.out.println("Select a character to attack:");
            String selectedCharacterName = scanner.nextLine();
            System.out.println("Select an enemy to attack:");
            String selectedEnemyName = scanner.nextLine();

            Character selectedCharacter = null;
            for (Character c : characters) {
                if (c.getName().equals(selectedCharacterName)) {
                    selectedCharacter = c;
                    break;
                }
            }

            Character selectedEnemy = null;
            for (ArrayList<Character> row : characterGrid) {
                for (Character c : row) {
                    if (c.getName().equals(selectedEnemyName)) {
                        selectedEnemy = c;
                        break;
                    }
                }
            }

            if (selectedCharacter != null && selectedEnemy != null) {
                selectedCharacter.attack(selectedEnemy);
                if (selectedEnemy.getHealth() <= 0) {
                    System.out.println(selectedEnemy.getName() + " has been defeated!");
                    characterGrid.remove(selectedEnemy);
                    characters.remove(selectedEnemy);
                }
            } else {
                System.out.println("Invalid input. Try again.");
            }

            if (characters.size() == 0 || characterGrid.size() == 0) {
                isGameOver = true;
                System.out.println("Game over!");
            }
        }
    }
}
