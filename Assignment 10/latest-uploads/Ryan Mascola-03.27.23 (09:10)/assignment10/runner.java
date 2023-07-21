package assignment10;

import java.util.Scanner;
import java.util.*;
public class runner {
    static String genus;
    static String binomial;
    static String genusPrint;
    static String species;
    static int choice1; // what they want to do with the plant found in database
    static String uname;
    static int utmn;
    static int utme;
    static int lev;
    static int plantindex;
    static boolean exitcode = false;

    public static void main(String[] args) throws InterruptedException {
        Scanner scan = new Scanner(System.in);
        System.out.println("Welcome to 🌱𝙸𝙽𝚅𝙰𝚂𝙸𝚅𝙴 𝙿𝙻𝙰𝙽𝚃 𝙵𝙸𝙽𝙳𝙴𝚁🌿 v1.0");
        Thread.sleep(300);
        System.out.println("░▀█▀░█▀█░█░█░█▀█░█▀▀░▀█▀░█░█░█▀▀░░░█▀█░█░░░█▀█░█▀█░▀█▀░░░█▀▄░█▀▀░█▀█░█▀█░█▀▄░▀█▀░█▀▀░█▀▄");
        Thread.sleep(300);
        System.out.println("░░█░░█░█░▀▄▀░█▀█░▀▀█░░█░░▀▄▀░█▀▀░░░█▀▀░█░░░█▀█░█░█░░█░░░░█▀▄░█▀▀░█▀▀░█░█░█▀▄░░█░░█▀▀░█▀▄");
        Thread.sleep(300);
        System.out.println("░▀▀▀░▀░▀░░▀░░▀░▀░▀▀▀░▀▀▀░░▀░░▀▀▀░░░▀░░░▀▀▀░▀░▀░▀░▀░░▀░░░░▀░▀░▀▀▀░▀░░░▀▀▀░▀░▀░░▀░░▀▀▀░▀░▀");
        Thread.sleep(500);
        System.out.print("Loading California Plant Database");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.print(".");
        Thread.sleep(500);
        System.out.println(".");
        while (exitcode==false) //Keeps looping until the user chooses to exit
    {
        System.out.println("Ready!  Please enter the genus of the plant to start 🪪"); //or enter "common" to search common names, use 2D array of plant info to match common and sci
        Thread.sleep(500);
        //System.out.println(reportPlant.PlantsInfo(1,100));
        System.out.print("Genus: ");
        genus = scan.nextLine();
        
        genusPrint = reportPlant.searchGenus(genus);
    
        while (genusPrint.length()<1)  // if they enter it wrong, it prompts them to enter again until a match is found
        {   
            System.out.println("\n⚠️  Sorry, we did not find the genus "+  genus  +" in our database.  The plant you listed may not be considered invasive in the California region, or it may be misspelled.  Please enter another genus if you wish to continue");
            System.out.println("\nPlease reenter the genus of the plant:");
            Thread.sleep(500);
            System.out.print("Genus: ");
            genus = scan.nextLine();
            genusPrint = reportPlant.searchGenus(genus);
        }
        if (genusPrint.length()>0)
            {  
                System.out.print("\n🌱 Enter the species from the Latin binomial(s) that match your query:\n");
                System.out.print(reportPlant.searchGenus(genus));
                System.out.print("\n"+genus+ " ");
                species = scan.nextLine();
                binomial = reportPlant.searchBinomial(genus, species);
                
                    while (binomial.length()<1)  // if they enter it wrong, it prompts them to enter the SPECIES again until a match is found
                        {   
                             System.out.println("\n⚠️  Sorry, we did not find the species "+  species  +" in our database.  The plant you listed may not be considered invasive in the California region, or it may be misspelled.  Please enter another species if you wish to continue");
                            System.out.println("\nPlease reenter the species of the plant:");
                            Thread.sleep(500);
                            System.out.print("\n"+genus+ " ");
                            species = scan.nextLine();
                             binomial = reportPlant.searchBinomial(genus, species);
                        }
                    if (binomial.length()>0)
                        {  
                        System.out.println("Database match found for "+binomial+"!");
                        System.out.println("Would you like to (1) report "+binomial+" infestation, (2) check the database for information, or (3) view current reported infestations of "+binomial+"?");
                        System.out.print("Enter selection number: ");
                        choice1 = scan.nextInt();
                        if (choice1 == 1)  //they selected the FIRST option, reporting an infestation
                        {
                            System.out.println("Reporting a new infestation of "+binomial+" in California");
                            System.out.println("What is your name?");
                            uname = scan.nextLine();
                            uname = scan.nextLine();
                            System.out.println("What is your current location using UTM coordinates (WGS-1984 Map Datum)?");
                            System.out.println("UTM Northings:");
                            utmn = scan.nextInt();
                            System.out.println("UTM Eastings:");
                            utme = scan.nextInt();
                            System.out.println("What is the level of infestation from (minimal)1 to 5(worst)?");
                            lev = scan.nextInt();
                            reportPlant plant = new reportPlant(utme, utmn, binomial, uname, lev);
                            String plantreport = plant.toString(); //String of report generated and stored in plantreport
                            System.out.println(plantreport);
                            plant.writeReport(plantreport);
                        }

                        else if (choice1 == 2) //they selected the second option, database info
                        {
                        System.out.println("\n⚠️ This feature is in beta, so information may NOT be accurate⚠️");
                        Thread.sleep(700);
                        System.out.print("\nLoading California Invasive Plant Council Information on "+ binomial);
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        plantindex = reportPlant.searchPlantsInfo(binomial, 1);
                        System.out.println("\nSearching index "+reportPlant.searchPlantsInfo(binomial, 1)+"\n");
                        System.out.println("common name(s) for "+binomial+" are: \n "+reportPlant.PlantsInfo(0,plantindex));
                        System.out.println("Invasive Level: "+reportPlant.PlantsInfo(16,plantindex));
                        System.out.println("\nAdditional Plant Information and Risk Assesment\n");
                        Thread.sleep(700);
                        System.out.print(".");
                        Thread.sleep(700);
                        System.out.print(".");
                        Thread.sleep(700);
                        System.out.print(".");
                        Thread.sleep(1300);
                        System.out.println(reportPlant.PlantsInfo(2,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(3,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(4,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(5,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(6,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(7,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(8,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(9,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(10,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(11,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(12,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(13,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(14,plantindex)+"\n");
                        Thread.sleep(300);
                        System.out.println(reportPlant.PlantsInfo(15,plantindex)+"\n");
                        }
                        else if (choice1 == 3)
                        {
                        reportPlant.writeReport("Level 3 infestation of Oxalis pes-caprae logged at 222313N, 235253E by Ryan");
                            System.out.print("\nAccesing reports for "+binomial);
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.print(".");
                        Thread.sleep(500);
                        System.out.println(".");
                        //reportPlant plant = new reportPlant(utme, utmn, binomial);
                        System.out.print(reportPlant.searchReport(species));
                        //System.out.print()
                        }
                        else 
                        {
                           System.out.println("not a valid input, please type better"); 
                        }


                    }
                
                
            }

        
     
        //needs to check valids
        System.out.println("\nPress M to return to main menu or E to exit");
        String response = scan.nextLine();
        response = scan.nextLine();
        if(response.toLowerCase() == "e")
        exitcode = true;
    }
    
    }

}
