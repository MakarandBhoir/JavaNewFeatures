package java08.stream;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.stream.Stream;

public class Test01 {
	public static void main(String[] args) {
		String comp[] = { "CLSA", "Tcs", "Capgemini", "JPMC", "Hdfc", "Hsbc", "Itc", "Infinity" };
		List<String> list = Arrays.asList(comp);
		
//		Stream<String> stream1 = list.stream();
//		
//		Consumer<String> consumer = str -> System.out.println(str);
//		stream1.forEach(consumer);
		
		list.stream().map(e -> e.length())
					 .filter( e -> e>=4 )
					 .forEach(System.out::println);
		
	}
}
