package assignment10;

public class Textbook extends Book{
    private String subject;
    private byte sectionCount;
    private byte sectionLength;

    public String getSubject(){return subject;}
    public byte getSectionCount(){return sectionCount;}
    public byte getSectionLength(){return sectionLength;}

    public void setSubject(String s){subject=s;}
    public void setSectionCount(byte c){sectionCount=c;}
    public void setSectionLength(byte l){sectionLength=l;}

    public Textbook(String n,String a,short y,short p,String s,byte c){
        super(n,a,y,p);
        subject=s;
        sectionCount=c;
        sectionLength=(byte)(super.getPgCount()/sectionCount);}

    public Textbook(){
        super();
        subject="Unknown";
        sectionCount=(byte)10;
        sectionLength=(byte)20;}

    public void readBeginning(){
        readPage((short)1,sectionLength);
    }

    public void readSection(byte sectionNumber){
        if(sectionNumber==sectionCount)sectionNumber--;
        else if (sectionNumber>sectionCount)sectionNumber=1;
        readPage((short)(sectionNumber*sectionLength),(short)(sectionNumber*sectionLength+sectionLength));
    }

    @Override
    public String toString(){return super.toString()+"\nSubject: "+subject+"\nSection Count: "+sectionCount+"\nSection Length: "+sectionLength;}
}