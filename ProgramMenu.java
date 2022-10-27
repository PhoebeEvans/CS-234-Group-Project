
    import java.util.Scanner;
    
    import java.util.ArrayList;
    
    /**
     *
     * @author jacqu
     */
    public class ProgramMenu {
    
        public static void MainMenu() {
            PrintMainMenuProgram();
            Scanner input = new Scanner(System.in);
            int command;
            command = input.nextInt();
            while (command != 6) {
                switch (command) {
                    case 1:
                        System.out.println("Please enter the name of the event: ");
                        String nameOf = input.next();
                        System.out.println("Please enter the speaker of the event: ");
                        String speakr = input.next();
                        System.out.println("Please enter the date of the event in the format MM/DD/YYYY : ");
                        String date = input.next();
                        System.out.println("Please enter the location of the event: ");
                        String location = input.next();
                        System.out.println("Please enter the names of the patrons attending");
                        String patron = input.next();
                        ArrayList<String> patrons = new ArrayList<>();
                        patrons.add(patron);
                        ProgramDataStore.addProgram(speakr, nameOf, date, location, patrons);
    
                        break;
    
                    case 2:
                        System.out.println("Please select a way to search for a Program: ");
                        System.out.println("1. Search by name of event");
                        System.out.println("2. Search by date of event");
                        System.out.println("3. Exit");
                        int choice = input.nextInt();
                        while (choice != 3) {
                            switch (choice) {
                                case 1:
                                    System.out.println("Please enter the name of the event: ");
                                    String nameProgram = input.next();
                                    Program searchedProgramByName = ProgramDataStore.searchProgrambyName(nameProgram);
                                    //print that employee
                                    System.out.println(searchedProgramByName);
                                    break;
                                case 2:
                                    System.out.println("Please enter the date of the event: ");
                                    String dateOf = input.next();
                                    Program searchedProgrambydate = ProgramDataStore.searchProgrambydate(dateOf);
                                    System.out.println(searchedProgrambydate);
                                    break;
                                default:
                                    break;
                                    
                               
                            }
    
                        }
                    case 3:
                        System.out.println("Please enter the name of the program you want to edit:");
                        String nameEvent = input.next();
                        Program searchedEvent = ProgramDataStore.searchProgrambyName(nameEvent);
                        //print that program
                        System.out.println(searchedEvent);
                        System.out.println("Please choose what you would like to edit: ");
                        System.out.println("1.- Name of event");
                        System.out.println("2.- Speaker of event");
                        System.out.println("3.- Date of Event");
                        System.out.println("4.- Location of event");
                        System.out.println("5.- Add a patron attending");
                        System.out.println("6.- Remove a patron from attending");
                        System.out.println("7.- Exit");
                        int option = input.nextInt();
                        while (option != 7) {
                            switch (option) {
                                case 1:
                                    input.nextLine();
                                    System.out.println("Please enter the new name of the event: ");
                                    String newName = input.nextLine();
                                    searchedEvent.eventName = newName;
                                    System.out.println(searchedEvent);
                                    break;
                                case 2:
                                    input.nextLine();
                                    System.out.println("Please enter the new speaker of the event: ");
                                    String newSpeaker = input.nextLine();
                                    searchedEvent.speakerProgram = newSpeaker;
                                    System.out.println(searchedEvent);
                                    break;
                                case 3:
                                    System.out.println("Please enter the new date of the event(Please enter the date in the format MM/DD/YYYY)");
                                    String newDate = input.next();
                                    searchedEvent.dateOfEvent = newDate;
                                    System.out.println(searchedEvent);
                                    break;
                                case 4:
                                    input.nextLine();
                                    System.out.println("Please enter the new location of the event: ");
                                    String newLocation = input.nextLine();
                                    searchedEvent.location = newLocation;
                                    System.out.println(searchedEvent);
                                    break;
                                case 5:
                                    input.nextLine();
                                    System.out.println("Please enter the name of the Patron you would like to add");
                                    String newPatron = input.nextLine();
                                    searchedEvent.addPatron(newPatron);
                                    System.out.println(searchedEvent);
                                    break;
                                case 6:
                                    input.nextLine();
                                    System.out.println("Please enter the name of the patron you want to remove: ");
                                    String removeName = input.nextLine();
                                    searchedEvent.removePatron(removeName);
                                    System.out.println(searchedEvent);
                                    break;
                                default: 
                                    break;
                             
    
                            }
                        }
                    case 4:
                        System.out.println("Please enter the name of the Program you wish to delete: ");
                        String eventName = input.next();
                        ProgramDataStore.removeProgram(eventName);
                        for (Program program : ProgramDataStore.Programs) {
                            System.out.print(program);
                        }
                        
                        break;
    
                    case 5:
                        for (Program program : ProgramDataStore.Programs) {
                            System.out.print(program);
                        }
                        break;
                        
                 
                }
                
                        
                    PrintMainMenuProgram();
                    command = input.nextInt();
                   
                    
    
                
            }
        }
    
        public static void PrintMainMenuProgram() {
            System.out.println("Please make a selection: ");
            System.out.println("1.- Add Program");
            System.out.println("2.- Search Program");
            System.out.println("3.- Edit Program");
            System.out.println("4.- Remove a Program");
            System.out.println("5.- Print Program report");
            System.out.println("6.- Exit program");
        }
    
    }
     

