package EmployeeDB;




/** This class manages the address data for employees
 * 
 * @param: address 1, address 2, street, city, state, zipcode are private
 * string variables. 
 * 
 * @author Candace Holcombe-Volke
 */
public class Address 
{
    private String address1; 
    private String address2;  // for apartment and suite numbers
    private String street;
    private String city;
    private String state;  // two digit
    private String zipcode;  // 5 digit
    
    // This is the constructor for the instance variables
    public Address( String address1, String address2, String street, 
        String city, String state, String zipcode)
    {
        address1 = " ";
        address2 = " ";
        street   = " ";
        city     = " ";
        state    = " ";
        zipcode  = " ";
    }
    
    
    public String toString()
    {
        return "Address: " + this.address1 + " " + this.street + " " + 
            this.address2 + " " + this.city + ", " + this.state + " " + 
            this.zipcode;
    }

    
    // Get address1
    public String getAddress1()
    {
        return this.address1;
    }
    
    // Get address2
    public String getAddress2()
    {
        return this.address2;
    }    
    
    // Get street
    public String getStreet()
    {
        return this.street;
    }
    
    // Get city
    public String getCity()
    {
        return this.city;
    }
    
    // Get state
    public String getState()
    {
        return this.state;
    }
    

    // Set address1
    public void setAddress1( String address1 )
    {
        this.address1 = address1;
    }
    
    // Set address2
    public void setAddress2( String address2)
    {
        this.address2 = address2;
    }    
    
    // Set street
    public void setStreet( String street)
    {
        this.street = street;
    }
    
    // Set city
    public void setCity( String city)
    {
        this.city = city;
    }
    
    // Set state
    public void setState( String state)
    {
        if(state.length() == 2)
            {
                this.state = state;
            }
        else
        {
            System.out.println("Error: Use the two digit state code.");
        }
    }
    
    // Set zipcode
    public void setZipcode( String zipcode )
    {
        if(zipcode.length() == 5)
        {
            this.zipcode = zipcode;
        }
    }
}
