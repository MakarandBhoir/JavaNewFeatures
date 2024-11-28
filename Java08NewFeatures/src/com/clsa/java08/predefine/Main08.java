package com.clsa.java08.predefine;

import java.util.function.Predicate;

public class Main08 {
	public static void main(String[] args) {
		Predicate<Integer> p1 = (Integer n1) -> n1 > 0;

		check(10, p1);

		check(-10, n -> n < 0);
	}

	public static <T> void check(T t1, Predicate<T> predicate) {
		System.out.println(predicate.test(t1));
	}
}
