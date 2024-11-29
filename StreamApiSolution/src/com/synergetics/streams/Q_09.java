package com.synergetics.streams;

import java.util.Arrays;
import java.util.List;

public class Q_09 {
	public static void main(String[] args) {

		List<Person> friends = Arrays.asList(new Person("Bob", "Kelly", 31), 
											new Person("Paul", "Landers", 32),
											new Person("John", "Paters", 33));
		double averageAge = friends.stream()
				.filter(person -> person.getAge() < 30)
				.mapToInt(person -> person.getAge())
				.average()
//	            .getAsDouble(); // NoSuchElementException: No value present
				.orElse(0.0);// 0.0
		System.out.println(averageAge);
	}

}
