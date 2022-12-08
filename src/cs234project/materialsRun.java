/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package cs234project;

import java.io.FileNotFoundException;

/**
 *
 * @author phoeb
 */
public class materialsRun{

    /**
     *
     */
    private int materialType;
    
    public void materialTypeSet(int materialType){
        this.materialType = materialType;
    }
    
    public void set(){
        
        materialTypeSet(materialType);
    }

    /**
     *
     * @throws FileNotFoundException
     */
    /*public moviesGUI() throws FileNotFoundException{
        /*System.out.println("hello");
        setmaterialType(2);
        System.out.println("set type 2");*
        
        
    }*/
    public void materialsRun() throws FileNotFoundException{
        
        set();
        materialsGUI m = new materialsGUI(materialType);
        m.runMaterial(materialType);
    }
     
    
    
}
