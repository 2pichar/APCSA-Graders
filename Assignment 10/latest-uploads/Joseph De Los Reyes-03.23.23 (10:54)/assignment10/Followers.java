package assignment10;

public class Followers extends Music{
private int followers;
private String certification;



 public Followers()
  {
    super();
    followers =  1000;
  }

  public Followers(String s, String a,int st, int f)
  {

  super(s,a,st);
   followers = f;
  }

  public String getCertification()
  {
      certification = whatCertified();
      return certification;
  }

  public String whatCertified(){
      String s = "";
      if(super.getStreams() >= 500000  && super.getStreams() < 1000000)
      {
          s = "GOLD";
      }
      else if(super.getStreams() >= 1000000 && super.getStreams() < 2000000)
      {
          s= "PLATINUM";
      }
      else if(super.getStreams() >= 2000000 && super.getStreams() < 10000000)
      {
          s = "Multi-Platinum";
      }
      else if(super.getStreams() >= 10000000)
      {
          s= "DIAMOND";
      }
      else
          {
              s = "NONE";
          }
          return s;
}
 public String toString()
 {
     String s = super.toString() + " and it is certified: " + getCertification();
     return s;
 }
}