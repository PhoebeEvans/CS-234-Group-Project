package com.mycompany.cs234project;

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
