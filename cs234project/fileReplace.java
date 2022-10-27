package com.mycompany.mavenproject1;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.io.File;
/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phoeb
 */
public class fileReplace {

    /**
     *
     * @throws FileNotFoundException
     */
    public void fileReplace()throws FileNotFoundException {
        int num = 1;
        File returnFile = new File("temp.txt");
        Scanner back = new Scanner(returnFile);
        PrintWriter fill = new PrintWriter("people.txt");
        
        while(back.hasNextLine()){
        
            fill.println(back.nextLine());
            
            num++;
        }
        
      
        fill.close();
        back.close();
    }
    
}