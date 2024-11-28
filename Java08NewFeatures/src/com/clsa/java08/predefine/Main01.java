package com.clsa.java08.predefine;

import java.util.function.Consumer;

public class Main01 {

	public static void main(String[] args) {
		// Consumer - public void accept(T t)
		//Consumer<String> consumer1 = (String s) -> System.out.println(s);
		Consumer<String> consumer1 = s -> System.out.println(s);
		
		//Consumer<Integer> consumer2 = (Integer i) -> System.out.println(i);
		Consumer<Integer> consumer2 = i -> System.out.println(i);
		
		consumer1.accept("CLSA Pune");
		consumer2.accept(100);
	}

}
