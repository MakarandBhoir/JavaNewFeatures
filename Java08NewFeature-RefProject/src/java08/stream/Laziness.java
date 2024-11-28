package java08.stream;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

public class Laziness {
    public static void main(String []args){
        List<String> names =
                Arrays.asList("January", "Feb", "March", "April", "May", "June");
        names.stream() 
            .peek(System.out::println)      
            .filter(s -> {
                System.out.println("filter1 : "+s);
                return s.startsWith("M") || s.startsWith("A"); } )   
            .filter(s -> { 
                System.out.println("filter2 : "+s);
                return s.length() > 3; } )    
            .limit(1) // intermediate operation  Stream<T> limit(long)
            .forEach(System.out::println);  // terminal operation
        
        
    }
}
/* Output:
------------------------------------------------------------------
January               - peek
filter1 : January     - filter1 removes April
Feb                   - peek
filter1 : Feb         - filter1 passes Ben on 
March                 - peek
filter1 : March       - filter1 passes Charlie on
filter2 : March       - filter2 passes Charlie on
March                 - forEach()

Note: limit(1) means April, May or June are not 
      processed at all i.e. none of them appear in the output
      via "peek()"
------------------------------------------------------------------      
*/