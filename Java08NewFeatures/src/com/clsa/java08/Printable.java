package com.clsa.java08;
@FunctionalInterface
public interface Printable {
	public abstract void print();
	//public boolean equals(Object obj);
	public default void printDefault() {
		System.out.println("Default print method");
	}
	public static void printStatic() {
		System.out.println("Static print method");
	}
}
abstract class PritableImpl implements Printable{
}
class PrintableImpl2 extends PritableImpl{
	public void print() {
		System.out.println("PrintableImpl2 print method");
	}
}
class Main01{
	public static void main(String[] args) {
		Printable ref = new PrintableImpl2();
		ref.print();
	}
}





