/**
 * Policy Class
 * Superclass of HomeOwners & Auto
 * Implements interface BookValue
 */
public abstract class Policy implements BookValue{
  
  private String polOwner; // Customer identifier that is seven digits long and int value must be > 10,000
  private String polInsured; // Full, legal name of named insured on policy
  private String polNumber; // Unique identifier for specific policy
  private double polPremium; // Annual premium amount for policy
  
  public static Policy grpPolicy[] = new Policy[6]; // array of Policy members
  
  public Policy()
  {
    
  } // end null constrictor Policy
  
  public Policy(String own, String insd, String nbr, double prem)
    throws PolicyException
  {
    try
    {
    setPolOwner(own);
    setPolInsured(insd);
    setPolNumber(nbr);
    setPolPremium(prem);
    }
    catch(PolicyException xcptn)
    {
      String oldMsg = xcptn.getMessage();
      
      String newMsg = String.format("yo");
      
      throw new PolicyException( oldMsg + newMsg, xcptn);
    } // end catch PolicyException
  }
  
  public final String identifyContract(){
    return polNumber;
  } // end identifyContract
  
  public final void setPolOwner(String own)
   throws PolicyException
  {
    if(own.length()==7 && Integer.parseInt(own)>100000){
      polOwner = own;}
    else
    {
      throw new PolicyException("die");
    }
  } // end setPolOwner
  public final void setPolInsured(String insd)
  {
    polInsured = insd;
  } // end setPolInsured
  public final void setPolNumber(String nbr)
    throws PolicyException
  {
    if(nbr.length()==7 && nbr.matches("([A-Z])+\\d{5}")){
      polNumber = nbr;}
    else
    {
      throw new PolicyException("die");
    }
  } // end setPolNumber
  public final void setPolPremium(double prem)
    throws PolicyException
  {
    if(prem > 0){
      polPremium = prem;}
    else
    {
      throw new PolicyException("no");
    }
  } // end setPolPremium

  public final String getPolOwner()
  {
    return polOwner;
  } // end getPolOwner
    public final String getPolInsured()
  {
    return polInsured;
  } // end getPolInsured
public final String getPolNumber()
{ 
  return polNumber;
} // end getPolNumber
public final double getPolPremium()
{
  return polPremium;
} // end getPolPremium

public String toString()
{
  return String.format("%n%s owns Policy %s, insuring %s, with a premium of %.2f", getPolOwner(), 
                       getPolNumber(),  getPolInsured(), getPolPremium());
} // end toString
  
} // end class Policy
