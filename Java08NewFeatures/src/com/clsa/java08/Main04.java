package com.clsa.java08;

public class Main04 {

	public static void main(String[] args) {
//		Max max2 = (n1, n2) -> {
//			int res = (n1 > n2) ? n1 : n2;
//			return res;
//		};
		Max max2 = (n1, n2) -> (n1 > n2) ? n1 : n2;
		
		int result = max2.max(10, 20);
		System.out.println(result);
	}

}
