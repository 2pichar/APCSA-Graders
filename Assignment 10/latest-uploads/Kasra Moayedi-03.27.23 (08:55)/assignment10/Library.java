package assignment10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;
import java.io.PrintStream;
import java.io.FileWriter;
import java.io.IOException;
public class Library{
    public static void main(String[]args){
        Scanner i=new Scanner(System.in);
        PrintStream o=System.out;
        Book[]row=new Book[10];
        ArrayList<Book>toRead=new ArrayList<>();
        Book[][]shelf=new Book[5][10];
        String n="";
        String a="";
        String s="";
        short y=(short)0;
        short p=(short)0;
        byte c=(byte)10;
        int rowIndex=0;
        int shelfRowIndex=0;
        int shelfColumnIndex=0;
        int toRemoveOrSee=0;
        int toRemoveOrSeeColumn=0;
        int sortingIndex;
        int lowerIndex;
        int upperIndex;
        int mid;
        String searchTitleOrAuthor;
        ArrayList<String>titlesOrAuthors=new ArrayList<>();
        short searchYearOrPgCount;
        ArrayList<Short>yearsOrPgc=new ArrayList<>();
        String sortedBy="title";
        int foundIndex=-1;
        Book temp;
        boolean isTextbook;
        boolean isDefault;
        boolean arrayListSorted=false;
        o.println("Enter a command. (info/toread/row/shelf/add/read/sort/search/close)");
        try{
        while(i.hasNextLine()){
            switch(i.nextLine().toLowerCase()){
                case"info":
                o.println("Which list? (toread/row/shelf)");
                switch(i.nextLine().toLowerCase()){
                    case"toread":
                        o.println("Which item? (0-"+(toRead.size()-1)+")");
                        toRemoveOrSee=i.nextInt();
                        i.nextLine();
                        if(toRemoveOrSee>=0&&toRemoveOrSee<=toRead.size())o.print(toRead.get(toRemoveOrSee));
                        else o.println("Invalid number. Aborting");
                        break;
                    case"row":
                        o.println("Which item? (0-9)");
                        toRemoveOrSee=i.nextInt();
                        i.nextLine();
                        if(toRemoveOrSee>=0&&toRemoveOrSee<=9)o.print(row[toRemoveOrSee]);
                        else o.println("Invalid number. Aborting");
                        break;
                    case"shelf":
                        o.println("Which row? (0-4)");
                        toRemoveOrSee=i.nextInt();
                        o.println("Which column? (0-9)");
                        toRemoveOrSeeColumn=i.nextInt();
                        i.nextLine();
                        if(toRemoveOrSee>=0&&toRemoveOrSee<5&&toRemoveOrSeeColumn>=0&&toRemoveOrSeeColumn<=9)
                            o.println(shelf[toRemoveOrSee][toRemoveOrSeeColumn]);
                        break;
                    default:
                        o.println("Invalid command");
                        break;
                }break;
                case"toread":
                    for(int j=0;j<toRead.size();j++)
                        o.println(toRead.get(j)+"\n");
                    break;
                case"row":
                    for(Book b:row)
                        o.println(b+"\n");
                    break;
                case"shelf":
                    for(Book[]B:shelf)
                        for(Book b:B)
                            o.println(b+"\n");
                    break;
                case"add":
                    o.println("Default constructor? (true/false)");
                    isDefault=i.nextBoolean();
                    o.println("Should it be a textbook? (true/false)");
                    isTextbook=i.nextBoolean();
                    i.nextLine();
                    if(!isDefault){
                    o.println("What should the title be?");
                    n=i.nextLine();
                    o.println("What about the author?");
                    a=i.nextLine();
                    o.println("The published year?");
                    y=i.nextShort();
                    o.println("The number of pages?");
                    p=i.nextShort();
                    i.nextLine();
                    if(isTextbook){
                        o.println("The subject?");
                        s=i.nextLine();
                        o.println("The number of sections?");
                        c=i.nextByte();
                        i.nextLine();
                    }}
                    o.println("Where should this be added? (TOREAD/row/shelf)");
                    switch(i.nextLine().toLowerCase()){
                        case"toread":
                            if(isTextbook)toRead.add(isDefault?new Textbook():new Textbook(n,a,y,p,s,c));
                            else toRead.add(isDefault?new Book():new Book(n,a,y,p));
                            arrayListSorted=false;
                            break;
                        case"row":
                            if(rowIndex==9){
                                o.println("Row filled! Clear up book? (true/false)");
                                if(i.nextBoolean()){
                                    o.println("Choose a book to delete");
                                    for(Book b:row)o.println(b+"\n");
                                    if(toRemoveOrSee>=0&&toRemoveOrSee<=9)row[toRemoveOrSee]=null;
                                    else o.println("Invalid number. Aborting");
                                }
                            }else{
                                if(isTextbook)row[rowIndex]=isDefault?new Textbook():new Textbook(n,a,y,p,s,c);
                                else row[rowIndex]=isDefault?new Book():new Book(n,a,y,p);
                                rowIndex++;
                            }break;
                        case"shelf":
                            if(shelfColumnIndex==10){
                                if(shelfRowIndex<4){
                                    shelfRowIndex++;
                                    shelfColumnIndex=0;
                                }else if(shelfRowIndex==4){
                                    o.println("Shelf filled! Clear up book?");
                                    if(i.nextBoolean()){
                                        o.println("Choose a book to delete");
                                        for(Book[]b:shelf)for(Book B:b)o.println(B);
                                        toRemoveOrSee=i.nextInt();
                                        toRemoveOrSeeColumn=i.nextInt();
                                        if(toRemoveOrSee>=0&&toRemoveOrSee<5&&toRemoveOrSeeColumn>=0&&toRemoveOrSeeColumn<=9)
                                            shelf[toRemoveOrSee][toRemoveOrSeeColumn]=null;
                                        else o.println("Invalid number. Aborting");
                                }
                                }
                            }else{
                                if(isTextbook)shelf[shelfRowIndex][shelfColumnIndex]=isDefault?new Textbook():new Textbook(n,a,y,p,s,c);
                                else shelf[shelfRowIndex][shelfColumnIndex]=isDefault?new Book():new Book(n,a,y,p);
                                shelfColumnIndex++;
                            }break;
                        default:
                            o.println("Adding to toRead");
                            if(isTextbook)toRead.add(isDefault?new Textbook():new Textbook(n,a,y,p,s,c));
                            else toRead.add(isDefault?new Book():new Book(n,a,y,p));
                            arrayListSorted=false;
                    }break;
                case"read":
                o.println("Which list? (toread/row/shelf)");
                switch(i.nextLine().toLowerCase()){
                    case"toread":
                        o.println("Which item? (0-"+toRead.size()+")");
                        toRemoveOrSee=i.nextInt();
                        i.nextLine();
                        if(toRemoveOrSee>=0&&toRemoveOrSee<=toRead.size())toRead.get(toRemoveOrSee).readBook();
                        else o.println("Invalid number. Aborting");
                        break;
                    case"row":
                        o.println("Which item? (0-9)");
                        toRemoveOrSee=i.nextInt();
                        i.nextLine();
                        if(toRemoveOrSee>=0&&toRemoveOrSee<=9)row[toRemoveOrSee].readBook();
                        else o.println("Invalid number. Aborting");
                        break;
                    case"shelf":
                        o.println("Which row? (0-4)");
                        toRemoveOrSee=i.nextInt();
                        o.println("Which column? (0-9)");
                        toRemoveOrSeeColumn=i.nextInt();
                        i.nextLine();
                        if(toRemoveOrSee>=0&&toRemoveOrSee<5&&toRemoveOrSeeColumn>=0&&toRemoveOrSeeColumn<=9)
                            shelf[toRemoveOrSee][toRemoveOrSeeColumn].readBook();
                        break;
                    default:
                        o.println("Invalid command");
                        break;
                }break;
                case"sort":
                    if(toRead.size()<2){
                        o.println("Needs more than 1 item in order to be sorted");
                        break;}
                    o.println("How should this list be sorted? (TITLE/author/year/pagecount)");
                    sortedBy=i.nextLine().toLowerCase();
                    switch(sortedBy){
                    case"title":
                        for(int j=0;j<toRead.size()-1;j++){
                            sortingIndex=j;
                            for(int k=j+1;k<toRead.size();k++)
                                if(toRead.get(k).getTitle().compareToIgnoreCase(toRead.get(sortingIndex).getTitle())<0)
                                    sortingIndex=k;
                            Collections.swap(toRead,sortingIndex,j);
                        }break;
                    case"author":
                        for(int j=0;j<toRead.size()-1;j++){
                            sortingIndex=j;
                            for(int k=j+1;k<toRead.size();k++)
                                if(toRead.get(k).getAuthor().compareToIgnoreCase(toRead.get(sortingIndex).getAuthor())<0)
                                    sortingIndex=k;
                            Collections.swap(toRead,sortingIndex,j);
                        }break;
                    case"year":
                        for(int j=1;j<toRead.size();j++){
                            temp=toRead.get(j);
                            sortingIndex=j;
                            while(sortingIndex>0&&temp.getYear()<toRead.get(sortingIndex-1).getYear()){
                                toRead.set(sortingIndex,toRead.get(sortingIndex-1));
                                sortingIndex--;
                            }
                            toRead.set(sortingIndex,temp);
                        }break;
                    case"pagecount":
                    for(int j=1;j<toRead.size();j++){
                        temp=toRead.get(j);
                        sortingIndex=j;
                        while(sortingIndex>0&&temp.getPgCount()<toRead.get(sortingIndex-1).getPgCount()){
                            toRead.set(sortingIndex,toRead.get(sortingIndex-1));
                            sortingIndex--;
                        }
                        toRead.set(sortingIndex,temp);
                    }break;
                    default:
                        o.println("Sorting by title...");
                        sortedBy="title";
                        for(int j=0;j<toRead.size()-1;j++){
                            sortingIndex=j;
                            for(int k=j+1;k<toRead.size();k++)
                                if(toRead.get(k).getTitle().compareToIgnoreCase(toRead.get(sortingIndex).getTitle())<0)
                                    sortingIndex=k;
                            Collections.swap(toRead,sortingIndex,j);
                        }break;
                }
                    arrayListSorted=true;
                    o.println("List sorted!");
                    break;
                case"search":
                    if(!arrayListSorted){
                        o.println("Cannot search if not sorted");
                        break;}
                    o.println("toRead is sorted by "+sortedBy);
                    foundIndex=-1;
                    switch(sortedBy){
                        case"title":
                            for(Book b:toRead)titlesOrAuthors.add(b.getTitle().toLowerCase());
                            o.println("What title are you looking for?");
                            searchTitleOrAuthor=i.nextLine().toLowerCase();
                            foundIndex=search(titlesOrAuthors,searchTitleOrAuthor,0,titlesOrAuthors.size()-1);
                            if(foundIndex==-1)o.println("Could not find a book with that title");
                            else o.println("That book is at index "+foundIndex+" in toRead");
                            titlesOrAuthors.clear();
                            break;    
                        case"author":
                            o.println("What author are you looking for?");
                            searchTitleOrAuthor=i.nextLine().toLowerCase();
                            for(Book b:toRead)titlesOrAuthors.add(b.getAuthor().toLowerCase());
                            foundIndex=search(titlesOrAuthors,searchTitleOrAuthor,0,titlesOrAuthors.size()-1);
                            if(foundIndex==-1)o.println("Could not find a book by that author");
                            else o.println("That author's book is at index "+foundIndex+" in toRead");
                            titlesOrAuthors.clear();
                            break;
                        case"year":
                            o.println("What year are you looking for?");
                            searchYearOrPgCount=i.nextShort();
                            i.nextLine();
                            for(Book b:toRead)yearsOrPgc.add(b.getYear());
                            foundIndex=search(yearsOrPgc,searchYearOrPgCount,0,yearsOrPgc.size()-1);
                            if(foundIndex==-1)o.println("Could not find a book with that year");
                            else o.println("The book with that year is at index "+foundIndex+" in toRead");
                            yearsOrPgc.clear();
                            break;
                        case"pagecount":
                            o.println("What page count are you looking for?");
                            searchYearOrPgCount=i.nextShort();
                            i.nextLine();
                            for(Book b:toRead)yearsOrPgc.add(b.getPgCount());
                            foundIndex=search(yearsOrPgc,searchYearOrPgCount,0,yearsOrPgc.size()-1);
                            if(foundIndex==-1)o.println("Could not find a book with that page count");
                            else o.println("The book with that many pages is at index "+foundIndex+" in toRead");
                            yearsOrPgc.clear();
                            break;
                        default:
                            o.println("Searching by title");
                            o.println("What title are you looking for?");
                            searchTitleOrAuthor=i.nextLine();
                            lowerIndex=0;
                            upperIndex=toRead.size()-1;
                            while(lowerIndex<upperIndex){
                                mid=(lowerIndex+upperIndex)/2;
                                if(searchTitleOrAuthor.equals(toRead.get(mid).getTitle())){
                                    foundIndex=mid;
                                    break;
                                }else if(searchTitleOrAuthor.compareTo(toRead.get(mid).getTitle())>0)
                                    lowerIndex=mid+1;
                                else upperIndex=mid-1;
                            }
                            if(foundIndex==-1)o.println("Could not find a book with that title");
                            else o.println("That book is at index "+foundIndex+"in toRead");
                            break;
                    }
                    break;
                case"close":
                    i.close();
                    break;
                default:
                    o.println("Invalid command");
                    break;
            }
            o.println("Enter a command. (info/toread/row/shelf/add/read/sort/search/close)");
        }
    }catch(IllegalStateException e){
        try (FileWriter toReadWriter=new FileWriter("toRead.txt");
             FileWriter rowWriter=new FileWriter("row.txt");
             FileWriter shelfWriter=new FileWriter("shelf.txt")){
            for(int j=0;j<toRead.size();j++)toReadWriter.write(toRead.get(j)+"\n\n");
            for(Book b:row)if(b!=null)rowWriter.write(b+"\n\n");
            for(Book[]b:shelf){
                for(Book B:b)
                    if(B!=null)shelfWriter.write(B+"\n\n");
                shelfWriter.write("\n");}
        o.println("Contents written to files!");
        }catch(IOException e1){e1.printStackTrace();}
    }
    }
    public static int search(ArrayList<String>a,String v,int l,int h) {
        if(l>h)return-1;
        int m=(l+h)/2;
        String e=a.get(m);
        if(e.equals(v))return m;
        else if(e.compareTo(v)>0)return search(a,v,l,m-1);
        else return search(a,v,m+1,h);
    }
    public static int search(ArrayList<Short>a,short v,int l,int h) {
        if(l>h)return-1;
        int m=(l+h)/2;
        short e=a.get(m);
        if(e==v)return m;
        else if(v<e)return search(a,v,l,m-1);
        else return search(a,v,m+1,h);
    }
}