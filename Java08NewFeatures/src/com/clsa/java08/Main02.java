package com.clsa.java08;

class Main02{
	public static void main(String[] args) {
		Printable2 p1 = (String str) -> System.out.println("Hello1 "+str);
		
		Printable2 p2 = (str) -> {
			System.out.println("Hello2 "+str);
			System.out.println("Hello2 "+str);
		};
		
		Printable2 p3 = str -> System.out.println("Hello3 "+str);
		
		p1.print("World");
		p2.print("World");
//		p3.print("World");
	}
}
