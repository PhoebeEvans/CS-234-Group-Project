package com.mycompany.cs234project;


import java.util.Scanner;

/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author phoeb
 */
public class IntCreate {
    private int response;
    public int intC(String x){
        System.out.println(x);
        
        //get response from user
        Scanner date = new Scanner(System.in);
        response = date.nextInt();
        
        return response;
    }
}
