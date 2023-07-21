package assignment10;

public class report
{
    private int utmN; // coordinates North
    private int utmE;  //coordinates East
    private String speciesA;

    public report(int a, int b)
    {
        utmN = a;
        utmE = b;
    }
    public report(int a, int b, String x)
    {
        utmN = a;
        utmE = b;
        speciesA = x;
    }
    public report()
    {
        utmN = 0;
        utmE = 0;
        speciesA = "None";
    }
    public void setEastings(int a)
    {
        utmE = a;
    }
    public void setNorthings(int a)
    {
        utmN = a;
    }
    public int getEastings()
    {
        return utmE;
    }
    public int getNorthings()
    {
        return utmN;
    }
    public String toString()
    {
        return "reported at UTM Coordinate location:/n"+utmE+"E /n"+utmN+" N";
    }

    
}