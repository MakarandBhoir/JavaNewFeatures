package com.synergetics.streams;

import java.util.Arrays;
import java.util.List;

public class Q_13 {
	public static void main(String[] args) {
		List<Integer> ls = Arrays.asList(11, 12, 22, 33, 33, 55, 66);

		System.out.println("distinct");
		ls.stream()
			.distinct()
			.forEach(n -> System.out.println(n)); // 11, 22, 33, 55, 66

		// Java only generates the amount of stream you need (lazy evaluation).
		System.out.println("anyMatch");
		System.out.println(ls.stream()
							.distinct()
							.peek(System.out::println)
							.anyMatch(x -> x == 12));// true

		System.out.println("noneMatch");
		System.out.println(ls.stream()
							.peek(System.out::println)
							.noneMatch(x -> x % 11 > 0));// true
	}

}
