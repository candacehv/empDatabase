package EmployeeDB;


/** This class manages the hire date employee information
 * 
 * @ param: hireDate, hireMonth, and hireYear are private instance integers
 * preconditions: user input must be integers
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class Date 
{
    private int hireDate;
    private int hireMonth;
    private int hireYear; 
    
    // Variable constructor
    public Date(int hireDate, int hireMonth, int hireYear )
    {
        hireDate = 1; 
        hireMonth = 1; 
        hireYear = 1900;
    }
    
    
    public String toString()
    {
        return "Hire Date: " + hireDate +"/" + hireMonth + "/" + hireYear; 
    }
    

    // Get employee hire date number
    public int getHireDate()
    {
        return this.hireDate;
    }
    
    // Get employee hire month
    public int getHireMonth()
    {
        return this.hireMonth;
    }
    
    // Get employee hire year
    public int getHireYear()
    {
        return this.hireYear;
    }
    
    
    
    // Set hire date number
    public void setHireDate( int hireDate )
    {
        // Input data validation
        if( hireDate > 0 && hireDate < 32 )
            {
                this.hireDate = hireDate;
            }
        else
        {
            System.out.println("Error: Date must be between 1 and 31.");
        }
    }
    
    // Set hire month
    public void setHireMonth( int hireMonth )
    {
        // Input data validation
        if( hireMonth > 0 && hireMonth <13)
            {
                this.hireMonth = hireMonth;
            }
        else
        {
            System.out.println("Error: Month must be between 1 and 12.");
        }
    }
    
    // Set hire year
    public void setHireYear( int hireYear )
    {
        // Input data validation
        if( hireYear > 1899 && hireYear <2021)
            {
                this.hireYear = hireYear;
            }
        else
        {
            System.out.println("Error: Invalid year.");
        }
    }
}
