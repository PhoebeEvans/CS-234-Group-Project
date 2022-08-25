package com.mycompany.mavenproject1;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phoeb
 */
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;

public class removePeople {
    public void removePeople()throws FileNotFoundException {
        /*read name to be removed*/
        int num = 1;
        System.out.println("Please number of the name to remove ");
        
        Scanner delete = new Scanner(System.in);
        int response = delete.nextInt();
        
        File inputFile = new File("people.txt");
        Scanner in = new Scanner(inputFile);
        PrintWriter out = new PrintWriter("temp.txt");
        
        //read the input and write the output
        while(in.hasNextLine()){
            if(response == in.nextInt()){
                //out.printf("");
                System.out.println(in.nextLine()+" is being removed. ");
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
