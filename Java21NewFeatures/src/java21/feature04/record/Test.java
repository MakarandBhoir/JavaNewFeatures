package java21.feature04.record;

public class Test {
	public static void main(String[] args) {
		StudentRecord record = new StudentRecord(100, "Makarand", 60);
		System.out.println(record);
		System.out.println(record.studentName());
		System.out.println(record.studentScore());
		System.out.println(record.studentId());
	}
}
