
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
    
        String speakerProgram;
        String eventName;
        String dateOfEvent;
        String location;
        public ArrayList<String> Patrons = new ArrayList<>();
    
        public Program(String _speakerProgram, String _eventName, String _dateOfEvent, String _location, ArrayList _Patrons) {
            speakerProgram = _speakerProgram;
            eventName = _eventName;
            dateOfEvent = _dateOfEvent;
            location = _location;
            Patrons = _Patrons;
    
        }
      
        @Override
        public String toString() {
            System.out.println("~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~");
            String output = "{" + speakerProgram + ", " + eventName + ", " + dateOfEvent
                    + ", " + location + "}\n";
            return output;
        }
    
        public void addPatron(String patronName) {
    
            Patrons.add(patronName);
        }
    
        public void removePatron(String removeName) {
    
            int index = Patrons.indexOf(removeName);
            Patrons.remove(index);
    
        }
    
        
            
    }
        

