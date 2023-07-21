package assignment10;

import java.util.Scanner;
public class Runner
{
    public static void main(String[] args)
    {
        Scanner scan = new Scanner(System.in);
        String[][] gameBoard = new String[3][3];
        //Fils the game board with "-" (representing no moves)
        for (int r = 0; r < gameBoard.length; r++)
        {
            for (int c = 0; c < gameBoard[r].length; c++)
            {
                gameBoard[r][c] = "-";
            }
        }

        System.out.println("Welcome to Tic-Tac-Toe!");
        System.out.println("Would you like to be X or O? (Type \"X\" or \"O\")");
        String xOrO = scan.nextLine();
        //Error message if user doesn't pick x or o
        while (!(xOrO.toLowerCase().equals("x") || xOrO.toLowerCase().equals("o")))
        {
            System.out.println("That's not one of the choices!");
            System.out.println("Would you like to be X or O? (Type \"X\" or \"O\")");
            xOrO = scan.nextLine();
        }

        //Creating player and computer objects
        Player p;
        Computer c;
        if (xOrO.toLowerCase().equals("x"))
        {
            p = new Player(true);
            c = new Computer(false);
        }
        else
        {
            p = new Player(false);
            c = new Computer(true);
        }

        //0 = tie, 1 = user, 2 = computer
        int winner = 0;
        if (p.getIsX() == true)
        {
            for (int i = 0; i < 9; i++)
            {
                gameBoard = userTurn(gameBoard, p);
                i++;
                if (gameOver(gameBoard) == 1)
                {
                    winner = 1;
                    break;
                }
                else if (gameOver(gameBoard) == 0)
                {
                    winner = 2;
                    break;
                }
                gameBoard = computerTurn(gameBoard, c);
                if (gameOver(gameBoard) == 1)
                {
                    winner = 1;
                    break;
                }
                else if (gameOver(gameBoard) == 0)
                {
                    winner = 2;
                    break;
                }
            }
        }
        else
        {
            for (int i = 0; i < 9; i++)
            {
                gameBoard = computerTurn(gameBoard, c);
                i++;
                if (gameOver(gameBoard) == 1)
                {
                    winner = 2;
                    break;
                }
                else if (gameOver(gameBoard) == 0)
                {
                    winner = 1;
                    break;
                }
                gameBoard = userTurn(gameBoard, p);
                if (gameOver(gameBoard) == 1)
                {
                    winner = 2;
                    break;
                }
                else if (gameOver(gameBoard) == 0)
                {
                    winner = 1;
                    break;
                }
            }
        }

        System.out.println();
        System.out.println(gameBoardToString(gameBoard));
        System.out.println("The game is over!");
        if (winner == 1)
        {
            System.out.println("You win!");
            System.out.println("Won in " + p.getNumMoves() + " moves");
        }
        else if (winner == 2)
        {
            System.out.println("You lose!");
            System.out.println("Won in " + c.getNumMoves() + " moves");
        }
        else 
        {
            System.out.println("It's a tie!");
        }

        System.out.println("Would you like to play again? (y/n)");
        String playAgain = scan.nextLine();
        if (playAgain.toLowerCase().equals("y"))
        {
            main(args);
        }
    }

    public static String gameBoardToString(String[][] gameBoard)
    {
        String returnString = "";
        returnString+= gameBoard[0][0] + " | " + gameBoard[0][1] + " | " + gameBoard[0][2] + "\n";
        returnString+= "--+---+--\n";
        returnString+= gameBoard[1][0] + " | " + gameBoard[1][1] + " | " + gameBoard[1][2] + "\n";
        returnString+= "--+---+--\n";
        returnString+= gameBoard[2][0] + " | " + gameBoard[2][1] + " | " + gameBoard[2][2];
        return returnString;
    }

    public static String[][] userTurn(String[][] gameBoard, Player user)
    {
        Scanner scan = new Scanner(System.in);
        int[] move = new int[2];
        System.out.println(gameBoardToString(gameBoard));
        System.out.println();
        System.out.println("It's your turn! Which row did you want to go in? (1-3)");
        move[0] = scan.nextInt() - 1;
        System.out.println("Which column did you want to go in? (1-3)");
        move[1] = scan.nextInt() - 1;
        //Error message if spot is taken
        while (!(gameBoard[move[0]][move[1]].equals("-")))
        {
            System.out.println("That spot is taken!");
            System.out.println("Which row did you want to go in? (1-3)");
            move[0] = scan.nextInt() - 1;
            System.out.println("Which column did you want to go in? (1-3)");
            move[1] = scan.nextInt() - 1;
        }
        
        //Places the piece in the move the user selected
        gameBoard = user.place(gameBoard, move);

        return gameBoard;
    }

    public static String[][] computerTurn(String[][] gameBoard, Computer computer)
    {
        int[] move = computer.randomMove(gameBoard);
        System.out.println(gameBoardToString(gameBoard));
        System.out.println();
        System.out.println("It's the computer's turn!");
        System.out.println("The computer chose row " + (move[0] + 1) + ", column " + (move[1] + 1));

        //Places the piece in the move the computer selected
        gameBoard = computer.place(gameBoard, move);

        return gameBoard;
    }

    //Checks if the game is over
    //Returns 1 if x won, 0 if o won, and -1 if the game is still going on
    public static int gameOver(String[][] gameBoard)
    {
        //Search for X
        if (gameBoard[0][0].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][2].equals("X"))
        {
            return 1;
        }
        if (gameBoard[0][2].equals("X") && gameBoard[1][1].equals("X") && gameBoard[2][0].equals("X"))
        {
            return 1;
        }
        int[] xFound = new int[2];
        xFound = searchArray(gameBoard, "X", 0, 0);
        while (xFound[0] >= 0)
        {
            boolean found = true;
            //Search horizontally
            for (int c = xFound[1]; c < xFound[1] + 3; c++)
            {
                if (c > 2 || !(gameBoard[xFound[0]][c].equals("X")))
                {
                    found = false;
                }
            }

            //If found
            if (found)
            {
                return 1;
            }

            //Search vertically
            found = true;
            for (int r = xFound[0]; r < xFound[0] + 3; r++)
            {
                if (r > 2 || !(gameBoard[r][xFound[1]].equals("X")))
                {
                    found = false;
                }
            }

            //If found
            if (found)
            {
                return 1;
            }

            //Search again
            if (xFound[1] == 2)
            {
                xFound = searchArray(gameBoard, "X", xFound[0] + 1, 0);
            }
            else
            {
                xFound = searchArray(gameBoard, "X", xFound[0], xFound[1] + 1);
            }
        }

        //Search for O
        if (gameBoard[0][0].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][2].equals("O"))
        {
            return 0;
        }
        if (gameBoard[0][2].equals("O") && gameBoard[1][1].equals("O") && gameBoard[2][0].equals("O"))
        {
            return 0;
        }
        int[] oFound = new int[2];
        oFound = searchArray(gameBoard, "O", 0, 0);
        while (oFound[0] >= 0)
        {
            boolean found = true;
            //Search horizontally
            for (int c = oFound[1]; c < oFound[1] + 3; c++)
            {
                if (c > 2 || !(gameBoard[oFound[0]][c].equals("O")))
                {
                    found = false;
                }
            }

            //If found
            if (found)
            {
                return 0;
            }

            //Search vertically
            found = true;
            for (int r = oFound[0]; r < oFound[0] + 3; r++)
            {
                if (r > 2 || !(gameBoard[r][oFound[1]].equals("O")))
                {
                    found = false;
                }
            }

            //If found
            if (found)
            {
                return 0;
            }

            //Search again
            if (oFound[1] == 2)
            {
                oFound = searchArray(gameBoard, "O", oFound[0] + 1, 0);
            }
            else
            {
                oFound = searchArray(gameBoard, "O", oFound[0], oFound[1] + 1);
            }
        }

        return -1;
    }
    
    public static int[] searchArray(String[][] gameBoard, String target, int startingRow, int startingCol)
    {
        int[] result = new int[2];
        if (startingRow > 2 || startingCol > 2)
        {
            result[0] = -1;
            result[1] = -1;
            return result;
        }
        for (int c = startingCol; c < 3; c++)
        {
            if (gameBoard[startingRow][c].equals(target))
            {
                result[0] = startingRow;
                result[1] = c;
                return result;
            }
        }
        for (int r = startingRow + 1; r < 3; r++)
        {
            for (int c = 0; c < 3; c++)
            {
                if (gameBoard[r][c].equals(target))
                {
                    result[0] = r;
                    result[1] = c;
                    return result;
                }
            }
        }
        result[0] = -1;
        result[1] = -1;
        return result;
    }
}