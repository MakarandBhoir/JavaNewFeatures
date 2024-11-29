package com.synergetics.streams;

import java.util.Arrays;
import java.util.List;

public class Q_06 {
	public static void main(String[] args) {
		List<Book> books = Arrays.asList(new Book("Thinking in Java", 30.0), 
				new Book("Java in 24 hrs", 20.0),
				new Book("Java Recipies", 10.0));
		
		double averagePrice = books.stream()
									.filter(book -> book.getPrice() > 10)
									.mapToDouble(book -> book.getPrice())
									// OptionalDouble average() - terminal operation
									.average()
//									.getAsDouble(); 
									.orElse(0.0); // useful if filter filters out ALL of the Books
		System.out.println(averagePrice);
	}
}
