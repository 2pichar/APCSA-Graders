package assignment10;

import java.util.Scanner;
import java.util.ArrayList;
public class Runner {

public static void main(String[] args)
  {
Scanner scan = new Scanner(System.in);

   ArrayList<Music> listOfSongs = new ArrayList<Music>();
   Music s1 = new Music();
   Music s2 = new Music();
   Music s3 = new Music();
   Music s4 = new Followers();
   Music s5 = new Music();
   Music s6 = s5;
   Music s7 = new Music();
   Music s8 = new Followers();
   Music s9 = new Followers("bro", "djdjh", 10000000, 20000);
   Music s10 = s8;
listOfSongs.add(s1);
   listOfSongs.add(s2);
   listOfSongs.add(s3);
   listOfSongs.add(s4);
   listOfSongs.add(s5);
   listOfSongs.add(s6);
   listOfSongs.add(s7);
   listOfSongs.add(s8);
   listOfSongs.add(s9);
   listOfSongs.add(s10);
    String n ="";
    for(int i = 0; i < listOfSongs.size() ;i++)
    {
  
      System.out.println(listOfSongs.get(i));
      
      }
String[] word = {"algorithm", "boolean", "int", "double"};
      for (String s: word) 
{
System.out.println(s);
}
   
    

}
}
