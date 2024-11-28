package java08.featues;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class MethodReferenceDemo1 {
    public static void main(String[] args) {    
//        boundMethodReferences();        // bound
//        unboundMethodReferences();      // unbound
//        constructorMethodReferences();  // constructor
//        staticMethodReferences();       // static
    }
    public static void boundMethodReferences(){
        String name = "CLSA";
        Supplier<String> lowerL   = () -> name.toLowerCase();   // lambda
        Supplier<String> lowerMR  = name::toLowerCase;          // method reference

        // No need to say which instance to call it on - the supplier is bound to name            
        System.out.println(lowerL.get()); // CLSA
        System.out.println(lowerMR.get());// CLSA
        
        // Even though startsWith is overloaded, boolean startsWith(String) and 
        // boolean startsWith(String, int), because we are creating a Predicate which 
        // has a functional method of test(T t), the startsWith(String) is used. 
        // This is where "context" is important.
        Predicate<String> titleL  = (title) -> name.startsWith(title);
        Predicate<String> titleMR = name::startsWith;

        System.out.println(titleL.test("C")); // true
        System.out.println(titleMR.test("c"));// false
    }
    
    public static void unboundMethodReferences(){
        Function<String, String> upperL  = s -> s.toUpperCase();
        Function<String, String> upperMR = String::toUpperCase;

        // The function is unbound, so you need to specify which instance to call it on
        System.out.println(upperL.apply("makarand"));   // MAKARAND
        System.out.println(upperMR.apply("makarand"));  // MAKARAND

        BiFunction<String, String, String> concatL   = (s1, s2) -> s1.concat(s2);
        BiFunction<String, String, String> concatMR  = String::concat;
        System.out.println(concatL.apply("Makarand ", "Bhoir"));// Makarand Bhoir

        // 1st parameter is used for executing the instance method
        // "Makarand ".concat("Bhoir")
        System.out.println(concatMR.apply("Makarand ", "Bhoir"));// Makarand Bhoir
    }
    
    public static void constructorMethodReferences(){
        Supplier<StringBuilder> sbL   = () -> new StringBuilder();  // lambda
        Supplier<StringBuilder> sbMR  = StringBuilder::new;         // method reference

        StringBuilder sb1 = sbL.get(); sb1.append("lambda version"); System.out.println(sb1);
        StringBuilder sb2 = sbMR.get(); sb2.append("method reference version"); System.out.println(sb2);
        System.out.println("----------------------------------");
        
        Function<Integer, List<String>> alL  = x -> new ArrayList(x);
        Function<Integer, List<String>> alMR = ArrayList::new;
        Function<List<String>, List<String>> alMR2 = ArrayList::new;
        
        List<String> ls1 = alL.apply(10);  // size 10
        ls1.add("21"); 
        System.out.println(ls1);//[21]
        
        List<String> ls2 = alMR.apply(5);  // size 5
        ls2.add("88"); 
        System.out.println(ls2);//[88]
        
        List<String> ls3 = alMR2.apply(ls1);
        System.out.println(ls3);//[21]
        System.out.println("----------------------------------");
    }
    
    public static void staticMethodReferences(){
        //  Static method references are considered UNBOUND also. An example static method 
        //  is Collections.sort(List)
        //  Consumer takes one parameter => sort(List) is used, as opposed to sort(List, Comparator)
        Consumer<List<Integer>> sortL  = list -> Collections.sort(list);
        Consumer<List<Integer>> sortMR = Collections::sort;

        List<Integer> listOfNumbers = Arrays.asList(2,1,5,4,9);
        sortL.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);  // [1, 2, 4, 5, 9]

        listOfNumbers = Arrays.asList(8,12,4,3,7);
        sortMR.accept(listOfNumbers);// execution
        System.out.println(listOfNumbers);  // [3, 4, 7, 8, 12]
    }    
}

