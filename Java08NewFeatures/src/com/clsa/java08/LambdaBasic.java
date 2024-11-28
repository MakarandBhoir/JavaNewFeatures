package com.clsa.java08;

public class LambdaBasic {
	public static void main(String[] args) {
		Printable ref = new Printable() {
			public void print() {
                System.out.println("Ananomous class print method");
            }
		};
		
		ref.print();
		
		Printable ref2 = () -> System.out.println("Lambda print method");
		
		Printable ref3 = () -> {
			System.out.println("Lambda print method");
			System.out.println("Lambda print method");
		};
	}
}
