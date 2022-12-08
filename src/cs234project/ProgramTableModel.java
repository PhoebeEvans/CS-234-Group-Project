/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import javax.swing.table.AbstractTableModel;
import java.io.*;
import java.util.ArrayList;

/**
 *
 * @author jacqu
 */
public class ProgramTableModel extends AbstractTableModel {
    private final ArrayList<Program> programList;
    
    private final String[] columnNames = new String[] {
        "Name", "Speaker", "Location", "Date"
    };
    private final Class[] columnClass = new Class[] {
        java.lang.String.class, java.lang.String.class, java.lang.String.class, java.lang.String.class
    };
    
    public ProgramTableModel(ArrayList<Program> programs){
        programList = programs;
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
        return programList.size();
    }
 
    @Override
    public Object getValueAt(int rowIndex, int columnIndex)
    {
        Program row = programList.get(rowIndex);
        if(0 == columnIndex) {
            return row.eventName;
        }
        else if(1 == columnIndex) {
            return row.speakerProgram;
        }
        else if(2 == columnIndex) {
            return row.location;
        }
        else if(3 == columnIndex) {
            return row.dateOfEvent;
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
        Program row = programList.get(rowIndex);
        if(0 == columnIndex) {
            row.eventName = (String) aValue;
        }
        else if(1 == columnIndex) {
            row.speakerProgram = (String) aValue;
        }
        else if(2 == columnIndex) {
            row.location = (String) aValue;
        }
        else if(3 == columnIndex) {
            row.dateOfEvent = (String) aValue;
        }
    }
    
    
    public void removeRow(int rowIndex){
        Program row = programList.get(rowIndex);
        programList.remove(row);
        fireTableDataChanged();
    }
    public Program getRowValue(int rowIndex){
         return programList.get(rowIndex);
     }
}
