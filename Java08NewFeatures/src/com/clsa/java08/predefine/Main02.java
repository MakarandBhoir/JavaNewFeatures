package com.clsa.java08.predefine;

@FunctionalInterface
interface MyConsumer<X>{
	public void accept(X s);
}

public class Main02 {

	public static void main(String[] args) {
		MyConsumer<String> consumer1 = s -> System.out.println(s);
		MyConsumer<Integer> consumer2 = i -> System.out.println(i);
		
		consumer1.accept("CLSA Pune");
		consumer2.accept(100);
	}

}
