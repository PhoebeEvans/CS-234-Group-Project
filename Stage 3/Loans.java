/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author phoeb
 */
public class Loans {
    private String material;
    private String outDate;
    private String inDate;
    private int materialtype;
    private String materialName;
    private String materialDate;
    private String materialId;
    private int loan = 0;
    
    private String[] arrLine;
    private String[] arrLine2;
    
    private String[] materialArr;
    private String[] mDateArr;
    private String[] materialIdArr;
    private String[] patronArr;
    private String[] dobArr; 
    private String[] patronidArr;
    private String[] indateArr;
    private String[] outdateArr;
    private String[] employeeArr;
    private String[] employeeidArr;
    
    private String employeename = "Bob";
    private String patronname = "";
    private String employeeId = "001";
    private String patronId;
    private String patronDOB;
    private int rnum = 1;
    private String mediaFile = "";
    private String patronFile = "";
    private int loanlength = 14;
    
    public void dates(){
        Age loandate = new Age();
        outDate = loandate.getcurrentDate();
        inDate = loandate.getreturnDate(loanlength);
    }
    
    public int intC(String instruc){
        int response;
        System.out.println(instruc);
        
        //get response from user
        Scanner date = new Scanner(System.in);
        response = date.nextInt();
        
        return response;
    }
    
    public String stringC(String instruc){
        String response;
        System.out.println(instruc);
        
        //get response from user
        Scanner reply = new Scanner(System.in);
        response = reply.nextLine();
        
        //trim whitespace
        //right whitespace trim
        String temp = response.replaceAll("\\s+$", "");
        response = temp;
        return response;
    }
    
    public Loans() throws FileNotFoundException{
        
        int value = 100; 
        
        
        materialArr = new String[value];
        mDateArr = new String[value];
        materialIdArr = new String[value];
        patronArr = new String[value];
        dobArr = new String[value]; 
        patronidArr = new String[value];
        indateArr = new String[value];
        arrLine = new String[10];
        outdateArr = new String[value];
        employeeArr = new String[value];
        employeeidArr = new String[value];
        
        overdue();
    }
    
    //this method uses the Age class to check for overdue loans. 
    public void overdue() throws FileNotFoundException{
        rnum = 0;
        
        File inputFile = new File("Loans.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            indateArr[rnum] = arrLine[6];
            outdateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
        }
        
        int count = 0;
        while(count < rnum){
            String dueDate = indateArr[count];
            Age returns = new Age();
            int due = returns.overDue(dueDate);
            if(due > 0){
                //the material is overdue
                System.out.println(materialArr[count] + " is overdue by " + due + " days.\n");
                
                patronFile = patronArr[count] + dobArr[count] + "Id" + patronidArr[count];
                patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
                patronFile = patronFile + ".txt";
                
                patronname = patronArr[count];
                String patronName = patronname.replaceAll("[^a-z0-9]", "");
                
                mediaFile = materialArr[count] + mDateArr[count] + "Id" + materialIdArr[count];
                mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
                mediaFile = mediaFile + ".txt";
                
                materialName = materialArr[count];
                String materialname = materialName.replaceAll("[^a-z0-9]", "");
                
                outDate = outdateArr[count];
                inDate = indateArr[count];
                
                indateArr[count] = inDate + " overdue/" + due;
                out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                        outdateArr[count] + "~" + indateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                
                //mediaFile update
                File inputMediaFile = new File(mediaFile);
                Scanner inMedia = new Scanner(inputMediaFile);
                PrintWriter outMedia = new PrintWriter("temp.txt");
                while(inMedia.hasNextLine()){
                    String nextline = inMedia.nextLine();
                    arrLine2 = nextline.split("~");
                    String person = arrLine2[2];
                    String [] spliter = person.split("#");
                    String name = spliter[0];
                    name = name.toLowerCase();
                     

                    name = name.replaceAll("[^a-z0-9]", "");
                    
                    
                    if(name == null ? patronName == null : name.equals(patronName)){
                        
                        arrLine2[2] = arrLine2[2] + "#" + "overdue by " + due + " days. ";
                        System.out.println(materialName + " was loaned to " + patronname + " on " + outDate + " it is due " + inDate);
                        loan = 1;
                        

                    }
                    outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                }
                
                inMedia.close();
                outMedia.close();
                Files loans = new Files("temp.txt", mediaFile);
                loans.fileReplace();
                    
                    
                File inputpatronFile = new File(patronFile);
                Scanner inPatron = new Scanner(inputpatronFile);
                PrintWriter outPatron = new PrintWriter("temp.txt");

                while(inPatron.hasNextLine()){
                    String nextline = inPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];
                    
                    String name = title.toLowerCase();
                     
                    name = name.replaceAll("[^a-z0-9]", "");
                    
                    
                    if(name == null ? materialname == null : name.equals(materialname)){
                        
                        arrLine2[5] = arrLine[5] + "#" + "overdue by " + due + " days. ";
                        
                        loan = 1;
                        

                    }
                    //outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                    outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
                }
                
                inPatron.close();
                outPatron.close();
                Files patrons = new Files("temp.txt",patronFile);
                patrons.fileReplace();    
                }
                else{
                    out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                }
                count++;    
            }
        
        in.close();
        out.close();
        Files loans = new Files("temp.txt", "Loans.txt");
        loans.fileReplace();
        
    }
    
    //searches for patron using Patrons class search method
    public void findPatron() throws FileNotFoundException{
        
        System.out.println("You are picking a patron to loan the material. ");
        //find patron
        Patrons loansP = new Patrons();
        loansP.searchPatrons();
        
        int pick = intC("Please type number of the name of the patron. \n");
       
       File inputFile1 = new File("loansP.txt");
       Scanner inP = new Scanner(inputFile1);

       while(inP.hasNextLine()&&inP.hasNextInt()){
           String next = inP.nextLine();
           //System.out.println("x " + x);
           
           arrLine = next.split("_");
           String patronNum = arrLine[0];
           
            String temp = patronNum.replaceAll("[^0-9]", "");
            patronNum = temp;
            int pNum = Integer.parseInt(patronNum);
            
            
           if(pick == pNum){
               //find file name 
                patronFile = arrLine[1] + arrLine[4] + "Id" + arrLine[7]; 
                String rePlace = patronFile.replaceAll("[^a-zA-Z0-9]", "");
                patronFile = rePlace;
                String temp1 = patronFile +".txt";
                patronFile = temp1; 
                patronname = arrLine[1];
                patronId = arrLine[7];
                patronDOB = arrLine[4];
                
                //patronemail = arrLine[?]
                //System.out.println(patronname);
                //System.out.println(patronFile);
               break;
           }

       }

       inP.close();
    }
    
    //searches for material using Material class search method
    public void findMaterial() throws FileNotFoundException{
        //find material
       materialtype = intC("If you are borrowing a book type 1. \nIf you are borrowing a movie type 2. \n");
       
       if(materialtype == 1){
           //books
           Books loansM = new Books();
           loansM.searchMaterials();
           materialName = "Book";
           loanlength = 14;
           dates();
       }
       
       else if(materialtype == 2){
           //movies
           Movies loansM = new Movies(); 
           loansM.searchMaterials();
           materialName = "Movie";
           loanlength = 3;
           dates();
       }
       
       int pick = intC("Please type the number of the item you would like to borrow. \n");
       
       File inputFile = new File("loansM.txt");
       Scanner in = new Scanner(inputFile);

       while(in.hasNextLine()){
           String x = in.nextLine();
           arrLine = x.split("~");
           String value = arrLine[0];
           value = value.replaceAll("[^0-9]", "");
           int val = Integer.parseInt(value);
           if(pick == val){
               //out.printf("");
               material = x;
               break;
           }

       }

       in.close();
       
       
        arrLine = material.split("~");
        
        //System.out.println(arrLine);

        //find file name 
        mediaFile = arrLine[1] + arrLine[3] + "Id" + arrLine[6]; 
        String rePlace2 = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = rePlace2;
        String temp3 = mediaFile +".txt";
        mediaFile = temp3;
        materialName = arrLine[1];
        materialDate = arrLine[3];
        materialId = arrLine[6];
        
    }
    
    public void addLoans() throws FileNotFoundException{

       findPatron();
        
       findMaterial();
       
       employeename = stringC("What is the name of the Employee? ");
       employeeId = stringC("What is the Id number of the Employee? ");
       
        //print info to mediaFile
        File inputMediaFile = new File(mediaFile);
        Scanner inMedia = new Scanner(inputMediaFile);
        PrintWriter outMedia = new PrintWriter("temp.txt");
        
        //loan is 0 because media has not been loaned
        loan = 0;
        
        //while the mediaFile has a next Line
        while(inMedia.hasNextLine()){
            
            //next line = next line in mediaFile
            String nextline = inMedia.nextLine();
            
            //splits nextline into an array
            arrLine2 = nextline.split("~");
            
            //the avalibility part is arrLine2[1]
            String avalibility = arrLine2[1];
            
            //non letters and spaces remove
            avalibility = avalibility.replaceAll("[^0-9]", "");
           
            //converts to an Integer
            int aval = Integer.parseInt(avalibility);
            
            //if the material has not been loaned yet.
            if(loan == 0){
                //if the copy is avalible
                if(aval == 0){
                    //updates info
                    arrLine2[2] = " " + patronname + " # " + patronDOB + " # " + patronId+ " # " + outDate+ " # " + inDate;
                    arrLine2[1] = "1";
                    
                    //prints loan
                    System.out.println(materialName + " was loaned to " + patronname + " on " + outDate + " it is due " + inDate);
                    
                    //changes loan status so that all copies are not loaned. 
                    loan = 1;
                }
                
            }
            
            //line is printed
            outMedia.println(arrLine2[0] + "~" + arrLine2[1] + " ~" + arrLine2[2]);
        }
        
        //if after all copies have been checked there are no avalible copies
        if(loan == 0){
            //print sorry
            System.out.println("Sorry, no copies of " + materialName + " were avalible.\n");
        }
        //close files
        inMedia.close();
        outMedia.close();
        
        //replace files
        Files media = new Files("temp.txt",mediaFile);
        media.fileReplace();
        
        //writing patron file only if the material has been loaned
        if(loan != 0){
            File inputpatronFile = new File(patronFile);
            Scanner inPatron = new Scanner(inputpatronFile);
            PrintWriter outPatron = new PrintWriter("temp.txt");

            while(inPatron.hasNextLine()){
                outPatron.println(inPatron.nextLine());
            }
            outPatron.println("Checkout date ~ " + outDate + " ~ Material name ~ " + materialName + " ~ dueDate ~ " + inDate);

            inPatron.close();
            outPatron.close();
            Files patrons = new Files("temp.txt",patronFile);
            patrons.fileReplace();
        }
        
        
        //print info to Loans.txt
        File inputL = new File("Loans.txt");
        Scanner inL = new Scanner(inputL);
        PrintWriter outL = new PrintWriter("temp.txt");
        
        while(inL.hasNextLine()){
            outL.println(inL.nextLine());
        }
        outL.println(materialName + " ~ " + materialDate + " ~ " + materialId + " ~ " + patronname + " ~ " + patronDOB + " ~ " + patronId + " ~ " + outDate + " ~ " + inDate + " ~ " + employeename + " ~ " + employeeId);
        
        inL.close();
        outL.close();
        Files loans = new Files("temp.txt","Loans.txt");
        loans.fileReplace();
        
    }
    
    public void removeLoans() throws FileNotFoundException{
        
        File viewFile = new File("Loans.txt");
        Scanner inV = new Scanner(viewFile);
        int count = 1;
        while(inV.hasNextLine()){
                
                System.out.println(count + " " + inV.nextLine());
                count++;
        }
        inV.close();
        
        int response = intC("Please type the number of the loan you wish to remove: \n");
        response = response -1;
        
        count = count-1;
        File view = new File("Loans.txt");
        Scanner in = new Scanner(view);
        PrintWriter out = new PrintWriter("temp.txt");
        int iterator = 0;
        //read the input and write the output
        while(in.hasNextLine() && iterator < (count)){
            String lineChange = in.nextLine();
            if(iterator == response){
                
                System.out.println(lineChange+" is being removed. \n");
                
            
                //arrLine is an array of lineChange split at ~
                arrLine = lineChange.split("~");
                
                
                materialName = arrLine[0];
                materialDate = arrLine[1];
                materialId = arrLine[2];
                patronname = arrLine[3];
                patronDOB = arrLine[4];
                patronId = arrLine[5];
                inDate = arrLine[6];
                outDate = arrLine[7];
                employeename = arrLine[8];
                employeeId = arrLine[9];
                
                //patronFile is deduced
                patronFile = patronname + patronDOB + "Id" + patronId;
                patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
                patronFile = patronFile + ".txt";
                
                //patronName for search purposes is made
                String patronName = patronname.replaceAll("[^a-z0-9]", "");
                
                //mediaFile is deduced
                mediaFile = materialName + materialDate + "Id" + materialId;
                mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
                mediaFile = mediaFile + ".txt";
                
                //materialname for search purposes is made
                String materialname = materialName.replaceAll("[^a-z0-9]", "");
                
                
                //mediaFile update
                File inputMediaFile = new File(mediaFile);
                Scanner inMedia = new Scanner(inputMediaFile);
                PrintWriter outMedia = new PrintWriter("temp.txt");
                while(inMedia.hasNextLine()){
                    String nextline = inMedia.nextLine();
                    arrLine2 = nextline.split("~");
                    String person = arrLine2[2];
                    String [] spliter = person.split("#");
                    String name = spliter[0];
                    name = name.toLowerCase();
                     

                    name = name.replaceAll("[^a-z0-9]", "");
                    
                    
                    if(name == null ? patronName == null : name.equals(patronName)){
                        
                    }
                    else{
                        outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                    }
                }
                
                //files closed and replaced
                inMedia.close();
                outMedia.close();
                Files loans = new Files("temp.txt", mediaFile);
                loans.fileReplace();
                    
                //patronFile is opened    
                File inputpatronFile = new File(patronFile);
                Scanner inPatron = new Scanner(inputpatronFile);
                PrintWriter outPatron = new PrintWriter("temp.txt");

                while(inPatron.hasNextLine()){
                    String nextline = inPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];
                    
                    String name = title.toLowerCase();
                     
                    name = name.replaceAll("[^a-z0-9]", "");
                    
                    
                    if(name == null ? materialname == null : name.equals(materialname)){
                       
                    }
                    //outMedia.println(arrLine2[0] + " ~ " + arrLine2[1] + "~" + arrLine2[2]);
                    else{
                        outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
                    }
                }
                
                inPatron.close();
                outPatron.close();
                Files patron = new Files("temp.txt",patronFile);
                patron.fileReplace();    
            }
            
            else{
                out.println(lineChange);
            }
            iterator++;
        }
            
    in.close();
    out.close();

    Files replace = new Files( "temp.txt" , "Loans.txt");
    replace.fileReplace();
    }
        
    public void editLoans() throws FileNotFoundException{
        //patronname and materialName are initialized
        patronname = "";
        materialName = "";
        
        //Loans.txt is opened
        File viewFile = new File("Loans.txt");
        Scanner in = new Scanner(viewFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        int count = 1;
        rnum = 0;
        
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            System.out.println(count + " " + lineChange);
            count++;
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            outdateArr[rnum] = arrLine[6];
            indateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
        }
        
        count = 0;
        
        int response = intC("Please type the number of the loan you want to edit. \n");
        response = response-1;
        System.out.println("You are editing: " + materialArr[response] + "~" + mDateArr[response] + "~" + materialIdArr[response] + "~" + patronArr[response] + "~" + dobArr[response] + "~" + patronidArr[response] + "~" + 
                        outdateArr[response] + "~" + indateArr[response] + "~" + employeeArr[response] + "~" + employeeidArr[response]);
        
        String oldpatronFile = patronArr[response] + dobArr[response] + "Id" + patronidArr[response];
        oldpatronFile = oldpatronFile.replaceAll("[^a-zA-Z0-9]", "");
        oldpatronFile = oldpatronFile + ".txt"; 
        
        String oldmediaFile = materialArr[response] + mDateArr[response] + "Id" + materialIdArr[response];
        oldmediaFile = oldmediaFile.replaceAll("[^a-zA-Z0-9]", "");
        oldmediaFile = oldmediaFile + ".txt";
        
        System.out.println("Please type 1 to edit the patron. ");
        System.out.println("Please type 2 to edit the material. ");
        System.out.println("Please type 3 to edit the due date. ");
        System.out.println("Please type 4 to return the material. ");
        System.out.println("Please type 0 to quit. \n");
        
        //records response
        int pick = intC("");
        
        
        int cont = 0;
        while(cont == 0){
            //switch to pick users choice
            switch (pick) {

                case 1:
                    System.out.println("You are editing the patron. \n");
                    findPatron();

                    patronArr[response] = " " + patronname + " ";
                    dobArr[response] = " " + patronDOB + " ";
                    patronidArr[response] = " " + patronId + " ";
                    cont = 2;
                                                                          
                    break;


                case 2:
                    System.out.println("You are editing the material. \n");
                    findMaterial();

                    materialArr[response] = " " + materialName + " ";
                    mDateArr[response] = " " + materialDate + " ";
                    materialIdArr[response] = " " + materialId + " ";
                    cont = 2;
                    break;


                case 3:
                    //due date
                    System.out.println("You are editing the due date. ");
                    inDate = stringC("Please type the due date in MM/DD/YYYY format. \n");
                    indateArr[response] = " " + inDate + " ";
                    
                    cont = 2;
                    break;

                case 4:
                    System.out.println("You are returning the material. \n");
                    dates();
                    indateArr[response] = "returned " + outDate + " ";
                    
                    cont = 2;
                    break;

                case 0: 
                    System.out.println("You are exiting the loans editing menu. \n");
                    cont = 3;
                    break;
                //if invalid option is picked print that
                default:
                    System.out.println("You selected " + pick);
                    System.out.println("Invalid option - Please try again \n");
                    break;       
            }
        }
        
        //patronFile name is deduced 
        patronFile = patronArr[response] + dobArr[response] + "Id" + patronidArr[response];
        patronFile = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = patronFile + ".txt";
        
        //patronName for searching is made
        String patronName = patronArr[response].toLowerCase();
        patronName = patronName.replaceAll("[^a-z]", "");
        
        //mediaFile name is deduced
        mediaFile = materialArr[response] + mDateArr[response] + "Id" + materialIdArr[response];
        mediaFile = mediaFile.replaceAll("[^a-zA-Z0-9]", "");
        mediaFile = mediaFile + ".txt";
        
        //materialname for searching is made
        String materialname = materialArr[response].toLowerCase();
        materialname = materialname.replaceAll("[^a-z]", "");
        
        
        
        //media edit
        //mediaFile update
        if(mediaFile == null ? oldmediaFile == null : mediaFile.equals(oldmediaFile)){
            loan = 1;
            
            File inputMediaFile = new File(mediaFile);
            Scanner inMedia = new Scanner(inputMediaFile);
            PrintWriter outMedia = new PrintWriter("temp.txt");
            while(inMedia.hasNextLine()){
                
                String nextline = inMedia.nextLine();
                arrLine2 = nextline.split("~");
                String person = arrLine2[2];
                String [] spliter = person.split("#");
                String name = spliter[0];
                name = person.toLowerCase();


                name = name.replaceAll("[^a-z]", "");
                
                if(name == null ? patronName == null : name.equals(patronName)){
                    arrLine2[2] = " " + patronArr[response] + "#" + dobArr[response] + "#" + patronidArr[response]+ "#" + outdateArr[response] + "#" + indateArr[response];
                    if(pick == 4){
                        arrLine2[2] = "avalible";
                        arrLine2[1] = " 0 ";
                    }
                }
                outMedia.println(mediaFile + "~" + arrLine2[1] + "~" + arrLine2[2]);
            }

            inMedia.close();
            outMedia.close();
            Files loans = new Files("temp.txt", mediaFile);
            loans.fileReplace();
        }
        
        else{
            File inputMediaFile = new File(mediaFile);
            Scanner inMedia = new Scanner(inputMediaFile);
            PrintWriter outMedia = new PrintWriter("temp.txt");
            
            
            loan = 0;
            while(inMedia.hasNextLine()){
                //next line = next line in mediaFile
                String nextline = inMedia.nextLine();

                //splits nextline into an array
                arrLine2 = nextline.split("~");

                //the avalibility part is arrLine2[1]
                String avalibility = arrLine2[1];

                //non letters and spaces remove
                avalibility = avalibility.replaceAll("[^0-9]", "");

                //converts to an Integer
                int aval = Integer.parseInt(avalibility);

                //if the material has not been loaned yet.
                if(loan == 0){
                    //if the copy is avalible
                    if(aval == 0){
                        //updates info
                        arrLine2[1] = " 1 ";
                        arrLine2[2] = " " + patronArr[response] + "#" + dobArr[response] + "#" + patronidArr[response]+ "#" + outdateArr[response] + "#" + indateArr[response];

                        //prints loan
                        System.out.println(materialName + " was loaned to " + patronname + " on " + outDate + " it is due " + inDate);

                        //changes loan status so that all copies are not loaned. 
                        loan = 1;
                    }

                }
            
                //line is printed
                outMedia.println(mediaFile + "~" + arrLine2[1] + " ~" + arrLine2[2]);
            }
            
            inMedia.close();
            outMedia.close();
            Files loans = new Files("temp.txt", mediaFile);
            loans.fileReplace();
            //if after all copies have been checked there are no avalible copies
            if(loan == 0){
                //print sorry
                System.out.println("Sorry, no copies of " + materialName + " were avalible.\n");
            }
            
            
            if(loan != 0){
                File inputOldMediaFile = new File(oldmediaFile);
                Scanner inOldMedia = new Scanner(inputOldMediaFile);
                PrintWriter outOldMedia = new PrintWriter("temp.txt");
                while(inOldMedia.hasNextLine()){
                    String nextline = inOldMedia.nextLine();
                    arrLine2 = nextline.split("~");
                    String person = arrLine2[2];
                    String [] spliter = person.split("#");
                    String name = spliter[0];
                    name = name.toLowerCase();

                    name = name.replaceAll("[^a-z0-9]", "");

                    if(name == null ? patronName == null : name.equals(patronName)){
                       
                    }
                    else{
                        outOldMedia.println(mediaFile + "~" + arrLine2[1] + "~" + arrLine2[2]);
                        
                    }
                }

                inOldMedia.close();
                outOldMedia.close();
                Files loansO = new Files("temp.txt", oldmediaFile);
                loansO.fileReplace();
            }
        }
        
        if(loan != 0){
            //loans are printed to temp file
            while(count < rnum){
                out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            outdateArr[count] + "~" + indateArr[count] + "~" + employeeArr[count] + "~" + employeeidArr[count]);
                count++;
            }

            in.close();
            out.close();
            Files Loans = new Files("temp.txt", "Loans.txt");
            Loans.fileReplace();
            
            
            //fixing all of the patron file mess
            File inputpatronFile = new File(patronFile);
            Scanner inPatron = new Scanner(inputpatronFile);
            PrintWriter outPatron = new PrintWriter("temp.txt");
            if(patronFile == null ? oldpatronFile == null : patronFile.equals(oldpatronFile)){


                while(inPatron.hasNextLine()){
                    String nextline = inPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];

                    String name = title.toLowerCase();

                    name = name.replaceAll("[^a-z0-9]", "");

                    if(name == null ? materialname == null : name.equals(materialname)){
                        arrLine2[1] = outdateArr[response];
                        arrLine2[3] = materialArr[response];
                        arrLine2[5] = indateArr[response];
                        outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
                    }
                    
                    else{
                        outPatron.println(arrLine2[0] + "~" + arrLine2[1] + "~" +arrLine2[2] + "~" +arrLine2[3] + "~" +arrLine2[4] + "~" +arrLine2[5]);
                    }
                }

                inPatron.close();
                outPatron.close();
                Files patron = new Files("temp.txt",patronFile);
                patron.fileReplace();
            }            

            else{
                while(inPatron.hasNextLine()){
                    outPatron.println(inPatron.nextLine());

                }

                outPatron.println("Checkout date ~" + outdateArr[response] + "~ Material name ~" + materialArr[response] + "~ dueDate ~" + indateArr[response]);

                inPatron.close();
                outPatron.close();

                Files patron = new Files("temp.txt",patronFile);
                patron.fileReplace();

                File inputoldpatronFile = new File(oldpatronFile);
                Scanner inoldPatron = new Scanner(inputoldpatronFile);
                PrintWriter outoldPatron = new PrintWriter("temp.txt");

                 while(inoldPatron.hasNextLine()){
                    String nextline = inoldPatron.nextLine();
                    arrLine2 = nextline.split("~");
                    String title = arrLine2[3];

                    String name = title.toLowerCase();

                    name = name.replaceAll("[^a-z0-9]", "");


                    if(name == null ? materialname == null : name.equals(materialname)){
                        //outPatron.println("Checkout date ~" + outdateArr[response] + "~ Material name ~" + materialArr[response] + "~ dueDate ~" + indateArr[response]);
                    }

                    else{
                        outoldPatron.println(nextline);
                    }
                }

                inoldPatron.close();
                outoldPatron.close();
                Files patronold = new Files("temp.txt",oldpatronFile);
                patronold.fileReplace();
            }
        }
        else{
            in.close();
            out.close();
        }
    }
    
    public void searchLoans() throws FileNotFoundException{
        rnum = 0;
        System.out.println("Welcome to the loans searcher. ");
        File inputFile = new File("Loans.txt");
        Scanner in = new Scanner(inputFile);
        
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("~");
            //System.out.println(arrLine[0]);
            materialArr[rnum] = arrLine[0];
            mDateArr[rnum] = arrLine[1];
            materialIdArr[rnum] = arrLine[2];
            patronArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            patronidArr[rnum] = arrLine[5];
            indateArr[rnum] = arrLine[6];
            outdateArr[rnum] = arrLine[7];
            employeeArr[rnum] = arrLine[8];
            employeeidArr[rnum] = arrLine[9];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
        }
        
        int cnum = 1;
        while(cnum == 1){
            System.out.println("Please type the catagory you are searching. ");
            System.out.println("Please type 1 to search material names. ");
            System.out.println("Please type 2 to search patron names. ");
            System.out.println("Please tpye 3 to search employee names. ");
            System.out.println("Please type 4 to search due dates. ");
            System.out.println("Please type 5 to search checkout dates. ");
            System.out.println("Type 0 to quit. \n");
            
            

            Scanner number = new Scanner(System.in);
            int response = number.nextInt();
            
            //director searcher
            if(response == 1){
                System.out.println("You are searching material names. ");
                System.out.println("Please input the name you are searching. \n");

                Scanner name1 = new Scanner(System.in);
                String resp = name1.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = materialArr[count];
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^a-z0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp1.equals(dNew)){
                                System.out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            //patron searcher
            if(response == 2){
                System.out.println("You are searching patron names. ");
                System.out.println("Please input the name you are searching. \n");

                Scanner name1 = new Scanner(System.in);
                String resp = name1.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = patronArr[count];
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^a-z0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp1.equals(dNew)){
                                System.out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            
            //employee searcher
            if(response == 3){
                System.out.println("You are searching employee names. ");
                System.out.println("Please input the name you are searching. \n");

                Scanner name1 = new Scanner(System.in);
                String resp = name1.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = employeeArr[count];
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^a-z0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp1.equals(dNew)){
                                System.out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            //due date searcher
            if(response == 4){
                System.out.println("You are searching loans by due date. ");
                System.out.println("Please input the date you are searching in MM/DD/YYYY form. \n");

                Scanner name1 = new Scanner(System.in);
                String resp = name1.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = outdateArr[count];
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp1.equals(dNew)){
                                System.out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            //due date searcher
            if(response == 5){
                System.out.println("You are searching loans by checkout date. ");
                System.out.println("Please input the date you are searching in MM/DD/YYYY form. \n");

                Scanner name1 = new Scanner(System.in);
                String resp = name1.nextLine();
                
                String split[] = resp.split(" ", 0);
                for(String resp1: split){
                
                    String temp1 = resp1.toLowerCase();
                    resp1 = temp1;

                    temp1 = resp1.replaceAll("^a-z0-9", "");
                    resp1 = temp1; 

                    //System.out.println("in " + resp2);
                    
                    
                    int count = 0;
                    int num = 1;
                    while(count < rnum){
                        
                        String directorNew = indateArr[count];
                        
                        String spliter[] = directorNew.split(" ", 0);
                        
                        for(String dNew: spliter){
                            String temp;

                            temp = dNew.toLowerCase();
                            dNew = temp; 

                            //non letters and spaces remove
                            temp = dNew.replaceAll("[^a-z0-9]", "");
                            dNew = temp;
                            //System.out.println("arr " + dNew);

                            if(resp1.equals(dNew)){
                                System.out.println(materialArr[count] + "~" + mDateArr[count] + "~" + materialIdArr[count] + "~" + patronArr[count] + "~" + dobArr[count] + "~" + patronidArr[count] + "~" + 
                            indateArr[count] + "~" + outdateArr[count] + " ~" + employeeArr[count] + "~" + employeeidArr[count]);
                                num++;
                            }
                        }
                        count++;
                    }
                }  
            }
            
            if(response == 0){
                cnum = 2;
            }
        }
        
    }
    
    public void viewLoans() throws FileNotFoundException{
        Files view = new Files("Loans.txt");
        view.viewFile();
    }
    
    
    public void menu() throws FileNotFoundException{
        Scanner choice = new Scanner(System.in);
                
        int cont = 1;
        while(cont == 1){
            System.out.println("Welcome to the Loans Menu: "); 
            System.out.println("Please type 1 to view all loans: ");
            System.out.println("Please type 2 to add a loan: ");
            System.out.println("Please type 3 to remove a loan: ");
            System.out.println("Please type 4 to edit a loan: ");
            System.out.println("Please type 5 to search loan: ");
            System.out.println("To quit type 0: \n");
            
            int pick = choice.nextInt();
            
            //switch to pick users choice
            switch (pick) {
                
                case 1:
                    viewLoans();
                    break;
                    
                
                case 2:
                    addLoans();
                    break;
                    
                
                case 3:
                    removeLoans();
                    break;
                case 4:
                    editLoans();
                    break;
                    
                case 5:
                    searchLoans();
                    break;
                    
                case 0:
                    System.out.println("Thank you for visiting the loans menu. \n");
                    cont = 3;
                    break;
                    
                //if invalid option is picked print that
                default:
                    System.out.println("You selected " + pick);
                    System.out.println("Invalid option \n");
                    
                    break;
            }


            
        }
    }
}
