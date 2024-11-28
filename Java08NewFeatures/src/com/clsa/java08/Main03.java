package com.clsa.java08;

public class Main03 {

	public static void main(String[] args) {
		Max max1 = (int x1, int x2)->{
			if(x1 > x2) {
				return x1;
			}else {
				return x2;
			}
		};
		
		System.out.println(max1.max(10, 20));
		
	}

}
