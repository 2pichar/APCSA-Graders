package assignment10;

public class BoardMember extends Employee{
    private String position;
    private int bonus;
    private String back;
    private String impofstatus;
    public BoardMember(){
        super();
        position = "CEO";
    }
    public BoardMember(String n, int a, int p, String pos){
        super(n, a, p);
        position = pos;
    }
    public void addReturn(String b){
        back = b;
    }
    public void addStatus(String st, String imp){
        status = st;
        impofstatus = imp;
    }
    public void addBonuses(int bns){
        bonus = bns;
    }
    public String toString(){
        return super.toString() + " - Importance of Status: " + impofstatus + "/10 - Position: " + position + " - Time until return: " + back + " - Bonus: " + bonus;
  }
}