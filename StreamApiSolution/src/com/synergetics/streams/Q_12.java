package com.synergetics.streams;

import java.util.OptionalDouble;
import java.util.stream.DoubleStream;
import java.util.stream.Stream;

public class Q_12 {
	public static void main(String[] args) {
		// 1. sum()
		DoubleStream ds = DoubleStream.of(0, 2, 4); // 1
		double sum = ds.filter(i -> i % 2 != 0).sum(); // sum() is a terminal operation (reduction also)
		System.out.println("sum is " + sum); // 0.0

		// 2. average()
		OptionalDouble od = Stream.of(1.0, 3.0)
				.mapToDouble(n -> n.doubleValue())
				.filter(n -> n % 2 == 0).average();// terminal operation (reduction also)
		
		if (od.isPresent()) {
			System.out.println("average == " + od.getAsDouble());
		}
	}
}
