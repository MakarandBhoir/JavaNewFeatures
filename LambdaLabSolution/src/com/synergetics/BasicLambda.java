package com.synergetics;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class BasicLambda {
	public static void main(String[] args) {
		BasicLambda bl = new BasicLambda();
//        bl.consumer();
//        bl.supplier();
//        bl.predicate();
//        bl.function();

		List<Person> listPeople = getPeople();
		sortAge(listPeople);
		sortName(listPeople);
		sortHeight(listPeople);

	}

	public void consumer() {
		// Printable<T> is a functional interface i.e. one abstract method:
		// void print(T t); // similar to java.util.function.Consumer
		Printable<String> lambda = s -> System.out.println(s);
		lambda.print("Printable lambda");

		// Consumer is a functional interface i.e. one abstract method:
		// void accept(T t)
		Consumer<String> consumer = s -> System.out.println(s);// lambda
		consumer.accept("Consumer lambda");

		Consumer<String> consumerMR = System.out::println; // method reference
		consumerMR.accept("Consumer method reference");

	}

	public void supplier() {
		// Retrievable<T> is a functional interface i.e. one abstract method:
		// T retrieve(); // similar to java.util.function.Supplier
		Retrievable<Integer> lambda = () -> 77;
		System.out.println("Retrievable: " + lambda.retrieve());

		// Supplier<T> is a functional interface i.e. one abstract method:
		// T get()
		Supplier<Integer> supplier = () -> 77;
		System.out.println("Supplier: " + supplier.get());

	}

	public void predicate() {
		// Evaluate<T> is a functional interface i.e. one abstract method:
		// boolean isNegative(T t); // similar to java.util.function.Predicate
//        Evaluate<Integer> lambda = i -> i < 0;
//        System.out.println("Evaluate: " + lambda.isNegative(-1));
//        System.out.println("Evaluate: " + lambda.isNegative(+1));
//
//        // Predicate<T> is a functional interface i.e. one abstract method:
//        //      boolean test(T t)
//        Predicate<Integer> predicate = i -> i < 0;
//        System.out.println("Predicate: " + predicate.test(-1));
//        System.out.println("Predicate: " + predicate.test(+1));

		int x = 4;
		System.out.println("Is " + x + " even? " + check(4, n -> n % 2 == 0));// true
		x = 7;
		System.out.println("Is " + x + " even? " + check(7, n -> n % 2 == 0));// false

		String name = "Mr. Joe Bloggs";
		System.out.println("Does " + name + " start with Mr. ? " + check("Mr. Joe Bloggs", s -> s.startsWith("Mr.")));// true
		name = "Ms. Ann Bloggs";
		System.out.println("Does " + name + " start with Mr. ? " + check("Ms. Ann Bloggs", s -> s.startsWith("Mr.")));// false

		Person person = new Person("Mike", 33, 1.8);
		System.out.println("Is " + person.getName() + " an adult? " + check(person, p -> p.getAge() >= 18));// true
		// boolean test(Person p){
		// return p.getAge() >=18;
		// }
		person = new Person("Ann", 13, 1.4);
		System.out.println("Is " + person.getName() + " an adult? " + check(person, p -> p.getAge() >= 18));// false
	}

	public static <T> boolean check(T t, Predicate<T> lambda) {
		return lambda.test(t);
	}

	public void function() {
		// Functionable<T, R> is a functional interface i.e. one abstract method:
		// R applyThis(T t); // similar to java.util.function.Function
		Functionable<Integer, String> lambda = i -> "Number is: " + i;
		System.out.println("Functionable: " + lambda.applyThis(25));

		// Function<T, R> is a functional interface i.e. one abstract method:
		// R apply(T t)
		Function<Integer, String> function = i -> "Number is: " + i;
		System.out.println("Function: " + function.apply(25));

	}

	private static List<Person> getPeople() {
		List<Person> result = new ArrayList<>();

		result.add(new Person("Mike", 33, 1.8));
		result.add(new Person("Mary", 25, 1.4));
		result.add(new Person("Alan", 34, 1.7));
		result.add(new Person("Zoe", 30, 1.5));
		return result;

	}

	// Java 8
	private static void sortAge(List<Person> listPeople) {
		// sort by age
		// Note: In Java 8, the List interface supports the sort method directly,
		// so no need to use Collections.sort anymore.
		listPeople.sort(Comparator.comparing(p -> p.getAge())); // lambda syntax
		// Comparator.comparing(Person::getAge)); // method reference syntax

		System.out.println("After Sort by Age");
		listPeople.forEach(p -> System.out.println(p)); // lambda
//        listPeople.forEach(System.out::println);  // method reference
	}

	private static void sortHeight(List<Person> listPeople) {
		// Note: In Java 8, the List interface supports the sort method directly,
		// so no need to use Collections.sort anymore.
		listPeople.sort(Comparator.comparing((Person p) -> p.getHeight())); // lambda syntax
		// Comparator.comparing(Person::getHeight)); // method reference syntax

		System.out.println("After Sort by Height");
		listPeople.forEach(p -> System.out.println(p)); // lambda
//        listPeople.forEach(System.out::println);
	}

	private static void sortName(List<Person> listPeople) {
		// Note: In Java 8, the List interface supports the sort method directly,
		// so no need to use Collections.sort anymore.
		listPeople.sort(Comparator.comparing(p -> p.getName())); // lambda syntax
		// Comparator.comparing(Person::getName)); // method reference syntax

		System.out.println("After Sort by Name");
		listPeople.forEach(person -> System.out.println(person)); // lambda
//        listPeople.forEach(System.out::println);
	}
}
