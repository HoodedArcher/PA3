/**
 *
 */
public class CustomerException extends Exception{
  
  public CustomerException(String msg)
  {
    super(msg);
  }// end CustomerException
  
  public CustomerException(String msg, Exception cause){
    super(msg, cause);
  } // end CustomerException
  
}
