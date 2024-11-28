package com.clsa.java08.predefine;

import java.util.function.BiConsumer;

public class Main06 {
	public static void main(String[] args) {
		// BiConsumer - public void accept(T1 obj, T2 obj)
		
		BiConsumer<String, String> biconsumer1 = (s1, s2) -> {
			System.out.println(s1);
			System.out.println(s2);
			System.out.println(s1.concat(s2));
		};
		
		biconsumer1.accept("CLSA", "Pune");
		
	}
}
