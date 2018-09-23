package EmployeeDB;


/** This method will manage all employee name data as well as main method
 * @param: emplFirst is the employee's first name, a string
 * @param: emplLast is the employee's last name, a string
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class Name 
{
    private String emplFirst;
    private String emplLast;
    
    
    public Name( String first, String last )
    {
        emplFirst = " ";
        emplLast  = " "; 
    }
    
    
    // Use toString for print ability
    public String toString()
    {
        return "Name: " + this.emplFirst + " " + this.emplLast;
    }
    

    // Get employee first name
    public String getEmplFirst( String emplFirst )
    {
        return this.emplFirst;
    }
    
    // Set employee first name
    public void setEmplFirst( String emplFirst )
    {
        this.emplFirst = emplFirst;
    }
    
        
    
    // Get employee last name
    public String getEmplLast()
    {
        return this.emplLast;
    }
    
    
    // Set employee last name
    public void setEmplLast( String emplLast )
    {
        this.emplLast = emplLast;
    }
}
