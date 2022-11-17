/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;
import java.io.Serializable;
/**
 *
 * @author jacqu
 */
public class Employee implements Serializable{
    //variables for employees
    public int hoursWorked;
    public String employeeIdNumber;
    public double salary; 
    public String position;
    public String name;
    public int dateOfBirth;
    public String address; 
    public String phoneNumber;
    //constructor
    public Employee (int _hoursWorked, String _employeeIdNumber, double _salary, String _position, String _name, int _dateOfBirth, String _address, String _phoneNumber){
        hoursWorked = _hoursWorked;
        employeeIdNumber = _employeeIdNumber;
        salary = _salary;
        position = _position;
        name = _name;
        dateOfBirth = _dateOfBirth;
        address = _address;
        phoneNumber = _phoneNumber;
               
        
            
    } 
    //turn object employee into string object
    @Override
    public String toString(){
        System.out.println("\n~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~\n");
        String output = "{" + hoursWorked + "," + employeeIdNumber + ", " + salary + ", " + position 
                + ", " + name + ", " + dateOfBirth + ", " + address + ", " 
                + phoneNumber +  "}\n";
        
        return output;
    }
    
    
}
