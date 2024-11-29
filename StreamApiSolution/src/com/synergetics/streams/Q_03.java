package com.synergetics.streams;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

public class Q_03 {
	
	public static void main(String[] args) {
        Stream<List<String>> streamOfLists = Stream.of(
                Arrays.asList("a", "b"),
                Arrays.asList("d", "c"),
                Arrays.asList("a", "c"));

        streamOfLists
                .filter(list -> list.contains("c"))
                .peek(list -> System.out.println("\n"+list)) // 1. [d,c]    2. [a,c]
                // Stream<String> flatMap(Function)  
                //   Function<T,R> == R apply(T t)
                //     Stream<String> apply(List<String> l)
                .flatMap(list -> list.stream())
                //.flatMap(List::stream)
                .forEach(str -> System.out.print(str+ " ")); // 1.  d c     2.  a c  
        		System.out.println();
    }


}
