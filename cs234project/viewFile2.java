/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/**
 *
 * @author phoeb
 */
public class viewFile2 {
    private String text;
    private String answer;
    
    public viewFile2(){
        text = "";
        answer = "";
    }
    
    public void setFile(String fileText) throws FileNotFoundException{
        text = fileText;
        
        File viewFile = new File(text);
        Scanner in = new Scanner(viewFile);
        
        while(in.hasNextLine()){
                
                System.out.println(in.nextLine());
                
        }
                
                
    }
    
   
    public void display(){
        System.out.println(text);
    }
    
}
