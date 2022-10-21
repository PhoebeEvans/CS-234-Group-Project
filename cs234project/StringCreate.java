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
public class StringCreate {
    private String response;
    public String stringC(String x){
        System.out.println(x);
        
        //get response from user
        Scanner reply = new Scanner(System.in);
        String response = reply.nextLine();
        
        //trim whitespace
        //right whitespace trim
        String temp = response.replaceAll("\\s+$", "");
        response = temp;
        return response;
    }
}
