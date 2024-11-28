package com.clsa.java08.predefine;

import java.util.function.Function;

public class Main05 {
	public static void main(String[] args) {
		// Function - public R apply(T t)
		
		// public Integer apply(String s)
		Function<String, Integer> f1 = (String s)->{
			return s.length();
		};
		
		int result = f1.apply("Pune");
		System.out.println(result);
	}
}
