package assignment10;

public class Player extends Team
{
    private String position;
    private String playerName;
    private int player;
    private String d;
    public Player(){
        this (1);
    }
    public Player(int player){
        this.player = player;
    }
    public String getName(){
    if (player == 1 || player == 2 || player ==3)
    {
        d = super.getPsg();
    }
    else if (player == 4 || player == 5 || player == 6){
        d = super.getRm();
    }
    return d;
    }

    
    public String posit()
    {
         if (player == 1){
            position = "Right Wing";
        }
        else if (player == 2){
            position = " Left Wing";
        }
       else if (player == 3){
            position = "Striker";
        }
        else if (player == 4){
            position = "Striker";
        }
        else if (player == 5){
            position = "Forward";
        }
        else if (player == 6){
            position = "CM";
        }
        
        return position;
    }


    public String getNameTwo()
    {
         if (player == 1){
            playerName = "Messi";
        }
        else if (player == 2){
            playerName = " Neymar";
        }
       else if (player == 3){
            playerName = "Mbappe";
        }
        else if (player == 4){
            playerName = "Benzema";
        }
        else if (player == 5){
            playerName = "Hazard";
        }
        else if (player == 6){
            playerName = "Tchouameni";
        }
        
        return playerName;
    }
}

