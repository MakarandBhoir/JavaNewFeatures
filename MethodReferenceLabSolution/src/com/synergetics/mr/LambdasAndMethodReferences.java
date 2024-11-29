package com.synergetics.mr;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class LambdasAndMethodReferences {
	public static void main(String[] args) {
//        staticMR();
//        boundMR();
//		  unboundMR();
//        constructorMR();
	}

	public static void staticMR() {
		// a
		List<Integer> list = Arrays.asList(1, 2, 7, 4, 5);

		// b
		Consumer<List<Integer>> lambda = l -> Collections.sort(l); // define the lambda
		System.out.println(list); // [1, 2, 7, 4, 5]

		// c and d
		lambda.accept(list); // execute the lambda
		System.out.println(list); // [1, 2, 4, 5, 7]

		// e
		list = Arrays.asList(1, 2, 7, 4, 5); // unsort them again

		// f
		// Java infers what to do from the *context* i.e. we are creating a Consumer
		// and its functional method 'accept(T t)' takes one parameter; thus, it
		// invokes the 'sort(List)' as per the lambda syntax above.
		Consumer<List<Integer>> methodRef = Collections::sort;
		System.out.println(list); // [1, 2, 7, 4, 5]

		// g and h
		methodRef.accept(list);
		System.out.println(list); // [1, 2, 4, 5, 7]
	}

	public static void boundMR() {
		// a
		String name = "Mr. Joe Bloggs";

		// b
		Predicate<String> lambda = prefix -> name.startsWith(prefix); // 'name' is a local variable in the method

		// c and d
		System.out.println(lambda.test("Mr."));// true
		System.out.println(lambda.test("Ms."));// false

		// e and f
		// 'name' is a String and String has a 'startsWith' method.
		// The argument required by 'startsWith' will be passed in when
		// we invoke the method reference i.e. name.startsWith(arg).
		Predicate<String> methodRef = name::startsWith;
		System.out.println(methodRef.test("Mr."));// true
		System.out.println(methodRef.test("Ms."));// false
	}

	public static void unboundMR() {
		// a
		Predicate<String> lambda = str -> str.isEmpty(); // no 'str' local variable in the method
		// b and c
		System.out.println(lambda.test("")); // true "".isEmpty();
		System.out.println(lambda.test("xyz")); // false "xyz".isEmpty();

		// d
		// 'isEmpty' is a String method and will be executed on a String instance passed
		// in
		// when we invoke the method reference.
		Predicate<String> methodRef = String::isEmpty;
		// e
		System.out.println(methodRef.test("")); // true "".isEmpty();
		System.out.println(methodRef.test("xyz")); // false "xyz".isEmpty();

		// f
		// Now we are working with a BiPredicate i.e. 2 parameters.
		// What does Java do with them?
		// The first argument will always be the instance of the object for instance methods.
		// The second (and other) arguments are method parameters.
		BiPredicate<String, String> lambda2 = (str, prefix) -> str.startsWith(prefix);
		System.out.println(lambda2.test("Mr. Joe Bloggs", "Mr.")); // true "Mr. Joe Bloggs".startsWith("Mr.")
		System.out.println(lambda2.test("Mr. Joe Bloggs", "Ms.")); // false "Mr. Joe Bloggs".startsWith("Ms.")

		// g and h
		// Context - BiPredicate takes two args,
		// The first is the one that 'startsWith' will be executed on
		// The second argument and subsequent arguments are passed in as as arguments to 'startsWith'
		BiPredicate<String, String> methodRef2 = String::startsWith;

		System.out.println(methodRef2.test("Mr. Joe Bloggs", "Mr.")); // true "Mr. Joe Bloggs".startsWith("Mr.")
		System.out.println(methodRef2.test("Mr. Joe Bloggs", "Ms.")); // false "Mr. Joe Bloggs".startsWith("Ms.")
	}

	public static void constructorMR() {
		// a
		Supplier<List<String>> lambda = () -> new ArrayList();
		// b
		List<String> list = lambda.get();
		// c
		list.add("Lambda");
		// d
		System.out.println(list); // [Lambda]
		
		// e
		Supplier<List<String>> methodRef = ArrayList::new;
		// i
		list = methodRef.get();
		// ii
		list.add("Method Reference");
		//  iii
		System.out.println(list); // [Method Reference]

		// f
		// Now, we want to call the overloaded ArrayList(int initialCapacity) constructor.
		// We need to pass IN something and get something OUT i.e. use a Function.
		Function<Integer, List<String>> lambda2 = n -> new ArrayList(n);
		list = lambda2.apply(10);
		list.add("Lambda");
		System.out.println(list); // [Lambda]

		// Do the last Method Reference dynamically => demonstrate **context**
		Function<Integer, List<String>> methodRef2 = ArrayList::new;
		list = methodRef2.apply(20);
		list.add("Method Reference");
		System.out.println(list); // [Lambda]
	}

}
