/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author phoeb
 */
public class peoplelistcreator {
    public static void main(String[] args)throws FileNotFoundException {
        //set int num equal to 1. num is used for the menu
        int num;
        num = 1;
        
        //while loop
        while(num ==1){
            //System instructions
            System.out.println("Welcome to the People List Creator. \n");
            System.out.println("Please type 1 to clear file. ");
            System.out.println("Please type 2 to view file. ");
            System.out.println("Please type 3 to add people. ");
            System.out.println("Please type 4 to remove people. ");
            System.out.println("Please type 5 to edit people. ");
            System.out.println("Please type 6 to search. ");
            System.out.println("Press 0 to exit. \n");
            
            
            //scanner to get input from user as to what menu item is desired
            Scanner chose = new Scanner(System.in);
            int choice = chose.nextInt();
            
            //creates space
            System.out.println(" ");
            
            //user choses 0 to exit program 
            if(choice == 0){
                num = 0;
            }
            
            //user choses 1 to clear a file
            if(choice == 1){
                //clearFile class is called
                clearFile oneFile = new clearFile();
                
                //name of file is unputted 
                System.out.println("Please type the name of the file you would like to clear. ");
                Scanner fileClear = new Scanner(System.in);
                String fClear = fileClear.nextLine();
                
                //file is cleared
                oneFile.clearFile(fClear);
                
                
                //menu escape
                System.out.println("Type 1 to view main menu again. To exit program press 0. ");
                Scanner number1 = new Scanner(System.in);
                int numb = number1.nextInt();
                if(numb == 1){
                    num = 1;
                }
                else{
                    num = 0;
                }
            }
            
            
            //user choses 2 to view people.txt file 
            if(choice == 2){
                
                
                viewFile2 viewOne = new viewFile2();
                viewOne.setFile("people.txt");
                
                System.out.println(" ");
                //menuSelect
                System.out.println("Type 1 to view main menu again. To exit program press 0. ");
                Scanner number1 = new Scanner(System.in);
                int numb = number1.nextInt();
                if(numb == 1){
                    num = 1;
                }
                else{
                    num = 0;
                }
            }


            //user choses 3 to add people
            if(choice == 3){
         
                addPeople2 add2 = new addPeople2();
                add2.addPeople2();

                fileReplace replace2 = new fileReplace();
                replace2.fileReplace();

                //menu escape
                System.out.println("Type 1 to view main menu again. To exit program press 0. ");
                Scanner number1 = new Scanner(System.in);
                int numb = number1.nextInt();
                if(numb == 1){
                    num = 1;
                }
                else{
                    num = 0;
                }
                
            }

            
            //user choses 4 to remove people.
            if(choice ==4){

                removePeople removeOne = new removePeople();
                removeOne.removePeople();
                
                fileReplace replaceOne = new fileReplace();
                replaceOne.fileReplace();
               
                //menu select
                System.out.println("Type 1 to view main menu again. To exit program press 0. ");
                Scanner number1 = new Scanner(System.in);
                int numb = number1.nextInt();
                if(numb == 1){
                    num = 1;
                }
                else{
                    num = 0;
                }

            }
            
            
            //user choses 5 to edit people
            if(choice == 5){
         
                editPeople1 add1 = new editPeople1();
                add1.editPeople1();

                fileReplace replace2 = new fileReplace();
                replace2.fileReplace();

                //menu escape
                System.out.println("Type 1 to view main menu again. To exit program press 0. ");
                Scanner number1 = new Scanner(System.in);
                int numb = number1.nextInt();
                if(numb == 1){
                    num = 1;
                }
                else{
                    num = 0;
                }
                
            }
            
            
            //user choses 6 to search
            if(choice == 6){
         
                peopleSearch search1 = new peopleSearch();
                search1.peopleSearch();

                //menu escape
                System.out.println("Type 1 to view main menu again. To exit program press 0. ");
                Scanner number1 = new Scanner(System.in);
                int numb = number1.nextInt();
                if(numb == 1){
                    num = 1;
                }
                else{
                    num = 0;
                }
                
            }
        }
        
    }
    
}
