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


public class clearFile {
    
    public String fileName;
    public void clearFile(String fileName) throws FileNotFoundException{
        
        try (PrintWriter fileA = new PrintWriter(fileName)) {
            fileA.flush();
        }
        
    }

 
}
