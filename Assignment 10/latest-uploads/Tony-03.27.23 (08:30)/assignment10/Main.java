package assignment10;

import java.util.Scanner;
import java.util.ArrayList;

public class Main {
  public static void main(String[] args) {
    Scanner scan = new Scanner(System.in);
    int effort = 0;
    int IQ = 0;
   
    System.out.println(
        "Guess who it is, it's our new artist / singer / songwriter / music producer! What's your name (give me a good one) again?");
    String name = scan.nextLine();
    System.out.println("Right, right, welcome to our studio " + name + "!");
    System.out.println("Here's the list of activities that you need to do in order to be a real artist (only takes a month)!");
    String list[] = { "Singing", "Writing", "Creating a beat" };
    System.out.println("Activities:");
    for (String l : list) {
      System.out.println("\t" + l);
    }
     while (effort != 4){
    System.out.println(
        "How much time (hours) do you want to spend for each activity in the next following week?(type in three integer numbers)");
    System.out.print("Singing: ");
    int sing = scan.nextInt();
    System.out.print("Writing: ");
    int write = scan.nextInt();
    System.out.print("Creating a beat: ");
    int beat = scan.nextInt();
    scan.nextLine(); //Capture the trailing new line from 29
    int hours[] = { sing, write, beat };
    Singer you = new Singer(name, sing, write, beat);
    you.work();
    effort++;
} 
    System.out.println();
    System.out.println("You have spent four weeks and now it's time to release a song! What's your song that you plan to release?");
    System.out.print("Song name: ");
    String nameofsong = scan.nextLine();
    System.out.print("Meaning of the song: ");
    String meaning = scan.nextLine();
    System.out.println("Cool, now before we get into work, give me a palindrome word.");
    
    String input = scan.nextLine();
     String reverse = Yourself.reverseString(input);
    boolean palindrome = Yourself.isPalindrome(reverse);
    if (palindrome){
      System.out.println("Hah, good one! " + input + " is still " + input + "!");
      IQ += 100;
    } else {
      System.out.println("You've disappointed me! How come " + input  +" still the same backward? It's " + reverse + ", " +  "now get to work!");
    }
    System.out.println();
    
    System.out.println("In the meantime, you can work on your physical stamina and self-promotion. Here's the list of activities that you need to do: ");
  
 String activities[] = { "Workout (Cardio, Weight lifitng, etc.)", "Social Networking Butterfly (perform in big concerts, advertisement, etc.)" };
    System.out.println("Activities:");
    for (String a : activities) {
      System.out.println("\t" + a);
    }
    
while (effort != 8){
    System.out.println(
        "How much time (hours) do you want to spend for each activity in the next following week?(type in three integer numbers)");
    System.out.print("Singing: ");
    int sing = scan.nextInt();
    System.out.print("Writing: ");
    int write = scan.nextInt();
    System.out.print("Creating a beat: ");
    int beat = scan.nextInt();
    System.out.print("Workout: ");
    int workout = scan.nextInt();
    System.out.print("PR: ");
    int pr = scan.nextInt();
    int hours[] = { sing, write, beat, workout, pr};
    Yourself you = new Yourself(name, sing, write, beat, workout, pr);
    you.work();
    effort++;
}
  System.out.println();
  scan.nextLine();
    
  System.out.println("Oi, I have good news here to my dear one and only " + name + "(Type in g to continue)");
  String answer = scan.nextLine();
  answer = answer.toLowerCase();  
  String [] [] celebrities = new String[6][6];
  celebrities[0][0] ="Billie Eilish";
  celebrities[0][1] ="Justin Bieber";
  celebrities[0][2] ="21 Savage";
  celebrities[0][3] ="Ariande Grande";
  celebrities[0][4] ="Lil Baby";
  celebrities[0][5] ="Lil Durk";
  celebrities[1][0] ="Drake";
  celebrities[1][1] ="Taulor Swift";
  celebrities[1][2] ="The Weeknd";
  celebrities[1][3] ="Eminem";
  celebrities[1][4] ="A$AP Rocky";
  celebrities[1][5] ="Post Malone";
  celebrities[2][0] ="J Balvin";
  celebrities[2][1] ="ColdPlay";
  celebrities[2][2] ="Juice WRLD";
  celebrities[2][3] ="Dua Lipa";
  celebrities[2][4] ="Imagine Dragon";
  celebrities[2][5] ="Wallows";
  celebrities[3][0] ="P!nk";
  celebrities[3][1] ="Rihanna";
  celebrities[3][2] ="Maroon 5";
  celebrities[3][3] ="Travis Scott";
  celebrities[3][4] ="Shawn Mendes";
  celebrities[3][5] ="Kendrick Lamar";
  celebrities[4][0] ="Frank Ocean";
  celebrities[4][1] ="Harry Styles";
  celebrities[4][2] ="Nicki Minaj";
  celebrities[4][3] ="Adele";
  celebrities[4][4] ="J Cole";
  celebrities[4][5] ="Kate Perry";
  celebrities[5][0] ="Marshmello";
  celebrities[5][1] ="Artic Monkeys";
  celebrities[5][2] ="One Republic";
  celebrities[5][3] ="Charlie Puth";
  celebrities[5][4] ="Mac Miller";
  celebrities[5][5] ="Lewis Capaldi";  
  int randomA = (int)(Math.random() * celebrities.length);
  int randomB = (int)(Math.random() * celebrities[0].length);

    if(answer.equals("g")){
      System.out.println("Remeber the one song that named " + nameofsong + "? The Internet goes crazy about it and " + celebrities[randomA][randomB] + " have just contacted to me that want to collaborate with you!");
    } 
      System.out.println();
    ArrayList<String> GrammyAwards = new ArrayList<String>();
    GrammyAwards.add("Record Of The Year");
    GrammyAwards.add("Album Of The Year");
    GrammyAwards.add("Song Of The Year");
    int randomAwards = (int)(Math.random() * GrammyAwards.size());
    int numsofnominees = 0;
    String [] [] nominees = new String[3][3]; 
    System.out.println("*A year later on February 5th 2024* " + name + " got nominated on the Grammy Awards: " + GrammyAwards.get(randomAwards) + "!");
    System.out.println("As " + name + " looks up on the stage, " + name + " sees the other nominees such as: ");
    
    while (numsofnominees != 1){
    for (int r = 0; r < 3; r++)  // Accesses rows
{
  for (int c = 0; c < 3; c++) // Accesses columns 
  {
    int rInd = (int)(Math.random() * celebrities.length);
    int cInd = (int)(Math.random() * celebrities[0].length);
    
    nominees [r][c] = celebrities[rInd][cInd]; // copy the elements into the new 2-D list (it works if put in System.out.println but in that way, I'll be unable to copy the elements into the new 2-D list which I will randomize again to find out the winner)
  }
}
      for(String[] n : nominees){
        for(String celeb : n){
          System.out.print(celeb + ", ");
        }
      }
  numsofnominees++;
    }
    int rInd = (int)(Math.random() * nominees.length);
    int cInd = (int)(Math.random() * nominees[0].length);
    String randomWinner = nominees[rInd][cInd];
   System.out.println();
   System.out.println("The winner of the " + GrammyAwards.get(randomAwards) + " is " +  randomWinner +  "!!!");

    System.out.println();
    System.out.println("Hey no sweat. At least you got nominated and it only has been more than just one year! Congrats on being nominated " + name + " and we still have a long way to go!\nBy the way, " + name + " you have the opportunity to meet all these amazing celebrities: ");
    for (int r = 0; r < celebrities.length; r++)  // Accesses rows
{
  for (int c = 0; c < celebrities[0].length; c++) // Accesses columns 
  {
    System.out.print(celebrities[r][c] + ", "); // Prints elements on same line
  }
}
 }
}