/*
 * Author: Charlton Cohen
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
    custLastName = "INVALID";
    custFirstName = "INVALID";
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
      String newMsg = String.format("%ncustId: %s%ncustLastName: %s%ncusFirstName: %s%ncusTaxId: %s%n",
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
      throw new CustomerException("DATA VALIDATION: offered values for custID must consist of 7 digits; the integer value represented be the String" +
                                  "must be greater than 10000");
    }
  }//END setCustId
  
  public final void setCustLastName(String last)
    throws CustomerException
  {
   if(last == null || last.trim().length() == 0)
    {
      throw new CustomerException("DATA VALIDATION: the offered String may not be null or all spaces");
    }
    else
    {
      custLastName = last;
   }//END if statement
  }//END setCustLastName
  
  public final void setCustFirstName(String first)
    throws CustomerException
  {
    if(first == null || first.trim().length() == 0)
    {
      throw new CustomerException("DATA VALIDATION: the offered String may not be null or all spaces");
    }
    else
    {
      custFirstName = first;
  }//END if statement
  }//END setCustFirstName
  
  public final void setCustTaxId(String tax)
    throws CustomerException
  {
    if (tax.matches("[0-9]+") && tax.length() == 9)
    {
      custTaxId = tax;
    }
    else
    {
      throw new CustomerException("DATA VALIDATION: the offered value must be all digits, and exactly 9 digits long");
    }//END if statement
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
  
  public String toString()
  {
    return String.format("Customer Id %s belongs to %s %s, tax reporting id: %s.",
                         getCustId(),
                         getCustFirstName(),
                         getCustLastName(),
                         getCustTaxId());
  }//END toString
}//END Customer Class
