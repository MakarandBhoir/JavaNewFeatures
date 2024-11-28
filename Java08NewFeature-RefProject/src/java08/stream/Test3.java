package java08.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test3 {
	public static void main(String[] args) {
		Student student1 = new Student(101, "Sneha", 90);
		Student student2 = new Student(102, "Vaibhavi", 88);
		Student student3 = new Student(103, "Vinit", 91);
		Student student4 = new Student(104, "Saurav", 92);
		Student student5 = new Student(105, "Krutika", 90);

		List<Student> studentsList = new ArrayList<>();
		studentsList.add(student1);
		studentsList.add(student2);
		studentsList.add(student3);
		studentsList.add(student4);
		studentsList.add(student5);

		printStudentData(studentsList);
		
	}
	private static void printStudentData(List<Student> list) {
		List<String> names = list.stream().map(student -> student.getStudentName())
		             .collect(Collectors.toList());
		
		list.stream().filter(student -> student.getStudentScore() > 90)
		             .map(e -> e.getStudentName())
		             .forEach(System.out::println);
	}
}









