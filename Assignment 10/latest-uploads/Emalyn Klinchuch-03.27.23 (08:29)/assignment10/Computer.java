package assignment10;

import java.util.ArrayList;
import java.lang.Math;
public class Computer extends Player
{
    private ArrayList<int[]> randomMoves;
    private boolean won;

    //Constructors
    public Computer(boolean isX)
    {
        super(isX);
        randomMoves = new ArrayList<int[]>();
        won = false;
    }

    public Computer()
    {
        super();
        randomMoves = new ArrayList<int[]>();
        won = false;
    }

    //Accessors
    public ArrayList<int[]> getRandomMoves()
    {
        return randomMoves;
    }

    //Methods
    //Returns a random move given the current game board
    //Precondition: game board is not full
    public int[] randomMove(String[][] gameBoard)
    {
        int[] move = new int[2];
        int r = (int) (Math.random() * 3);
        int c = (int) (Math.random() * 3);
        if (!gameBoard[r][c].equals("-"))
        {
            return randomMove(gameBoard);
        }
        move[0] = r;
        move[1] = c;
        randomMoves.add(move);
        return move;
    }

    public boolean findRandomMove(int[] move)
    {
        for (int i = 0; i < randomMoves.size(); i++)
        {
            if (randomMoves.get(i).equals(move))
            {
                return true;
            }
        }
        return false;
    }

    public int getNumMoves()
    {
        return randomMoves.size();
    }
}