package assignment10;

import java.io.*;
import java.util.Scanner;

public class Yourself extends Singer{
  private int stamina;
  private int selfpromotion;
  public Yourself(){
    super();
    this.stamina = 0;
    this.selfpromotion = 0;
  }

  public Yourself(String name, int s, int w, int b, int sta, int promotion){
    super(name, s, w, b);
    this.stamina = sta;
    this.selfpromotion = promotion;
  }

  public void work() {
    int numsofdays = 7;
    int lengthComments = getCommentslength();
    int[] indexes = new int[numsofdays];
    for (int i = 0; i < numsofdays; i++) {
      indexes[i] = (int) (Math.random() * lengthComments);
    }
    for (int i = 1; i <= numsofdays; i++) {
      int rand = (int) (Math.random() * 5);
      if (rand == 0) {
        System.out.println();
        System.out.println("In Day " + i + ", you've practiced singing for " + getSing() + " hours and your main thought of the day is: \""
            + getComments().get(indexes[i - 1]) + "\"");
      } else if (rand == 1) {
        System.out.println();
        System.out.println("In Day " + i + ", you've practiced writing for " + getWrite()
            + " hours and your main thought of the day is: \"" + getComments().get(indexes[i - 1]) + "\"");
      } else if (rand == 2){
        System.out.println();
        System.out.println("In Day " + i + ", you've practiced performing for " + getBeat()
            + " hours and main thought of the day is: \"" + getComments().get(indexes[i - 1]) + "\"");
      } else if (rand == 3){
        System.out.println();
        System.out.println("In Day " + i + ", you've worked out for " + stamina
            + " hours and main thought of the day is: \"" + getComments().get(indexes[i - 1]) + "\"");
      } else{
        System.out.println();
        System.out.println("In Day " + i + ", you've worked on your self-promotion for " + selfpromotion
            + " hours and main thought of the day is: \"" + getComments().get(indexes[i - 1]) + "\"");
      }
    }
  }
  
  // Recursive fuction for String reverse
 public static String reverseString(String str)
    {
        if (str.isEmpty())
            return str;
        //Calling Function Recursively
        return reverseString(str.substring(1)) + str.charAt(0);
    }
  public static boolean isPalindrome(String str)
    {
        // Initializing an empty string to store the reverse
        // of the original str
        String rev = "";
 
        // Initializing a new boolean variable for the
        // answer
        boolean ans = false;
 
        for (int i = str.length() - 1; i >= 0; i--) {
            rev = rev + str.charAt(i);
        }
 
        // Checking if both the strings are equal
        if (str.equals(rev)) {
            ans = true;
        }
        return ans;
    }
}