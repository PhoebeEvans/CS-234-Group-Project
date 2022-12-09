/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.util.ArrayList;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author jacqu
 */
public class EmployeeTableModel extends AbstractTableModel {
     private final ArrayList<Employee> employeeList;
    
    private final String[] columnNames = new String[] {
        "Weekly Hours Worked", "Employee ID", "Salary", "Position", "Name", "Date of Birth", "Address", "Phone Number"
    };
    private final Class[] columnClass = new Class[] {
        java.lang.Integer.class, java.lang.String.class, java.lang.Double.class, java.lang.String.class, java.lang.String.class, java.lang.Integer.class, java.lang.String.class, java.lang.String.class
    };
    
    public EmployeeTableModel(ArrayList<Employee> employees){
        employeeList = employees;
    }
    
    @Override
    public String getColumnName(int column)
    {
        return columnNames[column];
    }
 
    @Override
    public Class<?> getColumnClass(int columnIndex)
    {
        return columnClass[columnIndex];
    }
 
    @Override
    public int getColumnCount()
    {
        return columnNames.length;
    }
 
    @Override
    public int getRowCount()
    {
        return employeeList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Employee row = employeeList.get(rowIndex);
        if(0 == columnIndex) {
            return row.hoursWorked;
        }
        else if(1 == columnIndex) {
            return row.employeeIdNumber;
        }
        else if(2 == columnIndex) {
            return row.salary;
        }
        else if(3 == columnIndex) {
            return row.position;
        }
         else if(4 == columnIndex) {
            return row.name;
        }
         else if(5 == columnIndex) {
            return row.dateOfBirth;
        }
         else if(6 == columnIndex) {
            return row.address;
        }
         else if(7 == columnIndex) {
            return row.phoneNumber;
        }
        return null;
    }
 
    @Override
    public boolean isCellEditable(int rowIndex, int columnIndex)
    {
        return true;
    }
 
    @Override
    public void setValueAt(Object aValue, int rowIndex, int columnIndex)
    {
        Employee row = employeeList.get(rowIndex);
        if(0 == columnIndex) {
            row.hoursWorked = (int) aValue;
        }
        else if(1 == columnIndex) {
            row.employeeIdNumber = (String) aValue;
        }
        else if(2 == columnIndex) {
            row.salary = (double) aValue;
        }
        else if(3 == columnIndex) {
            row.position = (String) aValue;
        }
         else if(4 == columnIndex) {
            row.name = (String) aValue;
        }
         else if(5 == columnIndex) {
            row.dateOfBirth = (int) aValue;
        }
         else if(6 == columnIndex) {
             row.address = (String) aValue;
        }
         else if(7 == columnIndex) {
             row.phoneNumber = (String) aValue;
        }
    }
     public void removeRow(int rowIndex){
        Employee row = employeeList.get(rowIndex);
        employeeList.remove(row);
        fireTableDataChanged();
    }
     public Employee getRowValue(int rowIndex){
         return employeeList.get(rowIndex);
     }
    
}
