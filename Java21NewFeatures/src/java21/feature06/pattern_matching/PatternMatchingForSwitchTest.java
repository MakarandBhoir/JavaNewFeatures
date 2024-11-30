package java21.feature06.pattern_matching;
import java.util.*;

/**
 * To run: `java PatternMatchingForSwitchTest.java`
 */
public class PatternMatchingForSwitchTest {
	public static void main(String[] args) {
//		switchExhaustivenessAndCompatibility();
//		switchExpressionWithPatternMatching();
//		switchScopeWithPatternMatching();
//		switchEnhancedTypeChecking();
	}

	static void switchExhaustivenessAndCompatibility() {
		/**
		 * compiler won't require exhaustiveness if it doesn't use any pattern or null label, or if selector
		 * expression is from a legacy type (char, byte, short, int, Character, Byte, Short, Integer, String or a enum)
		 */
		int i = 42;
		switch (i) {
			case 0:
				System.out.println("Zero");
				break;
			case 42:
				System.out.println("42!");
				break;
		}

		var shape = Shape.TRIANGLE;
		// default case way
		switch (shape) {
			case TRIANGLE:
				System.out.println("Is a triangle");
				break;
			case CIRCLE:
				System.out.println("Is a circle");
				break;
		}

		// lambda expression way
		switch (shape) {
			case TRIANGLE -> System.out.println("Is a triangle");
			case CIRCLE -> System.out.println("Is a circle");
		}
		Number number = 42;
		switch(number) {
            case Integer i1 -> System.out.println("Integer");
            case Double d -> System.out.println("Double");
            //case String s -> System.out.println("String");
            case Object o -> System.out.println("Object");
		}
	}

	static void switchExpressionWithPatternMatching() {
		Object obj = 10;

		// if a switch use any feature from the JEP, the compiler will check for exhaustiveness
		String message = switch (obj) {
		
			case Integer i -> { String.format("int %d", i); yield "Hello"; }
			case Double d -> {yield String.format("double %d", d);}
			case String s -> String.format("string %s", s);
			case Object o -> "object";
			// JDK 17: we can test null here, without check before the switch =)
			// switch case without null will throw a NullPointerException (compatibility)
			case null -> "null object";
			// required to be exhaustive
			//default -> obj.toString();
			// we can only combine null with default in a the same case
			//null, default -> obj.toString();
		};
		System.out.println(message);
	}

	static void switchScopeWithPatternMatching() {
		Number number = 42;

		String message = null;

		switch (number) {
			case Integer i when i == 0:
				System.out.println("zero =0");
				// doesn't allow fall-through (must have the break or yield when using `:` in a switch statement or expression)
				// error: illegal fall-through to a pattern
				break;

			case Integer x when x < 0 :
				message = "zero or lower";
				break;
			case Integer n when n == 21:
				message = "half of the answer";
				break;
			case Integer n when n == 42:
				message = "answer";
				break;
			default:
				message = "unhandled";
		}
		System.out.println("switch statement: " + message);

		message = switch (number) {
			case Integer i when i == 0:
				System.out.println("zero =0");
				yield "zero =0";
			case Integer x when x < 0:
				yield "zero or lower";
			case Integer n when n == 21:
				yield "half of the answer";
			case Integer n when n == 42:
				yield "answer";
			default:
				yield "unhandled";
		};
		System.out.println("switch expression: " + message);
	}

	static void switchEnhancedTypeChecking() {
		Object value = 42;
		var message = switch (value) {
			case null -> "The value is `null`";
			case String s -> "Is String: " + s;
			case Integer n -> "is an integer: " + n;
			case Number n -> "Is a Number: " + n;
			case int[] ar -> "Is an array of number: " + ar;
			case List list -> "Is a list of some type: " + list;
			// can infer the record generic type
			case Wrapper(var v) -> "Wrapped value: " + v;
			default -> "Is untested type =(: " + value.toString();
		};
		System.out.println(message);
	}

	
}

enum Shape { CIRCLE, RECTANGLE, TRIANGLE }

record Wrapper<T>(T t) {}






