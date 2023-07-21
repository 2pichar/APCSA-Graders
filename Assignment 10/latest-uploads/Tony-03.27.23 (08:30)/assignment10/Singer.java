package assignment10;

import java.util.ArrayList;

public class Singer {
  private String username;
  private int sing;
  private int write;
  private int beat;
  private ArrayList<String> comments;

  public Singer() {
    this("username", 0, 0, 0);
  }

  public Singer(String name, int s, int w, int b) {
    this.username = name;
    this.sing = s;
    this.write = w;
    this.beat = b;
    comments = new ArrayList<String>();
    comments.add("Oh my gosh, it's so exhausting");
    comments.add("it's so much fun sometimes, but again, it's not");
    comments.add("I'm so thirsty");
    comments.add("When we go to sleep, when do we go?");
    comments.add("We've just started guys!");
    comments.add("Let's go, we have a lot to do!");
    comments.add("Next time you see a brother down. Stop and pick him up, Cause you might be the next one stuck");
    comments.add("Never become so involved with something that it blinds you. Never forget where you from; someone will remind you.");
    comments.add("Life without dreaming is a life without meaning.");
    comments.add("Call me big Daddy if you can");  
    comments.add("Now I gotta ball without you (21, 21, 21)");
    comments.add("I love you and I let you go");
    comments.add("We fell apart as it gets dark");
    comments.add("Someone took a big L, don't know how that felt");
    comments.add("You're the sunflower");
    comments.add("To you, I'll give the world. To me, will you?");
    comments.add("I can't tell where the journey will end. But I know where to start");
    comments.add("Having conversation about my haste decision. At the same time, my memory surfaced through the grapevine");
    comments.add("I don't feel the same. I'm so numb");
    comments.add("I'm in ha mood");    
    comments.add("I need a good girl, I need someone to share this heart to me");
    comments.add("Fall in love with you, you. My love...");
    comments.add("Tell 'em that I know money, I need some more up front");
    comments.add("I never sleep, cause sleep is the cousin of death");
    comments.add("We all got dreams and we all-star reaching");
    comments.add("Look around, the realities carved in the lies. Wipe my ego, dodge my pride (and I'm trippin' and fallin')");
    comments.add("Fun part has just begun!");
    comments.add("Don't be so sad. It's a total waste of time");
    comments.add("Love seeketh not itself to please, nor for itself hath any care, but for another gives its ease, and builds a Heaven in Hell's despair.");
    comments.add("Oh, and babe I'm fist fighting with fire. Just to get close to you");
    comments.add("Yes, you're lovely, with your smile so warm");
    comments.add("Another day, another night. I long to hold you tight");
    comments.add("Girl, I never loved one like you");
    comments.add("Well, I found a girl, beautiful and sweet. Oh, I never knew you were the someone waiting for me");
    comments.add(" I'll be at your side, forever more");
    comments.add("Give me respect, dammit, or get damaged");
    comments.add("I’m doing pretty good as far as geniuses go.");
    comments.add("I’m just a soul whose intentions are good. Oh, Lord please don’t let me be misunderstood.");
    comments.add("Feeling good living better");
    comments.add("We ain’t picture perfect but we worth the picture still");
    comments.add("The truth hurts but secrets kill");
  }

  public void work() {
    int numsofdays = 7;
    int[] indexes = new int[numsofdays];
    for (int i = 0; i < numsofdays; i++) {
      indexes[i] = (int) (Math.random() * comments.size());
    }
    for (int i = 1; i <= numsofdays; i++) {
      int rand = (int) (Math.random() * 3);
      if (rand == 0) {
        System.out.println();
        System.out.println("In Day " + i + ", you've practiced singing for " + sing + " hours and your main thought of the day is: \""
            + comments.get(indexes[i - 1]) + "\"");
      } else if (rand == 1) {
        System.out.println();
        System.out.println("In Day " + i + ", you've practiced writing for " + write
            + " hours and your main thought of the day is: \"" + comments.get(indexes[i - 1]) + "\"");
      } else {
        System.out.println();
        System.out.println("In Day " + i + ", you've practiced performing for " + beat
            + " hours and main thought of the day is: \"" + comments.get(indexes[i - 1]) + "\"");
      }
    }
  }
  public String getUsername(){
    return username;
  }
  public int getSing(){
    return sing;
  }
  public int getWrite(){
    return write;
  }
  public int getBeat(){
    return beat;
  }
  public ArrayList<String> getComments(){
    return comments;
  }
  public int getCommentslength(){
    return comments.size();
  }
}
