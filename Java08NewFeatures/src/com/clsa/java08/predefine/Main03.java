package com.clsa.java08.predefine;

import java.util.function.Predicate;

public class Main03 {

	public static void main(String[] args) {
		// Predicate - public boolean test(T t)
		
		Predicate<String> predicate1 = (String str) -> {
			boolean result = str.startsWith("CLSA");
			return result;
		};
		
		boolean result =  predicate1.test("CLSA Pune");
		System.out.println(result);
	}

}
