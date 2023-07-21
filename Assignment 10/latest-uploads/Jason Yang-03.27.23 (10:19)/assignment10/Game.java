package assignment10;

import java.util.ArrayList;

public class Game {

    private String name;
    ArrayList<String> players = new ArrayList<String>();
    
    public Game()
    {
        this("Connect Four");
    }

    public Game(String n)
    {
        name = n;
    }
    
    public void addPlayer(ArrayList<String> p)
    {
            players = p;
    }

    public String getPlayers()
    {
        String Pname = "";

        for (int i = 0; i < players.size(); i++)
        {
            Pname += players.get(i) + ", ";
        }

        return Pname;
    }

    public String toString()
    {
        String s = "";

        s += "Game: " + name;
        return s;
    }
    





}