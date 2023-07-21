package assignment10;

import java.util.ArrayList;

public class Subtask extends Task
{
    private ArrayList<String> subtaskDetails = new ArrayList<String>();
    private String parentTaskName;
    private static int priority = 0;

    public Subtask()
    {
        //nuh'in

    }

    public Subtask(Task task, String name, String desc, String due)
    {
        super(name, desc, due);
        parentTaskName = task.getName();

        subtaskDetails.add(name);
        subtaskDetails.add(desc);
        subtaskDetails.add(due);
        subtaskDetails.add("Parent: " + parentTaskName);
        subtaskDetails.add("" + priority);

        priority++;

    }

    public void complete()
    {

        super.complete();

    }

    public String toString()
    {

        return "[" + subtaskDetails.get(0) + ", " + subtaskDetails.get(1) + ", " + subtaskDetails.get(2) + ", " + subtaskDetails.get(3) + ", " + subtaskDetails.get(4) + "]"; 
        //return super.toString() + "\nParent Task: " + parentTaskName + "\nOrder: " + priority;

    }

}