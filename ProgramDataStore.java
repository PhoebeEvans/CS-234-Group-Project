import java.util.ArrayList;


/**
 *
 * @author jacqu
 */
public class ProgramDataStore {
    
    
    
    
    public static ArrayList<Program> Programs = new ArrayList<>();
   
    //dummy data that is initialized when program runs
    public static void init(){
        Programs.add(new Program("Elliot Graham", "Hello", "10/10/2023", "Kids Section", new ArrayList<>()));
        Programs.add(new Program("Nancy Reed", "Let's Paint", "01/23/2023", "Crafts and Arts Section", new ArrayList<>()));
        Programs.add(new Program("Jason Martinez", "Movie Night", "12/4/2022", "Main Lobby", new ArrayList<>()));
        Programs.add(new Program("Caitlyn Jones", "Sculpting class", "11/12/2022", "Crafts and Arts Section", new ArrayList<>()));
        
    }
     
    
        
       
    //add employee method
    public static void addProgram(String speakerProgram, String eventName, String dateOfEvent, String location, ArrayList patrons){
        Programs.add(new Program(speakerProgram, eventName, dateOfEvent, location, patrons));
    }
   
    //index starts at -1 in order to tell if i was found 
    //if index was found, it will remove the object at that index
    public static void removeProgram(String eventName){
        int index = -1;
        for (int i = 0; i < Programs.size(); i++ ){
            if (Programs.get(i).eventName.equals(eventName)){
                index = i;
                break;
                
            }
        }
         if(index != -1){
            Programs.remove(index);
        }
    }
    
        
    //search employee by ID method 
    public static Program searchProgrambyName(String eventNameNew){
        for (Program program : Programs){
            if (program.eventName.equals(eventNameNew)){
                return program;
            }
        }
        return null;
        
    }
      public static Program searchProgrambydate(String dateOfEvent){
        for (Program program : Programs){
            if (program.dateOfEvent.equals(dateOfEvent)){
                return program;
            }
        }
        return null;
        
    }
        

    public static void viewPrograms(){
        System.out.println(Programs);
    }
}


