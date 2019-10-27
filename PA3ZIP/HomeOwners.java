/* Author: Brandon Stevenson
 * Class Policy Subclass - HomeOwners.java
 * PA3
 */


public class HomeOwners extends Policy
{
  //instance variables
  private final double EXPOSURE_RATE = 0.0025;//CONSTANT VALUE representing the current exposure rate
  private String homePropAddress;//Legal address of the insured policy
  private int homePropType;//code describing a property type
  private int homeStructure;//Structural coverage limit
  private int homeContents;//Contents limit
  private double homeDeductible;//Percentage of total insured value
  private boolean umbrella;//Indication if the policy is covered under umbrella
  
  //Constructors
  public HomeOwners()
  {
    super();//Call to super null
  }//Null constructor
  
  public HomeOwners(String own,
                    String insd,
                    String nbr,
                    double prem,
                    String addr,
                    int type,
                    int struct,
                    int goods,
                    double ded,
                    boolean umbr)
    throws PolicyException
  {
    try
    {
    
      super.setPolOwner(own);
      super.setPolInsured(insd);
      super.setPolNumber(nbr);
      super.setPolPremium(prem);
      //Call to super full constructor
    
    setHomePropAddress(addr);
    setHomePropType(type);
    setHomeStructure(struct);
    setHomeContents(goods);
    setHomeDeductible(ded);
    setUmbrella(umbr);
    }//end try block
    catch(PolicyException xcptn)
    {
      String oldMsg = xcptn.getMessage();
      
      String newMsg = String.format("%nHomePropAddress: %s%nHomePropType: %d%nHomeStructure: "+
                                    "%d%nHomeContents: %d%nHomeDeductible: %f%nUmbrella: %s%n",
                                    homePropAddress,
                                    homePropType,
                                    homeStructure,
                                    homeContents,
                                    homeDeductible,
                                    umbrella);
      throw new PolicyException( oldMsg + newMsg, xcptn);
    }//end catch block
  }//end full constructor
  
  /*
   * Set Methods for Homeowners
   */
  public final void setHomePropAddress(String addr)
  {
    homePropAddress = addr;
  }//END setHomePropAddress
  
  public final void setHomePropType(int type)
    throws PolicyException
  {
    if(type >= 1 && type <= 4)
    {
      homePropType = type;
    }
    else
    {
    homePropType = 1;
    throw new PolicyException("DATA VALIDATION: Only values 1-4 (inclusive) are acceptable"+
                              ",and other value offered should be replaced with a value of 1");
    }
  }//END setHomePropType
  public final void setHomeStructure(int struct)
    throws PolicyException
  {
    if( struct >= 50 && struct <= 5000) 
    {
      homeStructure = struct;
    }
    
      else
      {
        throw new PolicyException("DATA VALIDATION: The value offered must be greater than 50 and less than 5000 (inclusive)");
      }
  
  }//END setHomeStructure
  public final void setHomeContents(int goods)
    throws PolicyException
  {
    if( goods >= 5 && goods <= 500) 
    {
      homeContents = goods;
    }
    
      else
      {
        throw new PolicyException("DATA VALIDATION: The value offered must be greater than 5 and less than 500 (inclusive)");
      }
  
  }
  public final void setHomeDeductible(double ded)
    throws PolicyException
  {
    if( ded >= 0.01 && ded <= 0.10) 
    {
      homeDeductible = ded;
    }
    
      else
      {
        throw new PolicyException("DATA VALIDATION: The value offered must be greater than 0.01 and less than 0.10 (inclusive)");
      }
  
  }//END setHomeDeductible
  public final void setUmbrella(boolean umbr)
  {
    umbrella = umbr;
  }
//end set methods
  
  /*
   * get Methods
   */
  public final String getHomePropAddress()
  {
    return homePropAddress;
  }
  public final int getHomePropType()
  {
    return homePropType;
  }
  public final int getHomeStructure()
  {
    return homeStructure;
  }
  public final int getHomeContents()
  {
    return homeContents;
  }
  public final double getHomeDeductible()
  {
    return homeDeductible;
  }
  public final boolean getUmbrella()
  {
    return umbrella;
  }
//end get methods
  
  public final double getDeductibleInDollars()//method that calculates the dollar value of the deductible
  {
    return (( getHomeStructure() + getHomeContents()) * 1000 * getHomeDeductible());
  }
  
  /*****************************************************************************
    * Interface Methods
    * **************************************************************************/
  public double calcExposure()
  {
    return (getHomeStructure() + getHomeContents()) * 1000;
  }
  public double calcCurrentValue()
  {
    return getPolPremium() - (calcExposure() * EXPOSURE_RATE);
  }
  
  public String toString()
  {
    String str = String.format("%s%nThis %s policy insures type %d home at %s. The structure is insured" +
                               " for $%,d.00; contents for $%,d.00. The deductible is $%,.2f ",
                               super.toString(),
                               getClass().getSimpleName(),
                               getHomePropType(),
                               getHomePropAddress(),
                               getHomeStructure()*1000,
                               getHomeContents()*1000,
                               getDeductibleInDollars());
    if (getUmbrella())
    {
      str += "This policy is part of an Umbrella contract.";
    }
    else
    {
      str += "This policy is not part of an Umbrella contract.";
    }
    return str;                     
  }
}




                        
                         
                         
    
    
    
    
    
    
    
