/* Author: Brandon Stevenson
 * Class Policy Exception -CustomerException.Java
 * PA3
 */
public class CustomerException extends Exception
{
  
  public CustomerException(String msg)
  {
    super(msg);
  }//END CustomerException
  
  public CustomerException(String msg, Exception cause)
  {
    super(msg, cause);
  } //END CustomerException
  
}
