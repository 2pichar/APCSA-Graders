package assignment10;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        // Prints "Hello, World" to the terminal window.
        
        Scanner scan = new Scanner(System.in);

        System.out.println("Welcome to Board Game Room!");
        System.out.println("Please provide the names of all the players");
        System.out.println("");
        System.out.println("Input *stop* to finish inputing players");
        
        String name = scan.nextLine();
        ArrayList<String> p = new ArrayList<String>();

        while (!(name.equals("stop") || name.equals("Stop")))
        {

                p.add(name);
                name = scan.nextLine();
        }

        if (p.size() < 2)
        {
            System.out.println("There are less than 2 player, player added for you");
            p.add("Player1");
            p.add("Player2");
        }

        System.out.println("There are " + p.size() + " Players");
        System.out.print("All the players name: ");
        for (int i = 0; i < p.size(); i++)
        {
            System.out.print(p.get(i) + " ");
        }
        

        System.out.println("");
        System.out.println("");
        System.out.println("What kind of game would you like to play?");
        System.out.println("1. Connect Four");
        int chooseGame = scan.nextInt();

        if (chooseGame == 1)
        {
            System.out.println("You chosed Connect Four.");
        }
        else {
            System.out.println("Invalid choice, Connect Four selected.");
        }

        System.out.println("");

        CF game = new CF();

        if (p.size() > 2)
        {
            System.out.println("There are more than 2 players: I will remove players until there are 2 players");
        }

        game.addPlayer(p);

        String[] pieces = new String[2];
        System.out.println("");
        System.out.println("Please select the pieces "+ p.get(0) +" want for every place(No _ or blank)");
        scan.nextLine();
        pieces[0] = scan.nextLine();
        System.out.println("Then please select a piece for " + p.get(1));
        pieces[1] = scan.nextLine();

        while (pieces[0].equals(pieces[1])) {
    char lastChar = pieces[0].charAt(pieces[1].length() - 1);
    if (lastChar == 'z') {
        pieces[1] = pieces[1].substring(0, pieces[1].length() - 1) + 'a' + 'z';
    } else {
        pieces[1] = pieces[1].substring(0, pieces[1].length() - 1) + (char) (lastChar + 1);
    }
}

        for (int i = 0; i < pieces.length; i++)
        {
            System.out.println(pieces[i] + " = " + p.get(i));
        }
        
        boolean win = false;

        while(!win)
        {
            System.out.println("Now is " + p.get(0) + " turn");
            game.showBoard();
            System.out.println("Which Column would you like to put in?");
            int p1 = scan.nextInt();
            game.makeMove(p1, pieces[0]);

            win = game.checkWin(pieces[0]);
            
            if (win)
            {
                break;
            }

            System.out.println("Then is " + p.get(1) + "'s turn");
            game.showBoard();
            System.out.println("Which Column would you like to put in?");
            int p2 = scan.nextInt();
            game.makeMove(p2, pieces[1]);
            
            win = game.checkWin(pieces[1]);
        }

        game.showBoard();
        String s = game.toString();

    
        System.out.println(s);
        
        String getP = game.getPiece();
        
        for (int i = 0; i < pieces.length; i++) {
        String piece = pieces[i];
            for (String player : p) {
                if (getP.equals(piece)) {
                System.out.println("Player: " + player + " Won!");
                break;
        }
    }
}
    }

}
