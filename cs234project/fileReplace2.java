/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;

/**
 *
 * @author phoeb
 */
public class fileReplace2 {

    public String replaceFile;
    public String fillFile; 
    
    public void fileReplace2(String replaceFile, String fillFile)throws FileNotFoundException {
        int num = 1;
        File returnFile = new File(replaceFile);
        Scanner back = new Scanner(returnFile);
        PrintWriter fill = new PrintWriter(fillFile);
        
        while(back.hasNextLine()){
        
            fill.println(back.nextLine());
            
            num++;
        }
        
      
        fill.close();
        back.close();
    }
    
}
