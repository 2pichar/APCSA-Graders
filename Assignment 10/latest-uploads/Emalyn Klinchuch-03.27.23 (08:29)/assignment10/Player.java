package assignment10;

import java.util.ArrayList;
public class Player
{
    private boolean isX;
    private ArrayList<int[]> moves;

    //Constructors
    public Player(boolean isX)
    {
        this.isX = isX;
        moves = new ArrayList<int[]>();
    }

    public Player()
    {
        this(true);
    }

    //Accessors
    public boolean getIsX()
    {
        return isX;
    }

    public ArrayList<int[]> getMoves()
    {
        return moves;
    }

    //Methods
    //Places the piece at the given move
    //Precondition: move is legal
    public String[][] place(String[][] gameBoard, int[] move)
    {
        int r = move[0];
        int c = move[1];
        if (isX)
        {
            gameBoard[r][c] = "X"; 
        }
        else
        {
            gameBoard[r][c] = "O";
        }
        moves.add(move);
        return gameBoard;    
    }

    public int getNumMoves()
    {
        return moves.size();
    }
}