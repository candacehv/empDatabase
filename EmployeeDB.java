package EmployeeDB;

/** This method holds the array that stores the employee
 * information and also has the main method.
 *  
 * @author Candace Holcombe-Volke
 *
 */
import java.util.Scanner;

public class EmployeeDB
{
    /**
     * This method is should store the Employee array of newly ntered info
     * @param numbNewEntries
     */
    public EmployeeDB( int numbNewEntries )
    {
        int n = 0; // Number of new entries to be added
    }
    
    // Somehow get the info into a string to store it?
    //private String[][] employee = new String[][12];
    //employee[n][] = { emplFirst, emplLast, add1, street, add2, city, 
    //state, zipcode, hireDate, hireMonth, hireYear};

    
    
    
    
    /**
     * The main method collects user input at is supposed to save the 
     * data in an arr
     * 
     * @param instance String variables first, last, emplNum, add1, 
     * street, add2, city, state, zipcode
     * @param hireDate, hireMonth, hireYear, are integers
     */
    public static void main( String [] args)
    {
       
        Scanner input = new Scanner( System.in ); 
        System.out.println("How many new emplyees? ");
        int n = input.nextInt();
        
        //int i = 0; 
        
        //for (i = 0; i < n; i++)
    
        System.out.println("Enter employee first name: ");
        String first = input.nextLine();
        String next2 = input.nextLine();
        
        System.out.println("Enter employee last name: ");
        String last = input.nextLine();
        
        System.out.println("Enter Employee Number: ");
        String emplNum = input.nextLine();
        
        System.out.println("Enter Address Number: ");
        String add1 = input.nextLine();
        
        System.out.println("Enter street name: ");
        String street = input.nextLine();
        
        System.out.println("Enter apartment number: ");
        String add2 = input.nextLine();
        
        System.out.println("Enter city: ");
        String city = input.nextLine();
        
        System.out.println("Enter state as two digit state code: ");
        String state = input.nextLine();
        
        System.out.println("Enter 5 digit zipcode: ");
        String zipcode = input.nextLine();
        
        System.out.println("Enter hire day (1-31): ");
        int hireDate = input.nextInt();
        
        System.out.println("Enter month of hire (1-12): ");
        int hireMonth = input.nextInt();
        
        System.out.println("Enter year of hire (YYYY) ");
        int hireYear = input.nextInt();
        
        
        
        // Create instance classes to be accessed by static main method
        Name name = new Name( first, last );
        EmployeeNum employeeNum = new EmployeeNum( emplNum );
        Address address = new Address( add1, add2, street, city, 
            state, zipcode );
        Date date = new Date( hireDate, hireMonth, hireYear );
        //EmployeeDB employeeDB = new EmployeeDB( n );
        
        
        // Use setter methods to assign inputs
        name.setEmplFirst( first );
        name.setEmplLast( last );
        employeeNum.setEmployeeNum( emplNum);
        address.setAddress1( add1 );
        address.setAddress2( add2 );
        address.setStreet( street);
        address.setCity(city);
        address.setState(state);
        address.setZipcode(zipcode);
        date.setHireDate(hireDate);
        date.setHireMonth(hireMonth);
        date.setHireYear(hireYear);
        
        System.out.println( name + " " + employeeNum + " " + address
            + " " + date );
    
    } 
} // End of EmployeeDB