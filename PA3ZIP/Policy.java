/*@Application(1)Policy.java
 * @Author Brandon Stevenson
 * @Version 1.00 2019/09/17
 * 
 *This code is in regards to finding information on policys for annunity, homeowners, and auto insurance. 
 * This is done utilizing inheritance, with the class Policy acting as the superclass for HomeOwners and Auto subclasses.
 * Also a interface is used to for common abstract methods between classes. BookValue is implemented by Policy and Annuity.
 * Test_Policy_BookValue is the test harness to test this code.
 */

public abstract class Policy implements BookValue//Start Policy class
{
  
  /*
   * Instance Variables
   */
  private String polOwner;//Policy owner's full, legal name
  private String polInsured;//Full, legal name of named insured on policy
  private String polNumber;//Unique identifier for specific policy
  private double polPremium;//Annual premium amount for policy
  //end Instance Variables
  
  /*
   * Constructors
   */
  
  public Policy()//null constructor
  {
    
  }//end null constructor
  
  public Policy(String own,
                String insd,
                String nbr,
                double prem)//start full constructor
    throws PolicyException
  {
    try
    {
    setPolOwner(own);
    setPolInsured(insd);
    setPolNumber(nbr);
    setPolPremium(prem);
    }//end try block
    
    catch(PolicyException xcptn)
    {
      String oldMsg = xcptn.getMessage();
      
      String newMsg = String.format("%nOwner: %s%nInsured: %s%nNumber:"+
                                    "%s%nPremiem: %d%n",
                                    polOwner,
                                    polInsured,
                                    polNumber,
                                    polPremium);
 
      throw new PolicyException( oldMsg + newMsg,   //String Msg
                                xcptn);             //Exception cause
    }//end catch policyException
  }//end full constructor
  
  /*
   * set methods
   * Accepts a String  reference; and assigns references to instance variables
   */
  public final void setPolOwner(String own)
    throws PolicyException
  {
    if(own.length() == 7 && Integer.parseInt(own)>10000){ polOwner = own;}
       else
         {throw new PolicyException("DATA VALIDATION: String must be greater than 10000");}
       
  }
  public final void setPolInsured(String insd)
  {
    polInsured = insd;
  }
  public final void setPolNumber(String nbr)
    throws PolicyException
  {
    if(nbr.length() == 7 && nbr.matches("([A-Z])+\\s{5}"))
    {polNumber = nbr;}
    else
    {
      throw new PolicyException("DATA VALIDATION: Use a regular expression for this validation");}
  }
  
  public final void setPolPremium(double prem)
    throws PolicyException
  {
    if(prem > 0) {polPremium = prem;}
       else
         {throw new PolicyException("DATA VALIDATION: The value offered for must be greater than 0");}
  }
  //end set methods
  
  /*
   * get methods
   * Returns references to objects holding set methods
   */
  
  public final String getPolOwner()
  {
    return polOwner;
  }
  public final String getPolInsured()
  {
    return polInsured;
  }
  public final String getPolNumber()
  {
    return polNumber;
  }
 
  public final double getPolPremium()
  {
    return polPremium;
  }
  //end get methods
  
 
  
  public String identifyContract()
  {
    return getPolNumber();
  }//end indentifyContract
  //toString
  
  public String toString()
  {
    
    String toString;
   toString = String.format("%n%s owns Policy %s, insuring %s, with a premium of $%,.2f.",
                            getPolOwner(),
                            getPolNumber(),
                            getPolInsured(),
                            getPolPremium());
   return toString;
    
  }//end toString
}//end class
    
  