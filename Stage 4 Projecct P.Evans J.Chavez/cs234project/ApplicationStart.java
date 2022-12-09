/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package cs234project;
import java.io.FileNotFoundException;
/**
 *
 * @author jacqu
 */
public class ApplicationStart {

    /**
     * @param args the command line arguments
     */
   public static void main(String[] args) throws FileNotFoundException {
        
        System.out.println(System.getProperty("user.dir"));
        Library pbville = new Library("Leadville");
        
        pbville.menu();
       
      
    }
    
}
