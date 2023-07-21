package assignment10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        ArrayList<Book> list = new ArrayList<Book>();
        while(true)
        {
            System.out.println("To search for a book type \"Search\". To print the library, type \"print\". To add books, type \"add\".");
            String input = scan.nextLine();
            if(input.toUpperCase().equals("SEARCH"))
            {
                sort(list);
                System.out.print("Search Title: ");
                input = scan.nextLine();
                System.out.println(binarySearch(list, input));
            }
            else if(input.toUpperCase().equals("PRINT"))
            {
                printAll(list);
            }
            else if(input.toUpperCase().equals("ADD"))
            {
                addMore(list);
            }
        }
    }
    public static void addMore(ArrayList<Book> list)
    {
        Scanner scan = new Scanner(System.in);
        Boolean keepAdding = true;
        String title;
        String author;
        String yesno;
        while(keepAdding)
        {
            System.out.print("Title: ");
            title = scan.nextLine();
            System.out.print("Author: ");
            author = scan.nextLine();
            System.out.print("Is this an audiobook? (y/n): ");
            yesno = scan.nextLine();
            while(!(yesno.toUpperCase().equals("Y") || yesno.toUpperCase().equals("N")))
            {
                System.out.println("Input not understood.");
                System.out.print("Is this an audiobook? (y/n): ");
                yesno = scan.nextLine();
            }
            if(yesno.toUpperCase().equals("N"))
            {
                Book temp = new Book(title, author);
                System.out.print("Would you like to add an isbn? (y/n): ");
                String question = scan.nextLine();
                if(question.toUpperCase().equals("Y"))
                {
                    System.out.print("Enter isbn: ");
                    int isbn = scan.nextInt();
                    scan.nextLine();
                    temp.setIsbn(isbn);
                }
                list.add(temp);
            }
            if(yesno.toUpperCase().equals("Y"))
            {
                System.out.print("Who is the narrator?: ");
                String narrator = scan.nextLine();
                System.out.print("What is the duration in minutes?: ");
                int duration =  scan.nextInt();
                scan.nextLine();
                list.add(new AudioBook(title, author, narrator, duration));
            }
            System.out.print("Would you like to add more? (y/n): ");
            yesno = scan.nextLine();
            if(!yesno.toUpperCase().equals("Y"))
            {
                keepAdding = false;
            }
                
        }
    }
    //returns 2d array with 2 collumns, for title and author
    public static String[][] spreadSheat(ArrayList<Book> list)
    {
        String[][] output = new String[list.size()][2];
        for(int i = 0; i < list.size(); i++)
        {
            output[i][0] = list.get(i).getTitle();
            output[i][1] = list.get(i).getAuthor();
        }
        return output;
    }
    //prints the whole array
    public static void printAll(ArrayList<Book> list)
    {
        for(Book b : list)
        {
            System.out.println(b);
        }
    }
    //selection sort to put in alphabetical order
    public static void sort(ArrayList<Book> list)
    {
        for(int i = 0; i < list.size(); i++)
        {
            Book lowest = list.get(i);
            int lowIndex = i;
            for(int j = i + 1; j < list.size(); j++)
            {
                if(list.get(j).getTitle().compareTo(lowest.getTitle()) < 0)
                {
                    lowest = list.get(j);
                    lowIndex = j;
                }
            }
            Collections.swap(list, i, lowIndex);
        }
    }
    //uses binary search to find a title in a array of books
    public static Book binarySearch(ArrayList<Book> list, String target)
    {
        Book empty = new Book(null,null);
        ArrayList<Book> temp = new ArrayList<Book>();
        if(list.size() > 0)
        {
            if(list.get(list.size() / 2).getTitle().toUpperCase().compareTo(target.toUpperCase()) > 0)
            {
                for(int i = 0; i < list.size() / 2; i++)
                {
                    temp.add(list.get(i));
                }
                return binarySearch(temp, target);
            }
            else if(list.get(list.size() / 2).getTitle().toUpperCase().compareTo(target.toUpperCase()) < 0)
            {
                for(int i = list.size() / 2; i < list.size(); i++)
                {
                    temp.add(list.get(i));
                }
                return binarySearch(temp, target);
            }
            else if(list.get(list.size() / 2).getTitle().toUpperCase().equals(target.toUpperCase()))
            {
                return list.get(list.size() / 2);
            }
        }
        return empty;
        
    }
}
