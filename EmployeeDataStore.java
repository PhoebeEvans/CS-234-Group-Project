
import java.util.ArrayList;

/**
 *
 * @author jacqu
 */
//store objects in ArrayList
public class EmployeeDataStore {
    public static ArrayList<Employee> Employees = new ArrayList<>();
    //dummy data that is initialized when program runs
    public static void init(){
        Employees.add(new Employee(40, "1007", 20000, "librarian", "Maria Ramos", 10011990, "1311 Sunrise Dr El Paso, Texas", "5552347060"));
        Employees.add(new Employee(40, "1008", 30000, "assistant manager", "Gabrielle Jones", 6181970, "2057 Oceanway Dr El Paso Texas", "5552095657"));
        Employees.add(new Employee(40, "1009", 40000, "manager", "Jessica Gonzales", 3131993, "3029 Hedgeway St El Paso Texas", "5555105110"));
        Employees.add(new Employee(40, "1010", 50000, "librarian", "Melissa Jackson", 12151995, "4056 Mountainview St El Paso Texas", "5555656556"));
        
    }   
    //add employee method
    public static void addEmployee(int hoursWorked, String employeeIdNumber, double salary, String position, String name, int dateOfBirth, String address, String phoneNumber){
        Employees.add(new Employee(hoursWorked, employeeIdNumber, salary, position, name, dateOfBirth, address, phoneNumber));
    }
   
    //index starts at -1 in order to tell if i was found 
    //if index was found, it will remove the object at that index
    public static void removeEmployee(String employeeIdNumber){
        int index = -1;
        for (int i = 0; i < Employees.size(); i++ ){
            if (Employees.get(i).employeeIdNumber.equals(employeeIdNumber)){
                index = i;
                break;
                
            }
        }
         if(index != -1){
            Employees.remove(index);
        }
    }
    public static void removeEmployeebyName(String name){
        int index = -1;
            for (int i = 0; i < Employees.size(); i++ ){
                if (Employees.get(i).name.equals(name)){
                     index = i;
                     break;
                
            }
        }
        if(index != -1){
            Employees.remove(index);
        }
    }
        
    //search employee by ID method 
    public static Employee searchEmployeeById(String employeeIdNumber){
        for (Employee employee : Employees){
            if (employee.employeeIdNumber.equals(employeeIdNumber)){
                return employee;
            }
        }
        return null;
        
    }
      public static Employee searchEmployeeByname(String name){
        for (Employee employee : Employees){
            if (employee.name.equals(name)){
                return employee;
            }
        }
        return null;
        
    }
        public static Employee SearchEmployeeByPosition(String position){
        for (Employee employee : Employees){
            if (employee.position.equals(position)){
                return employee;
            }
        }
         return null;
    }
       
        
       
    
    //view employees method 
    public static void viewEmployees(){
        System.out.println(Employees);
    }
}
