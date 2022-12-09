/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package guilibrary;
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
        
        int value = 100; 
        
        int rnum = 0;
        String[] nameArr = new String[value];
        String[] idArr = new String[value];
        String[] ageArr = new String[value];
        String[] ageGroupArr = new String[value];
        String[] dobArr = new String[value]; 
        String[] addressArr = new String[value];
        String[] phoneArr = new String[value];
        String[] arrLine = new String[8];
        String[] tempArr = new String[1];
        idArr = new String[value];
  
        while(in.hasNextLine()){
            String lineChange = in.nextLine();
            
            
            arrLine = lineChange.split("_");
            //System.out.println(arrLine[0]);
            
            nameArr[rnum] = arrLine[1];
            ageArr[rnum] = arrLine[2];
            ageGroupArr[rnum] = arrLine[3];
            dobArr[rnum] = arrLine[4];
            addressArr[rnum] = arrLine[5];
            phoneArr[rnum] = arrLine[6];
            idArr[rnum] = arrLine[7];
            
            //System.out.println(name[num]);
            //System.out.println(age[num]);
            
            rnum++;
          
        }
                
                
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
