/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author phoeb
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class editPeople1 {

    /**
     *
     * @throws FileNotFoundException
     */
    public void editPeople1()throws FileNotFoundException {
        //name
        System.out.println("Please type the number of the person you want to edit ");
        
        Scanner numb = new Scanner(System.in);
        int response = numb.nextInt();
        
        int num = 1;
        File inputFile = new File("people.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        String oldFilename; 
        
       //read the input and write the output
        while(in.hasNextLine()){
            if(response == in.nextInt()){
                String lineChange = in.nextLine();
                System.out.println(lineChange);
                
                String[] arrLine = lineChange.split("-");
                
                //find file name 
                oldFilename = arrLine[1] + arrLine[2]; 
                String rePlace2 = oldFilename.replaceAll("[^a-zA-Z0-9]", "");
                oldFilename = rePlace2;
                String temp3 = oldFilename +".txt";
                oldFilename = temp3; 
               
                
                
                int loop2 = 1;
                
                while(loop2 == 1 ){
                    
                    System.out.println("What part do you want to edit? ");
                    System.out.println("Type 1 to edit your name. ");
                    System.out.println("Type 2 to edit your age. ");

                    //scan
                    Scanner pick = new Scanner(System.in);
                    int pick2 = pick.nextInt();
                
                
                    if(pick2 == 1){
                        System.out.println(" Name Change ");
                        System.out.println("Current Name is: " + arrLine[1]);

                        System.out.println("Please type your name: ");
                        Scanner name2 = new Scanner(System.in);
                        String resp = name2.nextLine();
                        arrLine[1] = resp;
                        System.out.println(arrLine[1]);
                        
                        System.out.println("Press 0 to exit editor ");
                        System.out.println("Press 1 to edit more ");
                        Scanner escape = new Scanner(System.in);
                        loop2 = escape.nextInt();
                    }

                    if(pick2 == 2){
                        System.out.println(" Age Change ");
                        System.out.println("Current Age is: " + arrLine[2]);

                        System.out.println("Please type your age: ");
                        Scanner age2 = new Scanner(System.in);
                        String resp = age2.nextLine();
                        arrLine[2] = resp;
                        System.out.println(arrLine[2]);
                        
                        int age = Integer.parseInt(arrLine[2]);
                        //age group
                        String group = " ";
                        if(age < 18){
                            group = "Kid";

                        }

                        if(age >= 18){
                            group = "Adult";
                        } 
                        
                        arrLine[3] = group;
        
                        //system escape
                        System.out.println("Press 0 exit editor ");
                        System.out.println("Press 1 to edit more ");
                        Scanner escape = new Scanner(System.in);
                        loop2 = escape.nextInt();

                    }
                    
                    

                    
                }
                
                out.println(num + " - " + arrLine[1] + " - " + arrLine[2] + " - " + arrLine[3]);
                num++;
                
                String iD;
                iD = arrLine[1] + arrLine[2]; 
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
                out.println(num + in.nextLine());
                //System.out.println("keep " + in.nextLine());
                num ++;
            }
        }
        
        
        
        in.close();
        out.close();
        
        
        

    }
}
