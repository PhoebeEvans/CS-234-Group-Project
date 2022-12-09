/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;
import java.io.FileNotFoundException;
import java.util.Scanner;
/**
 *
 * @author jacqu
 */
public class Library {
     private String name;
    private int choose;
    
    public Library(String name){
        this.name = name;
    }
    
    public int intC(String instruc){
        int response;
        System.out.println(instruc);
        
        //get response from user
        Scanner date = new Scanner(System.in);
        response = date.nextInt();
        
        return response;
    }
    
   public void employees(){
        EmployeeMenu e1 = new EmployeeMenu();
        e1.MainMenu();
    }
    
    public void patrons() throws FileNotFoundException{
        Patrons p1 = new Patrons();
        p1.menu();
    }
    
    public void loans() throws FileNotFoundException{
        Loans L1 = new Loans();
        L1.menu();
    }
    
    
    public void books() throws FileNotFoundException{
        Books b1 = new Books();
        b1.menu();
    }
    
    public void movies() throws FileNotFoundException{
        Movies m1 = new Movies();
        m1.menu();
    }
    
    public void programs(){
        ProgramMenu p2 = new ProgramMenu();
        p2.MainMenu();
    }
    
    public void menu() throws FileNotFoundException{
        
        
        int cont = 1;
        while(cont == 1){
            System.out.println("Welcome to the " + name + " Library");
            System.out.println("This is the main menu. ");
            System.out.println("Please choose 1 to access the employees menu: ");
            System.out.println("Please choose 2 to access the patrons menu: ");
            System.out.println("Please choose 3 to access the loans menu: ");
            System.out.println("Please choose 4 to access the books menu: ");
            System.out.println("Please choose 5 to access the movies menu: ");
            System.out.println("Please choose 6 to access the programs menu: ");
            System.out.println("To quit the system choose 0: ");

            
            choose = intC("What menu do you want to access? ");
            
            
            //switch to pick users choice
            switch (choose) {
                
                case 1:
                    employees();
                    break;
                    
                
                case 2:
                    patrons();
                    break;
                    
                
                case 3:
                    loans();
                    break;
                case 4:
                    books();
                    break;
                    
                case 5:
                    movies();
                    break;
                    
                case 6: 
                    programs();
                    break;
                    
                case 0:
                    System.out.println("You are exiting the " + name + " Library.");
                    cont = 3;
                    break;
                    
                //if invalid option is picked print that
                default:
                    System.out.println("You selected " + choose);
                    System.out.println("Invalid option \n");
                    break;
            }


            
        }
    }
    
}
