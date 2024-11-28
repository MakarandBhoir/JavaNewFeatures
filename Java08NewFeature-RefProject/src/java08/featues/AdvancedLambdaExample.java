
package java08.featues;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

// Define a custom class
class Person {
	private String name;
	private int age;

	public Person(String name, int age) {
		this.name = name;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public int getAge() {
		return age;
	}

	@Override
	public String toString() {
		return name + " (" + age + ")";
	}
}

public class AdvancedLambdaExample {
	public static void main(String[] args) {
		List<Person> people = new ArrayList<>();
		people.add(new Person("Alice", 30));
		people.add(new Person("Bob", 25));
		people.add(new Person("Charlie", 35));

		// Sort by age using a lambda expression
		people.sort((p1, p2) -> Integer.compare(p1.getAge(), p2.getAge()));

		// Print the sorted list
		System.out.println("Sorted by age:");
		people.forEach(person -> System.out.println(person));

		// Sort by name using a method reference
		people.sort(Comparator.comparing(Person::getName));

		// Print the sorted list
		System.out.println("Sorted by name:");
		people.forEach(System.out::println);
	}
}
