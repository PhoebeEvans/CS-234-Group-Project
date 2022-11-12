/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
import java.io.*;
import java.util.Scanner;
/**
 *
 * @author phoeb
 */
public class Files {
    private String fileName;
    private String fileReplace;
    
    public void fileCreate() throws FileNotFoundException{
        
        //creates file fileName.txt
        PrintWriter outputFile = new PrintWriter(fileName);
        
        //closes fileName.txt
        outputFile.close();
    }
    
    public void viewFile()throws FileNotFoundException{
        
        File viewFile = new File(fileName);
        Scanner in = new Scanner(viewFile);
        
        while(in.hasNextLine()){
                
                System.out.println(in.nextLine());
                
        }
        System.out.println("");
                
                
    }
    
    public void fileReplace()throws FileNotFoundException {
        int num = 1;
        File returnFile = new File(fileReplace);
        Scanner back = new Scanner(returnFile);
        PrintWriter fill = new PrintWriter(fileName);
        
        while(back.hasNextLine()){
        
            fill.println(back.nextLine());
            
            num++;
        }
        
      
        fill.close();
        back.close();
    }
    
    public Files(String fileReplace, String fileName){
        this.fileName = fileName;
        this.fileReplace = fileReplace;
    }
    public Files(String fileName){
        this.fileName = fileName;
    }
    
    
}
