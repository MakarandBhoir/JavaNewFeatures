package java08.featues;

import java.util.function.Predicate;// pre-defined in the API

// my own custom Functional Interface
interface Evaluate<T> {
	boolean isNegative(T t);// similar to Predicate
}

public class TestPredicate {
	public static void main(String[] args) {
		// own custom Functional Interface
		Evaluate<Integer> lambda = (Integer i) -> {
			return i < 0;
		};
		System.out.println("Evaluate: " + lambda.isNegative(-1));// true
		System.out.println("Evaluate: " + lambda.isNegative(+1));// false

		// pre-defined Functional Interface
		Predicate<Integer> predicate = i -> i < 0;
		System.out.println("Predicate: " + predicate.test(-1));// true
		System.out.println("Predicate: " + predicate.test(+1));// false

		Integer num1 = 10;
		System.out.println("Predefine: Is " + num1 + " even? " + check(num1, n -> n % 2 == 0));// true
		Integer num2 = 20;
		System.out.println("Custom: Is " + num2 + " even? " + check(num2, y -> y % 2 == 0));// false
	}

	public static <T> boolean check(T t, Predicate<T> lambda) {
		return lambda.test(t);
	}

	public static <T> boolean check2(T t, Evaluate<T> lambda) {
		return lambda.isNegative(t);
	}

}
