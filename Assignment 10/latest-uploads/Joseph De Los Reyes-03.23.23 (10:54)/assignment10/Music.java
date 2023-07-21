package assignment10;

public class Music{
 private String theArtist;
 private String theSong;
 private int streams;

  public Music()
  {
    this("NA","John Doe",1000);
  }
  public Music(String a, String s, int st)
  {
      theSong = s;
    theArtist = a;
    streams = st;
  }
  public int getStreams()
  {
      return streams;
  }

  public String toString()
  { 
    
    String s =  "\n" + theArtist +" is making a new song and the song is called: " + theSong;
    
    return s;
}
public String howPopular()
{
    String s ="";
    if (streams < 10000)
    {
        s+= theArtist + " is just starting out!";
    }
    else if (streams  >= 10000 && streams < 100001)
    {
s += theArtist + " is making a name for themselves!";

    }
    else
    {
        s += theArtist + " is one of the biggest musicians out there!";
    }
    return s;
}

    



}