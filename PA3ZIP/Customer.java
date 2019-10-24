public class Customer 
{
  
  private String custId; //unique id for customer, 7 digits, value must be > 100000
  private String custLastName; //customer last name, cant be null or spaces
  private String custFirstName; //customer first name, cant be null or spaces
  private String custTaxId; // customer TaxId; 9 digits long
  
  public Customer()
  {
    custId = "9999999";
    custLastName = "Invalid";
    custFirstName = "Invalid";
    custTaxId = "999999999";
    
  } // end Customer
  
  public Customer(String id, String last, String first, String tax) 
    throws CustomerException
  {
    try
    {
      setCustId(id);
      setCustLastName(last);
      setCustFirstName(first);
      setCustTaxId(tax);
    }// end try
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
    }// end catch
    
  } // end Customer
  
  public final void setCustId(String id)
    throws CustomerException
  {
    if(id.length()==7 && id )
    {
      custId = id;
    }
    else
    {
      throw new CustomerException("DATA VALIDATION: The id provided is over 7 digits");
    }
  } // end setCustId
  
  public final void setCustLastName(String last)
  {
   if(last)
   {
    custLastName = last;
   }
   else
   {
     throw new CustomerException("DATA VALIDATION");
  } // end setCustLastName
  
  public final void setCustFirstName(String first)
  {
    if(first)
    {
    custFirstName = first;
    }
    else
    {
      throw new CustomerException("DATA VALIDATION");
  }
  }// end setCustFirstName
  
  public final void setCustTaxId(String tax)
  {
    if(tax)
    {
    custTaxId = tax;
    }
    else
    {
     throw new CustomerException("DATA VALIDATION")
    }
  }// end setCustTaxId
  
  public final String getCustId()
  {
    return custId;
  } // end getCustId
  
  public final String getCustLastName(){
    return custLastName;
  } // end getCustLastName
  
  public final String getCustFirstName()
  {
    return custFirstName;
  } // end getCustFirstName
  
  public final String getCustTaxId()
  {
    return custTaxId;
  }//end getCustTaxId
  
  
} // end Customer Class
                                 
