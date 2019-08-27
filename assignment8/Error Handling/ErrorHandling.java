
public class ErrorHandling{
    public void anyFunction () {

        // Arthematic exception
        int a = 5/0;
        System.out.println ( " Result : " + a );
        
        // Array bound exception
        int[] array = {1, 2, 3};
        System.out.println ( " Array[3] : " + array[3] );

        // NUll pointer exception
        String str = null; //null value 
        System.out.println(str.charAt(0));

    }
     public  static void main (String args [  ] )
     {
        ErrorHandling errorHandling = new ErrorHandling();
        try
        {
            errorHandling.anyFunction () ;
            
        }

        catch(Exception e){ 
            System.out.println ("Exceptions Occured"); 
        } 
        
        System.out.println ("I am out of try block"); 

     }
} 
