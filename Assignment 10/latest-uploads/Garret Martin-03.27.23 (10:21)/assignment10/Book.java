package assignment10;

public class Book
{
    String title;
    String author;
    int isbn;
    Boolean isAvailable;
    public Book(String title, String author, int isbn)
    {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        isAvailable = true;
    }
    public Book(String title, String author)
    {
        this(title, author, -1);
    }
    public Book()
    {
        this("Book", "None");
    }
    public void setIsbn(int isbn)
    {
        this.isbn = isbn;
    }
    public String getTitle()
    {
        return title;
    }
    public String getAuthor()
    {
        return author;
    }
    public Boolean isAvailable()
    {
        return isAvailable();
    }
    public void take()
    {
        isAvailable = false;
    }
    public void dropOff()
    {
        isAvailable = true;
    }
    public int getIsbn()
    {
        return isbn;
    }
    public String toString()
    {
        return ("\"" + title + "\", by " + author + ".");
    }
}