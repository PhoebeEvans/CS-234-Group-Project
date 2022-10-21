/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.cs234project;

import java.util.Date;

/**
 *
 * @author phoeb
 */
public class Age {
    private int dateC;
    private int monthC;
    private int yearC;
    private int dateB;
    private int monthB;
    private int yearB;
    private int age;
    
            
    public Age(){
        Date currentDate = new Date();
        dateC = currentDate.getDate();
        monthC = currentDate.getMonth();
        yearC = currentDate.getYear();
          
    }
    
    public Age(String dob){
        Date currentDate = new Date();
        dateC = currentDate.getDate();
        monthC = currentDate.getMonth();
        yearC = currentDate.getYear();
        Date dateofBirth = new Date(dob);
        dateB = dateofBirth.getDate();
        monthB = dateofBirth.getMonth();
        yearB = dateofBirth.getYear();
        
    }
    public void printDateC(){
        System.out.println((monthC+1) + "/" + dateC + "/" + (yearC+1900));
    }
    
    public void printDateB(){
        System.out.println((monthB+1) + "/" + dateB + "/" + (yearB+1900));
    }
    
    public int findAge(){
        if(monthB < monthC){
            age = (yearC-yearB);
        }
        else if(monthB == monthC){
            if(dateC >= dateB){
                age = (yearC-yearB);
            }
            else{
                age = (yearC-yearB-1);
            }
        }
        else{
            age = (yearC-yearB-1);
        }
        
        
        return age;
    }
    
    
}
