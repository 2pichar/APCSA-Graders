package assignment10;

class Team
{
    private String name; 
    private int num;
    private int clubRanking;


    public Team(){
        this(1);
    }
    

    public Team(int num){
        this.num = num;


    }
    public String getName()
    {
        if (num == 1)
        {
            name = "Paris Saint-Germain F.C.";
        }
        if (num ==2)
        {
            name = "Real Madrid CF";
        }
        return name;
        
    }
    public int getClubRank()
    {
        if (num == 1)
        {
            clubRanking = 1;
        }
        if (num ==2){
            clubRanking = 2;
        }
        return clubRanking;
    }

public String getPsg()
{
return "PSG";
}
public String getRm()
{
    return "rm";
}
public int mystery(int x)
{
	if(x < 1)
		return 1;
	else
	{
		return x + mystery(x-2) + mystery(x-3);
}
}



}