package java08.stream;

import java.util.stream.Stream;

public class PipelineProcessingOrder {
	public static void main(String[] args) {

		Stream.of("Alex", "David", "April", "Edward").filter(s -> {
			System.out.println("filter: " + s);
			return true;
		}).forEach(s -> System.out.println("forEach: " + s));

		
		Stream.of("Alex", "David", "April", "Edward").map(s -> {
			System.out.println("map: " + s);
			return s.toUpperCase();
		}).anyMatch(s -> { // ends when first true is returned (Alex)
			System.out.println("anyMatch: " + s);
			return s.startsWith("D");
		});
	}
}
