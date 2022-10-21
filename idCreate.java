/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;


//Add name after number and when assigning a number read down until there is no name.
/**
 *
 * @author phoeb
 */
public class idCreate {

    /**
     *
     * @param Id
     * @return
     * @throws FileNotFoundException
     */
    public String idCreate(String Id, String file) throws FileNotFoundException{
        
        File idFile = new File(file);
        Scanner id = new Scanner(idFile);
        PrintWriter temp = new PrintWriter("temp2.txt");
        
        Id = id.nextLine();
        System.out.println(Id);
        
        while(id.hasNextLine()){
            
                temp.println(id.nextLine());
                
            
        }
        id.close();
        temp.close();
        return Id;
         
    }
}
