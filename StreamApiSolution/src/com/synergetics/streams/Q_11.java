package com.synergetics.streams;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Q_11 {
	public static void main(String[] args) {
		List<AnotherBook> books = Arrays.asList(new AnotherBook("Gone with the wind", "Fiction"),
												new AnotherBook("Bourne Ultimatum", "Thriller"), 
												new AnotherBook("The Client", "Thriller"));
		List<String> genreList = new ArrayList<>();
		books.stream()
//	            .map(book -> book.getGenre())     // lambda
				.map(AnotherBook::getGenre) // method reference
//	            .forEach(s->genreList.add(s));    // lambda
//				.distinct()
				.forEach(genreList::add); // method reference (bound)

		System.out.println(genreList);
	}

}
