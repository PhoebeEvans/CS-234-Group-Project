
import java.io.*;
import java.util.ArrayList;
import java.io.IOException;
import java.io.File;

/**
 *
 * @author jacqu
 */
public class Programclass {

    public static void main(String[] args) {
        File programSave = new File("Programs.ser");
        if(programSave.exists()){
        try{
            FileInputStream readData = new FileInputStream("Programs.ser");
            ObjectInputStream readStream = new ObjectInputStream(readData);
            ArrayList Programs = (ArrayList<Program>) readStream.readObject();
            readStream.close();
            System.out.println(Programs.toString());
        }
        catch (IOException | ClassNotFoundException e){
            e.printStackTrace();
            System.out.println("There was a problem loading saved data.");
            }
        }
        else{
                ProgramDataStore.init();
                }
        
        ProgramMenu.MainMenu();
        
        try{
            FileOutputStream writeData = new FileOutputStream("Programs.ser");
        ObjectOutputStream writeStream = new ObjectOutputStream(writeData);

        writeStream.writeObject(ProgramDataStore.Programs);
        writeStream.flush();
        writeStream.close();
    }
        catch (IOException e){
            e.printStackTrace();
            System.out.println("There was a problem saving program data and changes were not recorded.");
        }
   
    
     }
   
 }



