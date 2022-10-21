package com.mycompany.cs234project;


import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phoeb
 */
public class Patrons {
    private String name;
    private String iDnumber;
    private int age = 75;
    private String ageGroup = "Adult";
    private String dateofBirth;
    private String address;
    private String phone;
    private int rnum = 1;
    private String patronFile;
    private String oldFilename;
    private String[] arrLine;
    private String[] nameArr;
    private String[] idArr;
    private String[] ageArr;
    private String[] ageGroupArr;
    private String[] dobArr;
    private String[] addressArr;
    private String[] phoneArr;
    private String[] tempArr;
    
    public Patrons() throws FileNotFoundException{
        //people.txt and temp.txt are opened
        File inputFile = new File("Patrons.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
      
        rnum = 1;
        //read the input and write the output
        while(in.hasNextLine()){
            //replace all of the existing users
            String lineChange = in.nextLine();
            

            arrLine = lineChange.split("_");
            
            Age patrons = new Age(arrLine[4]);
            age = patrons.findAge();
            //age and age group
            if(age < 18){
                ageGroup = "Child";
            }

            else if(age>=18){
                ageGroup = "Adult";
            }
                
            out.println(rnum + " _" + arrLine[1] + "_ " + age + " _ " + ageGroup + "_" + arrLine[4] + "_" + arrLine[5]+  "_" + arrLine[6] + "_" + arrLine[7]);
            rnum ++;
        }
        
        //close both files so they are not cleared. 
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , "Patrons.txt");
    }
    
    public void addPatron() throws FileNotFoundException{
        //name
        
        StringCreate material = new StringCreate();
        
        //name
        name = material.stringC("Please type the name of the Patron: ");
        
        //dob
        
        dateofBirth = material.stringC("Please type dob: ");
        
        Age patron = new Age(dateofBirth);
        age = patron.findAge();
        //age and age group
        if(age < 18){
            ageGroup = "Child";
        }
        
        else if(age>=18){
            ageGroup = "Adult";
        }
        
        //address 
        address = material.stringC("Please type the address of the patron: ");
        
        //phone
        phone = material.stringC("Please type the phone number: ");
        
      
        
        
        //people.txt and temp.txt are opened
        File inputFile = new File("Patrons.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
      
        rnum = 1;
        //read the input and write the output
        while(in.hasNextLine()){
            //replace all of the existing users
            out.println(in.nextLine());
            
            //increment rnum 
            rnum ++;
        }
        
        idCreate create = new idCreate();
        iDnumber = create.idCreate("000", "idList2.txt");
        
        
        fileReplace2 replace = new fileReplace2();
        replace.fileReplace2( "temp2.txt" , "idList2.txt");
        
        
        //print new user's information to temp.txt 
        out.println(rnum +  " _ " + name + " _ " + age + " _ " + ageGroup + " _ " + dateofBirth+ " _ " + address + " _ " + phone + " _ " + iDnumber);
        
        //close both files so they are not cleared. 
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , "Patrons.txt");
        
        //creates file for movie. 
        
        patronFile = name + dateofBirth + "Id" + iDnumber; 
        //Trims whitespace and characters other than letters and numbers
        String rePlace = patronFile.replaceAll("[^a-zA-Z0-9]", "");
        patronFile = rePlace; 
        String tempString = patronFile + ".txt";
        patronFile = tempString;
        
        //Creates file with fileCreate 
        fileCreate createFile = new fileCreate();      
        createFile.fileCreate(patronFile);
        
        
    }
    
    public void removePatron() throws FileNotFoundException{
        /*read name to be removed*/
        rnum = 1;
        
        System.out.println("Please type the number of the person you wish to remove: ");
        Scanner delete = new Scanner(System.in);
        int response = delete.nextInt();
        
        
        File inputFile = new File("Patrons.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        //read the input and write the output
        while(in.hasNextLine()){
            if(response == in.nextInt()){
                //out.printf("");
                System.out.println(in.nextLine()+" is being removed. ");
            }

            else{
                out.println(rnum + in.nextLine());
                //System.out.println("keep " + in.nextLine());
                rnum ++;
            }
        }
        
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , "Patrons.txt");
        
    }
    
    public void editPatron() throws FileNotFoundException{
        //name
        System.out.println("Please type the number of the patron you want to edit ");
        
        Scanner numb = new Scanner(System.in);
        int response = numb.nextInt();
        
        rnum = 1;
        File inputFile = new File("Patrons.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
         
        
       //read the input and write the output
        while(in.hasNextLine()){ 
            if(response == in.nextInt()){
                String lineChange = in.nextLine();
                System.out.println(lineChange);
                arrLine = lineChange.split("_");
                
                //find file name 
                oldFilename = arrLine[1] + arrLine[4] + "Id" + arrLine[7]; 
                String rePlace2 = oldFilename.replaceAll("[^a-zA-Z0-9]", "");
                oldFilename = rePlace2;
                String temp3 = oldFilename +".txt";
                oldFilename = temp3; 
               
                
                
                int loop2 = 1;
                
                while(loop2 == 1 ){
                    
                    System.out.println("What part do you want to edit? ");
                    System.out.println("Type 1 to edit the name of the movie. ");
                    System.out.println("Type 2 to edit the dateofBirth. ");
                    System.out.println("Type 3 to edit the address. ");
                    System.out.println("Type 4 to edit the phone. ");

                    //scan
                    Scanner pick = new Scanner(System.in);
                    int pick2 = pick.nextInt();
                
                    StringCreate material = new StringCreate();
                    if(pick2 == 1){
                        System.out.println(" Name Change ");
                        System.out.println("Current Name is: " + arrLine[1]);

                        
        
                        //name
                        arrLine[1] = material.stringC("Please type the name: ");
                        System.out.println(arrLine[1]);
                        
                        
                        loop2 = 0;
                    }

                    
                    if(pick2 == 2){
                        System.out.println(" Date of Birth ");
                        System.out.println("Current Date of Birth: " + arrLine[4]);

                        arrLine[4] = material.stringC("Please type the Date of Birth: ");
                        System.out.println(arrLine[4]);
                        
                        
                        loop2 = 0;
                    }
                    
                    if(pick2 == 3){
                        System.out.println(" Address Change ");
                        System.out.println("Current Address is: " + arrLine[5]);

                        arrLine[5] = material.stringC("Please type the Address: ");
                        System.out.println(arrLine[5]);
                        
                        
                        loop2 = 0;
                    }
                    
                    if(pick2 == 4){
                        System.out.println(" Phone Number Change ");
                        System.out.println("Current Phone number is: " + arrLine[6]);

                        arrLine[6] = material.stringC("Please type the phone number: ");
                        System.out.println(arrLine[6]);
                        
                        
                        loop2 = 0;
                    }
                      
                }
                
                
                Age patron = new Age(arrLine[4]);
                age = patron.findAge();
                //age and age group
                if(age < 18){
                    ageGroup = "Child";
                }

                else if(age>=18){
                    ageGroup = "Adult";
                }
        
        
                out.println(rnum + " _ " + arrLine[1] + " _ " + age + " _ " + ageGroup + " _ " + arrLine[4] + " _ " + arrLine[5]+  " _ " + arrLine[6] + " _ " + arrLine[7]);
                rnum ++;
                
                String iD;
                iD = arrLine[1] + arrLine[4] + "Id" + arrLine[7]; 
                //Trims whitespace and characters other than letters and numbers
                String rePlace = iD.replaceAll("[^a-zA-Z0-9]", "");
                iD = rePlace; 
                String temp = iD + ".txt";
                iD = temp;

                //Creates file with fileCreate 
                fileCreate createFile = new fileCreate();      
                createFile.fileCreate(iD);
                
                fileReplace2 replace2 = new fileReplace2();
                replace2.fileReplace2( oldFilename ,iD);
                    
            }

            else{
                out.println(rnum + in.nextLine());
                //System.out.println("keep " + in.nextLine());
                rnum ++;
            }
        }
        
        
        
        in.close();
        out.close();
        
        fileReplace2 replace2 = new fileReplace2();
        replace2.fileReplace2( "temp.txt" , "Patrons.txt");
        
    }
    
    public void viewPatrons() throws FileNotFoundException{
        
        Viewfile viewOne = new Viewfile();
        
        viewOne.setFile("Patrons.txt");
    }
    
    public void searchPatrons() throws FileNotFoundException{
        rnum = 0;
        
        File inputFile = new File("Patrons.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        int value = 100; 
        
        
        nameArr = new String[value];
        idArr = new String[value];
        ageArr = new String[value];
        ageGroupArr = new String[value];
        dobArr = new String[value]; 
        addressArr = new String[value];
        phoneArr = new String[value];
        arrLine = new String[8];
        tempArr = new String[1];
        idArr = new String[value];
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("_");
            //System.out.println(arrLine[0]);
            
            nameArr[rnum] = arrLine[1];
            ageArr[rnum] = arrLine[2];
            ageGroupArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            addressArr[rnum] = arrLine[5];
            phoneArr[rnum] = arrLine[6];
            idArr[rnum] = arrLine[7];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
          
        }
        int cnum = 1;
        while(cnum == 1){
            System.out.println("Please type the catagory you are searching. ");
            System.out.println("Please type 1 to search names. ");
            System.out.println("Please type 2 to search ages. ");
            System.out.println("Please tpye 3 to search age groups. ");
            System.out.println("Please type 4 to search dob. ");
            
            

            Scanner number = new Scanner(System.in);
            int response = number.nextInt();
            
            
            //name searcher
            //country searcher
            
            //director searcher
            if(response == 1){
                System.out.println("You are searching names. ");
                System.out.println("Please input the name you are searching. ");

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

                    while(count < rnum){

                        tempArr[0] = nameArr[count];

                        String directorNew = Arrays.toString(tempArr);
                        
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
                                System.out.println(nameArr[count] + " - " + ageArr[count] + " - " + ageGroupArr[count] + " - " + dobArr[count] + " - " + addressArr[count]+ " - " + phoneArr[count] + " - " + idArr[count]);
                                
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
                
                 
            }

            //director searcher
            if(response == 2){
                System.out.println("Enter the age you are searching. ");

                Scanner age2 = new Scanner(System.in);
                int ageInt = age2.nextInt();
                
                int count = 0;
                
                

                
                while(count  < rnum){
                    
                    tempArr[0] = ageArr[count];

                    String dateNew = Arrays.toString(tempArr);
                    String temp;
                    temp = dateNew.replaceAll("[^0-9]", "");
                    dateNew = temp;
                    
                    int intAge = Integer.parseInt(dateNew);

                    if(ageInt == intAge){
                        System.out.println(nameArr[count] + " - " + ageArr[count] + " - " + ageGroupArr[count] + " - " + dobArr[count] + " - " + addressArr[count]+ " - " + phoneArr[count] + " - " + idArr[count]);
                    }
                    count++;

                }
                
                 
            }
            
            //age searcher
            if(response == 3){
                System.out.println("You are searching age Groups. ");
                System.out.println("Please input the group you are searching. ");

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

                    while(count < rnum){

                        tempArr[0] = ageGroupArr[count];

                        String directorNew = Arrays.toString(tempArr);
                        
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
                                System.out.println(nameArr[count] + " - " + ageArr[count] + " - " + ageGroupArr[count] + " - " + dobArr[count] + " - " + addressArr[count]+ " - " + phoneArr[count] + " - " + idArr[count]);
                                
                            }
                            
                        
                        }
                        count++;
                    }
                
                }
                
                
                
            }
            
            if(response == 4){
                System.out.println("You are searching dob. ");
                System.out.println("Please input the dob you are searching. ");

                Scanner name2 = new Scanner(System.in);
                String resp = name2.nextLine();
                
                
                String temp2 = resp.replaceAll("[^0-9]", "");
                resp = temp2; 

                
                int count = 0;

                while(count < rnum){

                    tempArr[0] = dobArr[count];

                    String nameNew = Arrays.toString(tempArr);
                    String temp;
                    
                    //non letters and spaces remove
                    temp = nameNew.replaceAll("[^0-9]", "");
                    nameNew = temp;
                    
                    
                    
                            
                    if(resp.equals(nameNew)){
                        System.out.println(nameArr[count] + " - " + ageArr[count] + " - " + ageGroupArr[count] + " - " + dobArr[count] + " - " + addressArr[count]+ " - " + phoneArr[count] + " - " + idArr[count]);

                    }
                    count++;
                }
                
                 
            }

            
            System.out.println("Type 1 to continue searching, type 0 to quit. ");
            Scanner  cont = new Scanner(System.in);
            cnum = cont.nextInt();
            
        }
        
        
        
     in.close();
     out.close();
    }
    
    public void menu() throws FileNotFoundException{
        Scanner choice = new Scanner(System.in);
                
        int cont = 1;
        while(cont == 1){
            int pick = 0; 
            System.out.println("Welcome to the Patrons Menu: "); 
            System.out.println("Please type 1 to view all patrons: ");
            System.out.println("Please type 2 to add a patron: ");
            System.out.println("Please type 3 to remove a patron: ");
            System.out.println("Please type 4 to edit a patron: ");
            System.out.println("Please type 5 to search patrons: \n");
            
            pick = choice.nextInt();
            
            //switch to pick users choice
            switch (pick) {
                
                case 1:
                    viewPatrons();
                    break;
                    
                
                case 2:
                    addPatron();
                    break;
                    
                
                case 3:
                    removePatron();
                    break;
                case 4:
                    editPatron();
                    break;
                    
                case 5:
                    searchPatrons();
                    break;
                    
                //if invalid option is picked print that
                default:
                    System.out.println("You selected " + pick);
                    System.out.println("Invalid option \n");
                    cont = 3;
                    break;
            }


            
        }
    }
    
}
