/**
 * HomeOwners Class
 * Homeowners is a subclass of Policy
 */
public class HomeOwners extends Policy{
  
  // local variables
  
  private double EXPOSURE_RATE = 0.0025; // constant value
  private String homePropAddress; // legal address of insured property
  private int homePropType; 
  /* Numeric code describing property type: 
   * 1 - single family dwelling
   * 2 - townhouse, attached
   * 3 - townhouse, detached
   * 4 - condominium
   */
  private int homeStructure; // Structural coverage limit, stated in thousands of dollars.
  private int homeContents; // Contents limits, stated in thousands of dollars
  private double homeDeductible; // Policy deductible as a percentage of total insured value (homeStructure + homeContents)
  private boolean umbrella; // Boolean indicating if policy is tied to umbrella coverage
  
  public HomeOwners()
  {
    super();
  } // end null constructor
  public HomeOwners(String own, String insd, String nbr, double prem,
                    String addr, int type, int struct, int goods, 
                    double ded, boolean umbr)
    throws PolicyException
  {
    try{
      
      super.setPolOwner(own);
      super.setPolInsured(insd);
      super.setPolNumber(nbr);
      super.setPolPremium(prem);
      
      setHomePropAddress(addr);
      setHomePropType(type);
      setHomeStructure(struct);
      setHomeContents(goods);
      setHomeDeductible(ded);
      setUmbrella(umbr);
    } // end try
    catch(PolicyException xcptn)
    {
      String oldMsg = xcptn.getMessage();
      
      String newMsg = String.format("fack");
      throw new PolicyException( oldMsg + newMsg, xcptn);
    } // end catch block
  } // end constructor HomeOwners
  
  // set methods
  
  public final void setHomePropAddress(String addr){
    homePropAddress = addr;
  } // end setHomeAddr
  public final void setHomePropType(int type)
    throws PolicyException
  {
    if(type > 0 && type < 5){
      homePropType = type;}
    else{
      homePropType = 1;
      throw new PolicyException("You must enter a value between 1-4, this will be set as 1");
      
    }
  } // end setHomeType
  public final void setHomeStructure(int struct){
    homeStructure = struct;
  } // end setHomeStructure
  public final void setHomeContents(int goods){
    homeContents = goods;
  } // end setHomeGoods
  public final void setHomeDeductible(double ded){
    homeDeductible = ded;
  } // end setHomeDeductible
  public final void setUmbrella(boolean umbr){
    umbrella = umbr;
  } // end setUmbrella
  
  // get methods
  
  public final String getHomePropAddress(){
    return homePropAddress;
  } // end getHomeAddr
  public final int getHomePropType(){
    return homePropType;
  } // end getHomeType
  public final int getHomeStructure(){
    return homeStructure;
  } // end getHomeStructure
  public final int getHomeContents(){
    return homeContents;
  } // end getHomeGoods
  public final double getHomeDeductible(){
    return homeDeductible;
  } // end getHomeDeductible
  public final boolean getUmbrella(){
    return umbrella;
  } // end getUmbrella
  
  // other methods
  
  public double getDeductibleInDollars(){
    return (double) ((getHomeStructure() + getHomeContents()) * 1000) * getHomeDeductible();
  }// end getDeductibleInDollars
  
  public double calcExposure(){
    return (double) (getHomeStructure() + getHomeContents());
  }// end calcExposure
  
  public double calcCurrentValue(){
    return (double) super.getPolPremium()-(calcExposure()*EXPOSURE_RATE);
  }// end calcCurrentValue
  
  public String toString(){
    return String.format("%n%s owns Policy %s insuring %s, with a premium of %.2f." +
                         "%nThis %s policy insures a type %d home at %s." +
                         "The structure is insured for $%,d.00; contents for $%,d.00. The deductible is $%.2f." +
                         "This policy %s part of an Umbrella contract.", 
                         super.getPolOwner(),
                         super.getPolNumber(),
                         super.getPolInsured(),
                         super.getPolPremium(),
                         this.getClass(),
                         getHomePropType(),
                         getHomePropAddress(),
                         getHomeStructure(),
                         getHomeContents(),
                         getDeductibleInDollars(),
                         getUmbrella()
                        );
  }//end toString
  
  
  
}
