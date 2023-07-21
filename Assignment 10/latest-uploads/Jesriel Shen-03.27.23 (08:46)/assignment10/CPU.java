package assignment10;

public class CPU extends Part
{
    private int numCores = 0;
    private double clockSpeed = 0;
    private double overclock = 0;
    public CPU()
    {
        super();
        this.numCores = 0;
    }
    public CPU(String name, String manufacturer, double price, int numCores, double clockSpeed)
    {
        super(name, manufacturer, price);
        this.numCores = numCores;
        this.clockSpeed = clockSpeed;
    }
    public int getNumCores()
    {
        return numCores;
    }
    public void setNumCores(int numCores)
    {
        this.numCores = numCores;
    }

    public double getClockSpeed()
    {
    return clockSpeed;
    }
    public void setClockSpeed(double clockSpeed)
    {
        this.clockSpeed = clockSpeed;
    }
    
    public double getOverclock()
    {
        return overclock;
    }
    public void setOverclock(double overclock)
    {
        if(overclock > clockSpeed)
        {
        this.overclock = overclock;
        }
    }
    public String toString()
    {
        return super.toString() + "\nNumber of Cores: " + getNumCores() + "\nClock Speed: " + getClockSpeed() + "GHz";
    }
public boolean equals(CPU p)
{
    boolean isEqual = super.equals(p);
    return isEqual && numCores == p.numCores && clockSpeed == p.clockSpeed && overclock == p.overclock;
}
public static boolean equals(CPU other, CPU other2)
{
    if(other.getNumCores() > other2.getNumCores() && other.getClockSpeed() > other2.getClockSpeed())
    {
        return true;
    }
    return false;
}
}