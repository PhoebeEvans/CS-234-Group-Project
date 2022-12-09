/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author jacqu
 */
public class Program implements Serializable {
    //variables of Programs

    String speakerProgram;
    String eventName;
    String dateOfEvent;
    String location;
    public ArrayList<String> Patrons = new ArrayList<>();

    //constructor
    public Program(String _speakerProgram, String _eventName, String _dateOfEvent, String _location, ArrayList _Patrons) {
        speakerProgram = _speakerProgram;
        eventName = _eventName;
        dateOfEvent = _dateOfEvent;
        location = _location;
        Patrons = _Patrons;

    }
    //turn object into String and return string 

    @Override
    public String toString() {
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        String output = "{" + speakerProgram + ", " + eventName + ", " + dateOfEvent
                + ", " + location + ", " + Patrons + "}\n";
        return output;
    }

    //add Patrons to arraylist
    public void addPatron(String patronName) {

        Patrons.add(patronName);
    }
    //remove Patrons from arraylist

    public void removePatron(String removeName) {

        int index = Patrons.indexOf(removeName);
        Patrons.remove(index);

    }

}
