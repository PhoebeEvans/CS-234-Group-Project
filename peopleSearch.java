/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Scanner;
import java.util.*;
import java.io.*;

/**
 *
 * @author phoeb
 */
public class peopleSearch {
    public void peopleSearch() throws FileNotFoundException {
        
        int num = 0;
        
        File inputFile = new File("people.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        String[] name = new String[100];
        String[] age = new String[100];
        String[] group = new String[100];
        String[] tempName = new String[1];
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            String[] arrLine = lineChange.split(" - ");
            //System.out.println(arrLine[0]);
            
            name[num] = arrLine[1];
            age[num] = arrLine[2];
            group[num] = arrLine[3];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            num++;
          
        }
        int cnum = 1;
        while(cnum == 1){
            System.out.println("Please type the catagory you are searching. ");
            System.out.println("Please type 1 to search names. ");
            System.out.println("Please tpye 2 to search ages. ");
            System.out.println("Please type 3 to search for kids. ");
            System.out.println("Please type 4 to search for adults. ");

            Scanner number = new Scanner(System.in);
            int response = number.nextInt();
            
            
            //name searcher
            if(response == 1){
                System.out.println("You are searching names. ");
                System.out.println("Please input the name you are searching. ");

                Scanner name2 = new Scanner(System.in);
                String resp = name2.nextLine();
                
                //right whitespace trim
                String temp2 = resp.replaceAll("\\s+$", "");
                resp = temp2; 
                
                
                //left whitespace trim
                temp2 = resp.replaceAll("\\s+", "");
                resp = temp2; 
                

                
                int count = 0;

                while(count < num){

                    tempName[0] = name[count];

                    String nameNew = Arrays.toString(tempName);
                    String temp;
                    
                    //non letters and spaces remove
                    temp = nameNew.replaceAll("[^a-zA-Z\\s]", "");
                    nameNew = temp;
                    
                    //right whitespace trim
                    temp = nameNew.replaceAll("\\s+$", "");
                    nameNew = temp;
                    
                    //left whitespace trim
                    temp = nameNew.replaceAll("\\s+", "");
                    nameNew = temp;
                            
                    if(resp.equals(nameNew)){
                        System.out.println(name[count] + " - " + age[count] + " - " + group[count] +"\n");

                    }
                    count++;
                }
                
                System.out.println("Type 1 to continue searching and 9 to exit. ");
                Scanner cont = new Scanner(System.in);
                cnum = cont.nextInt();
            }

            
            //age searcher
            if(response == 2){
                System.out.println("Enter the age you are searching. ");

                Scanner age2 = new Scanner(System.in);
                int ageInt = age2.nextInt();

                int counter = 0;
                while(counter  < num){
                    
                    int intAge = Integer.parseInt(age[counter]);

                    if(ageInt == intAge){
                        System.out.println(name[counter] + " - " + age[counter] + " - " + group[counter] );
                    }
                    counter++;

                }
                
                System.out.println("Type 1 to continue searching and 9 to exit. ");
                Scanner cont = new Scanner(System.in);
                cnum = cont.nextInt();
                
            }
            
            
            //kid searcher
            //age searcher
            if(response == 3){
                System.out.println("Welcome to the kid searcher. ");
                System.out.println("");

                int counter = 0;
                while(counter  < num){
                    
                    int intAge = Integer.parseInt(age[counter]);

                    if(intAge < 18){
                        System.out.println(name[counter] + " - " + age[counter] + " - " + group[counter] );
                    }
                    counter++;

                }
                
                System.out.println("Type 1 to continue searching and 9 to exit. ");
                Scanner cont = new Scanner(System.in);
                cnum = cont.nextInt();
                
            }
            
            //adult searcher
            //age searcher
            if(response == 4){
                System.out.println("Welcome to the adult searcher. ");
                System.out.println("");

                int counter = 0;
                while(counter  < num){
                    
                    int intAge = Integer.parseInt(age[counter]);

                    if(intAge >= 18){
                        System.out.println(name[counter] + " - " + age[counter] + " - " + group[counter] );
                    }
                    counter++;

                }
                
                System.out.println("Type 1 to continue searching and 9 to exit. ");
                Scanner cont = new Scanner(System.in);
                cnum = cont.nextInt();
                
            }
        }
        
        
        
     in.close();
     out.close();
        
    }
    
}
