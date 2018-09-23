package EmployeeDB;

/** This method will manage the employee number data
 * 
 * @param: employeeNum is the employee number, and is a string
 * because it will not be used in calculations
 * 
 * @author Candace Holcombe-Volke
 *
 */
public class EmployeeNum
{
    // Employee Number
    private String employeeNum; 

    public EmployeeNum( String employeeNum )
    {
        employeeNum = " ";       
    }
    
    
    public String toString()
    {
        return "Employee Number: " + this.employeeNum;
    }
    
    
    // Get employee number
    public String getEmployeeNum()
    {
        return this.employeeNum;
    }
    
    // Set employee number
    public void setEmployeeNum( String employeeNum )
    {
        this.employeeNum = employeeNum; 
    }
}
