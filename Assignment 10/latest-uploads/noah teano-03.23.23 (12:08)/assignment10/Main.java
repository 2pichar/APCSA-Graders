package assignment10;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        String subTaskString = "";
        //Taskviewer view = new Taskviewer();
        Scanner scan = new Scanner(System.in);
        System.out.print("Welcome to To-Do list. Would you like to add a task? (y/n)\n");
        String answer = scan.nextLine();
        
        while (answer.equals("y") || answer.equals("Y") || answer.equals("yes") || answer.equals("Yes"))
        {

            System.out.print("\nTitle: ");
            String nameEnter = scan.nextLine();
            System.out.print("Description: ");
            String descEnter = scan.nextLine();
            System.out.print("Due Date: ");
            String dueEnter = scan.nextLine();

            Task task = new Task(nameEnter, descEnter, dueEnter);
            //view.add(task);

            System.out.println("\nDo you want to add steps to this task? (y/n)");
            String subAnswer = scan.nextLine();
            while (subAnswer.equals("y"))
            {

                System.out.print("\nTitle: ");
                String nameSubEnter = scan.nextLine();
                System.out.print("Description: ");
                String descSubEnter = scan.nextLine();
                System.out.print("Due Date: ");
                String dueSubEnter = scan.nextLine();
                Subtask subtask = new Subtask(task, nameSubEnter, descSubEnter, dueSubEnter);
                subTaskString += subtask.toString() + "\n";

                System.out.println("\nDo you want to add another step? (y/n)");
                subAnswer = scan.nextLine();

            }

            System.out.println("\nWould you like to add another task? (y/n)");
            answer = scan.nextLine();

        }

        System.out.println("\nActions:\n1.View your Agenda\n2.Complete a Task\n3.View your Subtasks");
        String answer2 = scan.nextLine();

        while (answer2.equals("1"))
        {

            //taskviewer tostring method
            //System.out.print("\n" + view.toString());

            System.out.println("\nActions:\n1.View your Agenda\n2.View your Subtask\n3.Complete a Task");
            answer2 = scan.nextLine();

        } 
        
        while (answer2.equals("3"))
        {

            //System.out.println("\n" + view.toString());
            System.out.println("Type the task # you have completed:");
            int numComplete = scan.nextInt();

            //remove task
            //view.complete(numComplete);
            //System.out.println("\n" + view.toString());

            System.out.println("\nActions:\n1.View your Agenda\n2.View your Subtask\n3.Complete a Task");
            answer2 = scan.nextLine();

        }

        while (answer2.equals("2"))
        {

            //print subtask string
            System.out.print(subTaskString);

            System.out.println("\nActions:\n1.View your Agenda\n2.View your Subtask\n3.Complete a Task");
            answer2 = scan.nextLine();

        }

    }

}
