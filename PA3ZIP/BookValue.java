/* Author: Zachary Kielb
 * Class Interface - BookValue.java
 * PA3
 */
public interface BookValue 
{
  public String identifyContract();//Returns policy or contract number.
  public double calcExposure();//Returns double of contract total exposure.
  public double calcCurrentValue();//Returns double of current value.
}//END BookValue
