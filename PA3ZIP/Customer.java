/* Author: Charlton Cohen
 * Class Customer.java
 * PA3
 */
public class Customer 
{
//instance variables
  private String custId;//Unique customer id (7 digits > 10000)
  private String custLastName;//Customer last name (no null or spaces)
  private String custFirstName;//Customer first name (no null or spaces)

  private String custTaxId;//Customer tax id (9 digits)
  
  public Customer()
  {
    custId = "9999999";
    custLastName = "Invalid";
    custFirstName = "Invalid";
    custTaxId = "999999999";
  }//END Customer
  
  public Customer(String id, String last, String first, String tax) 
    throws CustomerException
  {
    try
    {
      setCustId(id);
      setCustLastName(last);
      setCustFirstName(first);
      setCustTaxId(tax);
    }//END try
    catch(CustomerException xcptn)
    {
      String oldMsg = xcptn.getMessage();
      String newMsg = String.format("%ncustId: %s%ncustLastName: %s%ncusFirstName: %s%n"+
                                    "cusTaxId: ",
                                    id,
                                    last,
                                    first,
                                    tax);
      throw new CustomerException( oldMsg + newMsg, xcptn);
    }//END catch 
  }//END Customer
  
  public final void setCustId(String id)
    throws CustomerException
  {
    if(id.length() == 7 && Integer.parseInt(id) > 10000)
    {
      custId = id;
    }
    else
    {
      throw new CustomerException("DATA VALIDATION: The id provided must be 7 digits and be greater than 10,000.");
    }
  }//END setCustId
  
  public final void setCustLastName(String last)
    throws CustomerException
  {
   if(last != "null" && last.matches("^(\\s){7}"))
   {
    custLastName = last;
   }
   else
   {
     throw new CustomerException("DATA VALIDATION: ");
   }
  }//END setCustLastName
  
  public final void setCustFirstName(String first)
    throws CustomerException
  {
    if(first != "null" && first.matches("^(\\s){7}"))
    {
    custFirstName = first;
    }
    else
    {
      throw new CustomerException("DATA VALIDATION");
  }
  }//END setCustFirstName
  
  public final void setCustTaxId(String tax)
    throws CustomerException
  {
    if(tax.length() == 9)
    {
    custTaxId = tax;
    }
    else
    {
     throw new CustomerException("DATA VALIDATION");
    }
  }//END setCustTaxId
  
  public final String getCustId()
  {
    return custId;
  }//END getCustId
  
  public final String getCustLastName()
  {
    return custLastName;
  }//END getCustLastName
  
  public final String getCustFirstName()
  {
    return custFirstName;
  }//END getCustFirstName
  
  public final String getCustTaxId()
  {
    return custTaxId;
  }//END getCustTaxId
}//END Customer Class
