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

public class addPeople2 {
    public void addPeople2()throws FileNotFoundException {
        //name
        System.out.println("Please type your name ");
        
        //get response from user
        Scanner name = new Scanner(System.in);
        String response = name.nextLine();
        
        //trim whitespace
        //right whitespace trim
        String temp = response.replaceAll("\\s+$", "");
        response = temp;

        
        //age
        System.out.println("Please type your age ");
        
        //get response from user
        Scanner age = new Scanner(System.in);
        int re2 = age.nextInt();
        
        //create string group to show kid or adult
        String group = " ";
        
        //If the user is under 18 group is kid. 
        if(re2 < 18){
            group = "Kid";   
        }
        
        //if the user is 18 or over group is adult
        if(re2 >= 18){
            group = "Adult";
        } 
        
        //rnum is an integer which is increased each time and is used to number the people
        int rnum = 1;
        
        //people.txt and temp.txt are opened
        File inputFile = new File("people.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
      
        
        //read the input and write the output
        while(in.hasNextLine()){
            //replace all of the existing users
            out.println(in.nextLine());
            
            //increment rnum 
            rnum ++;
        }
        
        //print new user's information to temp.txt 
        out.println(rnum +  " - " + response + " - " + re2 + " - " + group);
        
        //close both files so they are not cleared. 
        in.close();
        out.close();
        
        //creates file for user. 
        String iD;
        iD = response + re2; 
        //Trims whitespace and characters other than letters and numbers
        String rePlace = iD.replaceAll("[^a-zA-Z0-9]", "");
        iD = rePlace; 
        String temp2 = iD + ".txt";
        iD = temp2;
        
        //Creates file with fileCreate 
        fileCreate createFile = new fileCreate();      
        createFile.fileCreate(iD);
        
      
    }
}