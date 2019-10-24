/**
 * Class Auto
 * Auto is a subclass of Policy
 */

public class Auto extends Policy{
  
  private final double EXPOSURE_RATE = 0.0051; // Constant of auto class
  private String autoModel; // Stores make and model of vehicle
  private int autoYear; // Stores model year of vehicle
  private String autoVin; // Stores vehicle identification number
  private int[] autoLimits = new int[3]; // Array values correlate to Collision, Comprhensive, and UIM
  private int autoDeductible; // Policy deductible in dollars
  
  public Auto(){
    super();
  } // end null Auto constructor
  
  public Auto(String own, String insd, String nbr, double prem, String model, int year, String id, int[] lims, int ded)
  throws PolicyException
  {
    
    
          super.setPolOwner(own);
          super.setPolInsured(insd);
          super.setPolNumber(nbr);
          super.setPolPremium(prem);
    setAutoModel(model);
    setAutoYear(year);
    setAutoVin(id);
    setAutoLimits(lims);
    setAutoDeductible(ded);
    
  } // end Auto constructor
  
   // set methods
  
  public final void setAutoModel(String model){
    autoModel = model;
  } // end setAutoModel
   public final void setAutoYear(int year)
     throws PolicyException
   {
     if(year > 2009 && year < 2021){
    autoYear = year;
     }
     else
     {
       throw new PolicyException("Year must be between 2009 and 2021");
     }
  } // end setAutoYear
    public final void setAutoVin(String id){
    autoVin = id;
  } // end setAutoVin
    public final void setAutoLimits(int[] lims){
    autoLimits = lims;
  } // end setAutoLimits
    public final void setAutoDeductible(int ded){
    autoDeductible = ded;
  } // end setAutoDeductible
    
     // get methods
    public final String getAutoModel(){
    return autoModel;
  } // end getAutoModel
   public final int getAutoYear(){
    return autoYear;
  } // end getAutoYear
    public final String getAutoVin(){
    return autoVin;
  } // end getAutoVin
  public final int[] getAutoLimits(){
    return autoLimits;
  } // end getAutoLimits
    public final int getAutoDeductible(){
    return autoDeductible;
  } // end getAutoDeductible
    
  
  public String produceLimitsTxt(){
    
     return String.format("%nCollision: $%,d.00, Comprehensive: $%,d.00, UIM: $%,d.00",
                        autoLimits[0]*1000,
                        autoLimits[1]*1000,
                        autoLimits[2]*1000);
    
  } // end produceLimitsTxt
  
  public double calcExposure(){
    
    return autoLimits[0] + autoLimits[1] + autoLimits[2];
    
  } // end calcExposure
  
  public double calcCurrentValue(){
    
    return super.getPolPremium() - (calcExposure() * EXPOSURE_RATE);
    
  } // end calcCurrentValue
  
  public String toString(){
       return String.format("%s%nThis %s policy insures a %,d %s, VIN %s, with limits %s and a $%,d.00.",
                        super.toString(), this.getClass(),
                        getAutoYear(),
                        getAutoModel(),
                        getAutoVin(),
                        produceLimitsTxt(),
                        getAutoDeductible());
                        
    
  } // end toString
  
  
  
} // end class Auto
