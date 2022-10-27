import java.util.Scanner;
/**
 *
 * @author jacqu
 */
public class EmployeeMenu {

    public static void MainMenu() {

        PrintEmployeeMenu();
        Scanner input = new Scanner(System.in);
        int command;
        command = input.nextInt();

        while (command != 6) {
            switch (command) {

                case 1:
                    System.out.println("Please enter the Employee ID number for the employee: ");
                    String IdNumber = input.next();
                    System.out.println("Please enter the yearly salary for the employee: ");
                    double salary = input.nextDouble();
                    System.out.println("Please enter t007he position of the employee: ");
                    String position = input.next();
                    System.out.println("Please enter the name of the employee: ");
                    String Fullname = input.next();
                    System.out.println("Please enter the date of birth of the employee(numbers only): ");
                    int dateOfBirth = input.nextInt();
                    System.out.println("Please enter the complete address of the employee: ");
                    String fullAdress = input.next();
                    System.out.println("Please enter the phone number of the employee: ");
                    String phonenumber = input.next();
                    System.out.println("Please enter the number of hours the employee works a week: ");
                    int hoursWeekly = input.nextInt();
                    EmployeeDataStore.addEmployee(hoursWeekly, IdNumber, salary, position, Fullname, dateOfBirth, fullAdress, phonenumber);
                    EmployeeDataStore.viewEmployees();
                    break;
                //exit

                case 2:
                    System.out.println("Please choose a way to search the employee");
                    System.out.println("1.- Search by name");
                    System.out.println("2.- Search by employee ID number");
                    System.out.println("3.- Search by position");
                    System.out.println("4.- Exit to main menu");

                    int search = input.nextInt();
                    while (search != 4) {
                        switch (search) {

                            case 1:
                                System.out.println("Please enter the name of the employee");
                                String nameEmployee = input.next();
                                Employee searchedEmployee = EmployeeDataStore.searchEmployeeByname(nameEmployee);
                                //print that employee
                                System.out.println(searchedEmployee);
                                break;
                            case 2:
                                System.out.println("Please enter the employee ID number of the employee");
                                String employeeID = input.next();
                                Employee searched = EmployeeDataStore.searchEmployeeById(employeeID);
                                //print that employee
                                System.out.println(searched);
                                break;

                            case 3:
                                System.out.println("Please enter the position of the employee");
                                String employeeposition = input.next();
                                Employee Employee = EmployeeDataStore.SearchEmployeeByPosition(employeeposition);
                                //print that employee
                                System.out.println(Employee);
                                break;
                        }
                    }

                //exit
                case 3:
                    System.out.println("Please enter the name of the employee you want to edit:");
                    String nameEmp = input.next();
                    Employee searchedEmployee = EmployeeDataStore.searchEmployeeByname(nameEmp);
                    //print that employee
                    System.out.println(searchedEmployee);
                    System.out.println("Please choose what you would like to edit: ");
                    System.out.println("1.- Name of employee");
                    System.out.println("2.- Hours worked of employee");
                    System.out.println("3.- Salary of employee");
                    System.out.println("4.- Position of employee");
                    System.out.println("5.- Address of employee");
                    System.out.println("6.- Phone number of employee");
                    System.out.println("7.- Exit");
                    int option = input.nextInt();
                    while (option != 7) {
                        switch (option) {
                            case 1:
                                System.out.println("Please enter the updated name of the employee: ");
                                String newName = input.next();
                                searchedEmployee.name = newName;
                                System.out.println(searchedEmployee);
                                break;
                            case 2:
                                System.out.println("Please enter the updated hours worked of employee: ");
                                int newHours = input.nextInt();
                                searchedEmployee.hoursWorked = newHours;
                                System.out.println(searchedEmployee);
                                break;
                            case 3:
                                System.out.println("Please enter the new salary of the employee: ");
                                double newSalary = input.nextDouble();
                                searchedEmployee.salary = newSalary;
                                System.out.println(searchedEmployee);
                                break;
                            case 4:
                                System.out.println("Please enter the new position of the employee: ");
                                String newPosition = input.next();
                                searchedEmployee.position = newPosition;
                                System.out.println(searchedEmployee);
                                break;
                            case 5:
                                System.out.println("Please enter the new address of the employee: ");
                                String newAddress = input.next();
                                searchedEmployee.address = newAddress;
                                System.out.println(searchedEmployee);
                                break;
                            case 6:
                                System.out.println("Please enter the new phone number of the employee: ");
                                String newPhonenumber = input.next();
                                searchedEmployee.phoneNumber = newPhonenumber;
                                System.out.println(searchedEmployee);
                                break;
                        }
                    }

                case 4:
                    System.out.println("Please enter a way to delete an employee: ");
                    System.out.println("1.- Delete an employee by ID number");
                    System.out.println("2.- Delete an employee by name");
                    System.out.println("3.- Exit to main menu");

                    int decision = input.nextInt();
                    while (decision != 3) {
                        switch (decision) {
                            case 1:
                                System.out.println("Please enter the ID of the employee: ");
                                String idNumber = input.next();
                                EmployeeDataStore.removeEmployee(idNumber);
                                EmployeeDataStore.viewEmployees();
                                break;

                            case 2:
                                System.out.println("Please enter the name of the employee: ");
                                String nameEmployee = input.next();
                                EmployeeDataStore.removeEmployeebyName(nameEmployee);
                                EmployeeDataStore.viewEmployees();
                                break;

                        }

                    }
                    break;
                //if 3 exit to main menu

                case 5:
                    for (Employee employee : EmployeeDataStore.Employees) {
                        System.out.print(employee);
                    }
            }

            //Get new command before next loop iteration
            PrintEmployeeMenu();
            command = input.nextInt();
        }
    }

    public static void PrintEmployeeMenu() {
        System.out.println("Please make a selection: ");
        System.out.println("1.- Add employee");
        System.out.println("2.- Search Employee");
        System.out.println("3.- Edit employee");
        System.out.println("4.- Remove an Employee");
        System.out.println("5.- Print payroll report");
        System.out.println("6.- Exit program");
    }
}
