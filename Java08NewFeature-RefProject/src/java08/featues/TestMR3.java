package java08.featues;

import java.util.Arrays;
import java.util.Comparator;

public class TestMR3 {
	
	
	
	public static void main(String[] args) {
		String[] stringArray = { "Jagadesh", "asifa", "Sukrutha", "Navya", "Anish", "Deepak", "Vamsi" };
		/*
		 * Method reference to an instance method of an arbitrary object of a particular
		 * type
		 */
		//Comparator<String> comparator = (s1, s2) -> s1.compareTo(s2);
		//Arrays.sort(stringArray, comparator);
		
		Arrays.sort(stringArray, String::compareTo);
	
		for (String str : stringArray) {
			System.out.println(str);
		}
	}
}