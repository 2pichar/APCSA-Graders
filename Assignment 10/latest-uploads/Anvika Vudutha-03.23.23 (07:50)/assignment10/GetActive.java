package assignment10;

public class GetActive
{
    private String age;
    private String type;
    private String timeNeeded;
    private int cost;

    public GetActive (String a, String t, String tn, int c)
    {
        age = a;
        type = t;
        timeNeeded = tn;
        cost = c;
    }

    public String getAge()
    {
        return age;
    }
}