package java08.stream;

import java.time.LocalTime;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BiPredicate;

import java.util.function.UnaryOperator; // add by 1 is a unary operation
import java.util.function.BinaryOperator;// multiplying 2 numbers is a binary operation

public class BuiltInsFITest {

    public static void main(String[] args) {
        BuiltInsFITest fiAPI = new BuiltInsFITest();
      fiAPI.predicate();
//      fiAPI.supplier();        
//      fiAPI.consumer();
//      fiAPI.function();
//      fiAPI.unaryBinaryOperator();
    }
    public void predicate() {
        // Predicate<T> is a functional interface i.e. one abstract method:
        // boolean test(T t); 
        Predicate<String> pStr = s -> s.contains("Pune");
        System.out.println(pStr.test("CLSA Pune"));//true

        // BiPredicate<T, U> is a functional interface i.e. one abstract method:
        // boolean test(T t, U u); 
        BiPredicate<String, Integer> checkLength = (str, len) -> str.length() == len;
        System.out.println(checkLength.test("CLAS Pune", 7));//false (length is 9)

    }

    public void supplier() {
        // Supplier<T> is a functional interface i.e. one abstract method:
        // T get()
        Supplier<StringBuilder> supSB = () -> {return new StringBuilder();};
        System.out.println("Supplier SB: " + supSB.get().append("MB"));// Supplier SB: MB
        
        Supplier<LocalTime> supTime = () -> {return LocalTime.now();};
        System.out.println("Supplier time: " + supTime.get());//Supplier time: <current_time>
        
        Supplier<Double> sRandom = () -> {return Math.random();};
        System.out.println(sRandom.get());// Random number between 0 - 1 e.g. 0.04701999117334821
    }

    public void consumer() {
        // Consumer<T> is a functional interface i.e. one abstract method:
        // void accept(T t)
        Consumer<String> print = s -> System.out.println(s);// lambda
        print.accept("To be or not to be, that is the question");
        
        List<String> names = new ArrayList<>();
        names.add("Ashish");
        names.add("Deepak");
        
        names.forEach(print);  // Ashish, Deepak
        names.forEach(str -> System.out.println(str));
        
        // BiConsumer<T, U> is a functional interface i.e. one abstract method:
        // void accept(T t, U u)
        Map<String, String> mapCapitalCities = new HashMap<>();
        // Note: The return value of put(k,v) is just ignored (and not returned from the lambda)
        BiConsumer<String, String> biCon = (key, value) -> mapCapitalCities.put(key, value);
        
        biCon.accept("New Delhi", "India");
        biCon.accept("Beijing", "China");
        
        System.out.println(mapCapitalCities);

        BiConsumer<String, String> mapPrint = (key, value) -> 
                                                    System.out.println(key + " is the capital of: "+value);
        mapCapitalCities.forEach(mapPrint); 
                                           
    }

    public void function() {
        // Function<T, R> is a functional interface i.e. one abstract method:
        // R apply(T t)
        Function<String, Integer> fn2 = s -> s.length();
        System.out.println("Function: " + fn2.apply("CLSA"));// 4

        // BiFunction<T, U, R> is a functional interface i.e. one abstract method:
        // R apply(T t, U u)
        BiFunction<String, String, Integer> biFn   = (s1, s2) -> s1.length() + s2.length();
        System.out.println("BiFunction: " + biFn.apply("Makarand", "Bhoir"));// 13

        BiFunction<String, String, String> biFn2   = (s1, s2) -> s1.concat(s2);
        System.out.println("BiFunction: " + biFn2.apply("Makarand ", "Bhoir"));// Makarand Bhoir
    }
    public void unaryBinaryOperator() {
        // UnaryOperator<T> extends Function<T, T> is a functional interface i.e. one abstract method:
        //      T apply(T t)
        UnaryOperator<String> unaryOp = name -> "My name is "+name;
        System.out.println("UnaryOperator: " + unaryOp.apply("Makarand"));// My name is Makarand

        // BinaryOperator<T> extends BiFunction<T, T, T> is a functional interface i.e. one abstract method:
        // T apply(T t1, T t2)
        BinaryOperator<String> binaryOp   = (s1, s2) -> s1.concat(s2);
        System.out.println("BinaryOperator: " + binaryOp.apply("Makarand ", "Bhoir"));// // Makarand Bhoir
    }
}
