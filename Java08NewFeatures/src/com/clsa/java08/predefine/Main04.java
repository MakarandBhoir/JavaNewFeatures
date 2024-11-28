package com.clsa.java08.predefine;

interface MyPredicate<T> {
	public boolean test(T x);
}

public class Main04 {

	public static void main(String[] args) {
		MyPredicate<String> p1 = (String s1)-> {
			return s1.length() > 5;
		};
		
		MyPredicate<Integer> p2 = (Integer i1) -> i1 % 2 == 0;
		
		System.out.println(p1.test("CLSA Pune"));
		
		System.out.println(p2.test(101));
	}

}
