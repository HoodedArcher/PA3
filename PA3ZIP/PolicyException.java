/**
 *
 */
  public class PolicyException extends Exception {
  
  public PolicyException(String msg){
    super(msg);
  }// end PolicyException
  
  public PolicyException(String msg, Exception cause){
    super(msg, cause);
  }//end policyException 
  
}
