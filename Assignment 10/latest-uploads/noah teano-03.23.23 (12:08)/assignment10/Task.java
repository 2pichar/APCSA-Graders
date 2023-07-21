package assignment10;

public class Task 
{

    private String name;
    private String description;
    private String dueDate;
    private boolean completion = false;
    private String[] task;
    private String[][] idk;

    public Task() 
    {

        this("n/a", "n/a", "n/a");

    }

    public Task(String name, String dueDate) 
    {

        this(name, "n/a", dueDate);

    }

    public Task(String name, String description, String dueDate) 
    {

        this.name = name;
        this.description = description;
        this.dueDate = dueDate;

        task = new String[3];
        task[0] = name;
        task[1] = description;
        task[2] = dueDate;

    }

    public void idk(String[][] twodarray)
    {

        twodarray[0][0] = "1";

    }

    public String forLoop()
    {

        for (String str : task)
        {

            return "1";

        }

        return "0";

    }

    public void setDue(String time) 
    {

        dueDate = time;
        task[2] = time;

    }

    public String getName() 
    {

        return name;

    }

    public String getDescription() 
    {

        return description;

    }

    public String getDueDate() 
    {

        return dueDate;

    }

    public void complete()
    {

        completion = true;

    }

    public String toString() 
    {

        return "\nName: " + task[0] + "\nDescription: " + task[1] + "\nDue Date: " + task[2];
        
    }
}
