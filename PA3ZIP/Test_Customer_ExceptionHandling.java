/*
 *   Test_Customer_ExceptionHandling
 * 
 *   This test harness will allow for batch testing of data validation and exception handling in the
 *     Customer class.
 * 
 *   The test cases here are limited & generalized - it would be a good idea to add test cases to more fully 
 *     test the validation and exception handling in the associated classes. Testing for grading will include 
 *     different and additional test cases.
 * 
 * (c) 2019, Terri Davis
 */

public class Test_Customer_ExceptionHandling
{
   /*
    * The following array holds the Customer test cases. It may be enlarged as needed/desired.
    * 
    * The test cases are entered into the array as String objects. The String objects will be broken 
    *    down into components and, where needed, those components will be converted to numeric types.
    *    This is a sort of intro to Chapter 14.
    * 
    */
   public static void main( String[] args )
     throws CustomerException
   {          
     // Declare and load an array of test cases
     String[] testCaseArray = {       // TEST CASES
         "1234567,Carter,Samantha,357159852",                                                            // success
         "9876541,O'Neil,Jack,741369951"                                                                 // success
                            };
     // Declare, DO NOT INSTATIATE, a holding place for a Customer  object
     Customer myCust;
     
     /*
      *  The enhanced for loop will take each String in the above array, and user the data in that String
      *    to call the Customer full constructor
      */
     for( String candidate: testCaseArray )
     {
       String[] parts = candidate.split( "," );               // 'parse' the String into its constituent data items,
                                                              //  using comma (,) as the delimiter (i.e., comma separated values)
       
       try
       {
         // Call the Customer constructor using the "pieces" of the String object in the test case array
         myCust = new Customer( parts[ 0 ],                   // value for custId
                                parts[ 1 ],                   // value for custLastName
                                parts[ 2 ],                   // value for custFirstName
                                parts[ 3 ] );                 // value for custTaxId
         
         // This line can only be executed IF there was NO EXCEPTION thrown during construction/instantiation
         System.out.printf( "Successfully Instantiated Customer:%n\t%s%n",
                             myCust.toString( ) );
         
       } // end try block
       catch( CustomerException xcptn )                       // IF invalid data was found in the constructor...
       {
         // Catch the CHAINED exception from the constructor... Provide a process message AND
         //  the full text of the CHAINED exception message
         String xcptnMsg = xcptn.getMessage( );
         
         // This (more technical) message goes to SysErr (standard error or problem output)
         System.err.printf( "An exception was thrown when attempting to instantiate an object. " +
                            "%n%s%n" +
                            "Processing will continue with the next test case.%n",
                             xcptnMsg );
       } // end catch CustomerException
       catch( Exception xcptn )
       {
         // This is a sort of "fall through". ANY OTHER exception type will end up here!
         System.err.printf( "OMG!!! Lassie, Timmy fell down the well!!!%n" );
         System.err.println( xcptn.getClass( ).getName( ) );
         xcptn.printStackTrace( );
       } // end catch Exception

     } // end for loop

   }  // end main
   
} // end Test_Customer_ExceptionHandling
