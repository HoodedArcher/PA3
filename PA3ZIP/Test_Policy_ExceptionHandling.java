/*
 *   Test_Policy_ExceptionHandling
 * 
 *   This test harness will allow for batch testing of data validation and exception handling in the
 *     Policy hierarchy of classes.
 * 
 *   The test cases here are limited & generalized - it would be a good idea to add test cases to more fully 
 *     test the validation and exception handling in the associated classes. Testing for grading will include 
 *     different and additional test cases.
 * 
 * (c) 2019, Terri Davis
 */

public class Test_Policy_ExceptionHandling
{
   /*
    * The following array holds the Policy test cases. It may be enlarged as needed/desired.
    * 
    * The test cases are entered into the array as String objects. The String objects will be broken 
    *    down into components and, where needed, those components will be converted to numeric types.
    *    This is a sort of intro to Chapter 14.
    * 
    * PLEASE NOTE:  The first character in each String identifies which type of object is to be 
    *   instantiated. "A" = Auto; "H" = HomeOwners.
    */
   public static void main( String[] args )
   {          
     String[] testCaseArray = {       // TEST CASES
         "A,1234567,Samantha Carter,AU12345,1250.00,BMW 335i,2018,BMW985P4153M65472,100,100,250,250",    // success
         "H,1234567,Samantha Carter,HO12345,3853.00,7754 Shady Lane,1,2500,250,0.05,false"               // success
                            };
     /*
      *  The enhanced for loop will take each String in the above array, determine which type of object 
      *  (Auto or HomeOwners) is to be nstantiated, and call the appropriate method based on that 
      *  information.
      */
     for( String candidate: testCaseArray )
     {
       String[] parts = candidate.split( "," );               // 'parse' the String into its constituent data items,
                                                              //  using comma (,) as the delimiter (i.e., comma separated values)
       
       try
       {
         if( parts[0].equalsIgnoreCase( "A" ) )               // check the first data item for object type 
         { // The test case is for an Auto object
           System.out.println( "Proceeding to build Auto object...." );
           buildAuto( parts );
         }  // end positive branch
         else
         { // The test case is for a HomeOwners object
           System.out.println( "Proceeding to build HomeOwners object...." );
           buildHomeOwners( parts );
         }  // end negative branch
       } // end try block
       catch( PolicyException xcptn )
       {
         // Catch the CHAINED exception from the build method... Provide a process message AND
         //  the full text of the CHAINED exception message
         String xcptnMsg = xcptn.getMessage( );
         
         // This (more technical) message goes to SysErr (standard error or problem output)
         System.err.printf( "An exception was thrown when attempting to instantiate an object. " +
                            "%n%s%n" +
                            "Processing will continue with the next test case.%n",
                             xcptnMsg );
       } // end catch PolicyException
       catch( Exception xcptn )
       {
         // This is a sort of "fall through". ANY OTHER exception type will end up here!
         System.err.printf( "OMG!!! Lassie, Timmy fell down the well!!!%n" );
         System.err.println( xcptn.getClass( ).getName( ) );
         xcptn.printStackTrace( );
       } // end catch Exception

     } // end for loop

   }  // end main

   /*
    *  If the String in the array contained data to create an Auto object, execute this method.
    *  
    *  The individual data items will be extracted and converted (if necessary). The class constructor is called.
    *    IF an exception is thrown, it is caught and a VERBOSE message is displayed to the errror output.
    *    ELSE, the toString method of the newly instantiated object is output to Sysout.
    */
   private static void buildAuto( String[] parts )
                       throws PolicyException
   { 
     // This is just a "holding" space for the object we will try to instantiate
     Auto anAuto;
     
     try                                                      // An exception will be thrown for "bad" data
     {
       int[ ] lims = { Integer.parseInt( parts[ 8 ] ),
                       Integer.parseInt( parts[ 9 ] ),
                       Integer.parseInt( parts[ 10 ] ) };
       
       anAuto = new Auto( // Policy items
                            parts[ 1 ],
                            parts[ 2 ],
                            parts[ 3 ],
                            Double.parseDouble( parts[ 4 ] ),    // Convert String data to double
                          // Auto items
                          parts[ 5 ],                            // makeModel
                          Integer.parseInt( parts[ 6 ] ),        // modelYear
                          parts[ 7 ],                            // vin
                          lims,                                  // limits
                          Integer.parseInt( parts[ 11 ] )  );    // deduct

       System.out.printf( "%s%n",
                         anAuto.toString( ) );
     }  // end try
     catch( PolicyException xcptn )
     {
       // "Bad" data was encountered. Catch the exception from the constructor, and CHAIN it, adding information.
       throw new PolicyException( String.format( "Test_Policy_ExceptionHandling.buildAuto: %s", xcptn.getMessage( ) ),
                                   xcptn );
     }  // end catch PolicyException
   }  // end buildAuto
   
   /*
    *  If the String in the array contained data to create a HomeOwners, execute this method.
    *  
    *  The individual data items will be extracted and converted (if necessary). The class constructor is called.
    *    IF an exception is thrown, it is caught and a VERBOSE message is displayed to the errror output.
    *    ELSE, the toString method of the newly instantiated object is output to Sysout.
    */
   private static void buildHomeOwners ( String[] parts )
                       throws PolicyException
   {    
     // This is just a "holding" space for the object we will try to instantiate
     HomeOwners aHomeOwners;
     
     try                                                      // An exception will be thrown for "bad" data
     {
       aHomeOwners = new HomeOwners( // Policy items
                                        parts[ 1 ],
                                        parts[ 2 ],
                                        parts[ 3 ],
                                        Double.parseDouble( parts[ 4 ] ),    // Convert String data to double
                                     // HomeOwners items
                                        parts[ 5 ],
                                        Integer.parseInt( parts[ 6 ] ),
                                        Integer.parseInt( parts[ 7 ] ),
                                        Integer.parseInt( parts[ 8 ] ),
                                        Double.parseDouble( parts[ 9 ] ),
                                        Boolean.parseBoolean( parts[ 10 ] ) );
       System.out.printf( "%s%n",
                          aHomeOwners.toString( ) );
     }  // end try
     catch( PolicyException xcptn )
     {
       // "Bad" data was encountered. Catch the exception from the constructor, and CHAIN it, adding information.
       throw new PolicyException( String.format( "Test_Policy_ExceptionHandling.buildHomeOwners: %s", xcptn.getMessage( ) ),
                                   xcptn );
     }  // end catch PolicyException
   }  // end buildHomeOwners

} // end Test_Policy_ExceptionHandling
