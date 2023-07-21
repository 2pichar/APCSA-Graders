package assignment10;

import java.util.ArrayList;

public class CF extends Game{

        private String[][] board;
        private String piece;

    public CF()
    {
        this("Connect Four");
    }

    public CF(String n)
    {
        super(n);
        board = new String[6][7];

        for (int i = 0; i < board.length; i++)
        {
            for (int j = 0; j < board[i].length; j++)
            {
                board[i][j] = "_";
            }
        }
    }

    public void addPlayer(ArrayList<String> p)
    {
        
        super.addPlayer(p);
        
        if(p.size() > 2)
        {
            System.out.println("Player: " + p.get(p.size() - 1) + " Removed");
            p.remove(p.size() - 1);
            addPlayer(p);
        }
        else {
            System.out.print("Player: " + p.get(0) + " and " + p.get(1) + " added");
        }
    }

    //Check which column he wants to put
    //if the row and column are not null. the row will be subtract by 1
    //Else change null to the piece that player set to.
    public void makeMove(int column, String chess)
    {
        piece = chess;
        for (int i = 0; i <= 5; i++)
        {
            if (board[i][column - 1].equals("_"))
            {
                board[i][column - 1] = chess;
                break;
            }
        }
    }

    //Check if there's 4 in the row at any direction.
    public boolean checkWin(String p)
    {
        boolean win = false;
        
        //check horizontal
        for(int r = 5; r >= 0; r--)
        {
            for(int c = 0; c < 4; c++)
            {
                if (board[r][c].equals(p) && board[r][c+1].equals(p) && board[r][c+2].equals(p) && board[r][c+3].equals(p))
                {
                    win = true;
                    break;
                }
            }
        }

        //Check vertical.
        for (int r = 5; r > 2; r--)
        {
            for (int c = 0; c < 7; c++)
            {
                if (board[r][c].equals(p) && board[r-1][c].equals(p) && board[r-2][c].equals(p) && board[r-3][c].equals(p))
                {
                    win = true;
                    break;
                }
            }
        }

        //Check Diagonal
        for (int r = 5; r > 2; r--)
        {
            for (int c = 0; c < 4; c++)
            {
                if (board[r][c].equals(p) && board[r-1][c+1].equals(p) && board[r-2][c+2].equals(p) && board[r-3][c+3].equals(p))
                {
                    win = true;
                    break;
                }
            }

            for (int c = 6; c > 2; c--)
            {
                if (board[r][c].equals(p) && board[r-1][c-1].equals(p) && board[r-2][c-2].equals(p) && board[r-3][c-3].equals(p))
                {
                    win = true;
                    break;
                }
            }
        }


        return win;
    }
    
    //Show Board.
    public void showBoard()
    {
        for (int r = 5; r >= 0; r--)
        {
            for (int c = 0; c < 7; c++)
            {
                System.out.print(" ");
                System.out.print(board[r][c]);
                System.out.print(" ");
            }

            System.out.println("\n");
        }
    }
    
    public String getPiece()
    {
        return piece;
    }

    public String toString()
    {
        
        String s = super.toString() + "\n";

        return s;
    }

}