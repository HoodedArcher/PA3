/**
 * Class Policy Subclass - Auto.Java
 * PA3
 */

public class Auto extends Policy{
  
  private final double EXPOSURE_RATE = 0.0051;//Constant
  private String autoModel;//Stores make and model of vehicle
  private int autoYear;//Stores model year of vehicle
  private String autoVin;//Stores vehicle identification number
  private int[] autoLimits = new int[3];//Array values correlate to Collision, Comprhensive, and UIM
  private int autoDeductible;//Policy deductible in dollars
  
  public Auto(){
    super();
  }//END null Auto constructor
  
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
  }//END Auto constructor
  
//Set methods
  
  public final void setAutoModel(String model){
    autoModel = model;
  }//END setAutoModel
  public final void setAutoYear(int year)
    throws PolicyException
  {
    if(year > 2009 && year < 2021)
    {
      autoYear = year;
    }
    else
    {
      throw new PolicyException("DATA VALIDATION: The year must be between 2009 and 2021.");
    }
  }//END setAutoYear
  public final void setAutoVin(String id)
    throws PolicyException
  {
    if(id.length() == 17 && id.matches("^(?:(?![IOQ\\s])[A-Z\\d])+$"))
    {
      autoVin = id;
    }
    else
    {
      throw new PolicyException("DATA VALIDATION: The Vin must be 17 characters long, not contain special characters, and cannot contain I, O, or Q.");
    }
  }//END setAutoVin
  public final void setAutoLimits(int[] lims)
  {
    autoLimits = lims;
  }//END setAutoLimits
  public final void setAutoDeductible(int ded)
  {
    autoDeductible = ded;
  }//END setAutoDeductible
  
//Get methods
  public final String getAutoModel()
  {
    return autoModel;
  }//END getAutoModel
  public final int getAutoYear()
  {
    return autoYear;
  }//END getAutoYear
  public final String getAutoVin()
  {
    return autoVin;
  }//END getAutoVin
  public final int[] getAutoLimits()
  {
    return autoLimits;
  }//END getAutoLimits
  public final int getAutoDeductible()
  {
    return autoDeductible;
  }//END getAutoDeductible
  
  
  public String produceLimitsTxt()
  {
    return String.format("%nCollision: $%,d.00, Comprehensive: $%,d.00, UIM: $%,d.00",
                         autoLimits[0]*1000,
                         autoLimits[1]*1000,
                         autoLimits[2]*1000); 
  }//END produceLimitsTxt
  
  public double calcExposure()
  {
    return autoLimits[0] + autoLimits[1] + autoLimits[2];
  }//END calcExposure
  
  public double calcCurrentValue()
  {
    return super.getPolPremium() - (calcExposure() * EXPOSURE_RATE);
  }//END calcCurrentValue
  
  public String toString(){
    return String.format("%s%nThis %s policy insures a %,d %s, VIN %s, with limits %s and a $%,d.00.",
                         super.toString(),
                         getClass().getSimpleName(),
                         getAutoYear(),
                         getAutoModel(),
                         getAutoVin(),
                         produceLimitsTxt(),
                         getAutoDeductible());
  }//END toString
}//END class Auto
