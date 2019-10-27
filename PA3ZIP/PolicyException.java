/* Author: Zachary Kielb
 * Class Policy Exception -PolicyException.Java
 * PA3
 */
  public class PolicyException extends Exception 
  {
  
  public PolicyException(String msg){
    super(msg);
  }//END PolicyException
  
  public PolicyException(String msg, Exception cause)
  {
    super(msg, cause);
  }//END PolicyException 
  
}
