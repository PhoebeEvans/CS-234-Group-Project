/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

/**
 *
 * @author phoeb
 */

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author phoeb
 */
public class Viewfile {
    private String text;
    private String answer;
    
    
    public void setFile(String fileText) throws FileNotFoundException{
        text = fileText;
        
        File viewFile = new File(text);
        Scanner in = new Scanner(viewFile);
        
        while(in.hasNextLine()){
                
                System.out.println(in.nextLine());
                
        }
                
                
    }
    
    
}
