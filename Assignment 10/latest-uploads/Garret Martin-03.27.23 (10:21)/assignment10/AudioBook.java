package assignment10;

public class AudioBook extends Book
{
    String narrator;
    int duration;
	public AudioBook(String title, String author, String narrator, int duration)
	{
        super(title, author);
        this.narrator = narrator;
        this.duration = duration;
    }
    public AudioBook()
    {
        this("Default", "None", "None", 60);
    }
    public String getNarrator()
    {
        return narrator;
    }
    public int getDuration()
    {
        return duration;
    }
    //prints duration in format of 1:20 hours
    public void printDuration()
    {
        System.out.println(duration / 60 + ":" + duration % 60);
    }
	public String toString()
    {
        return super.toString() + " Narrated by " + narrator + ". Duration: " + duration / 60 + ":" + duration % 60 + " hours.";
    }
}
