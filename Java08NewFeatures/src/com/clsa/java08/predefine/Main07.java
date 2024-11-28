package com.clsa.java08.predefine;

import java.util.function.BiFunction;

public class Main07 {
	// BiFunction<T1, T2, T3> - T3 apply(T1 obj, T2 obj)
	
	public static void main(String[] args) {
		
		BiFunction<Integer, Integer, Double> biFunction = (Integer n1, Integer n2) ->{
			double avg = (n1 + n2) / 2.0;
			return avg;
		};
		
		System.out.println(biFunction.apply(10, 20));
	}

}
