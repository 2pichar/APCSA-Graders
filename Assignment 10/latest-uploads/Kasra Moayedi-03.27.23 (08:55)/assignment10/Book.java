package assignment10;

public class Book{
    private String title;
    private String author;
    private short year;
    private short pageCount;
    
    public String getTitle(){return title;}
    public String getAuthor(){return author;}
    public short getYear(){return year;}
    public short getPgCount(){return pageCount;}

    public void setTitle(String n){title=n;}
    public void setAuthor(String a){author=a;}
    public void setYear(short y){year=y;}
    public void setPgCount(short p){pageCount=p;}

    public Book(String n,String a,short y,short p){
        title=n;
        author=a;
        year=y;
        pageCount=p;}

    public Book(){this("Unknown","Unknown",(short)1970,(short)200);}

    public void readBook(){readPage((short)1,pageCount);}

    public void readPage(short from,short to){
        System.out.println("Reading page "+from+" of "+pageCount);
        if(from<to)readPage(++from,to);
        else System.out.println("Done reading!");
    }
    public void readBeginning(){
        readPage((short)1,(short)(pageCount/20));
    }
    public String toString(){return"Title: "+title+"\nAuthor: "+author+"\nYear: "+year+"\nNumber of Pages: "+pageCount;}
}