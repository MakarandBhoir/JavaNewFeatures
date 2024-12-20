package java08.stream;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Predicate;

public class LambdaEffectivelyFinal {
    String name="";
    
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>();
        list.add ("Pant");

        int x=12; // final or effectively final

        // Lambdas take a snapshot/picture of local variables, these local variables MUST NOT change. 
        // Defining lambda here.
        Predicate<String> lambda = s -> {
            //x++;
            new LambdaEffectivelyFinal().name = "Bhoir";  // instance/class variables are ok to changed
            return s.isEmpty() && x%2 == 0; 
        };

        filterData(list, lambda);// lambda views 'x' as 12
        System.out.println(list);
        
        new LambdaEffectivelyFinal().name = "Makarand"; // instance/class vars are ok
        
        // If 'x' was allowed to change, then the method and the lambda would have 2 different views of 'x'!
        //x++; 
        filterData(list, lambda);// lambda views 'x' as 12
        // some other code...        
    }
    
    public static void filterData(List<String> list, Predicate<String> lambda){
       Iterator<String> i = list.iterator();
       while(i.hasNext()){
            if(lambda.test(i.next())){  // executing lambda here
                 i.remove();
            }
       }
    }
    
}
