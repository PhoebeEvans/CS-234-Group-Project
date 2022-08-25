/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.mavenproject1;

/**
 *
 * @author phoeb
 */
import java.io.*;

public class fileCreate {
    //creates string fileName
    public String fileName; 
    public void fileCreate(String fileName) throws FileNotFoundException{
        
        //creates file fileName.txt
        PrintWriter outputFile = new PrintWriter(fileName);
        
        //closes fileName.txt
        outputFile.close();
    }
    
}
