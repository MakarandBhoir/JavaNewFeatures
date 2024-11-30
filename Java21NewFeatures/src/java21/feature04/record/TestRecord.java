package java21.feature04.record;

public class TestRecord {

	public static void main(String[] args) {
		Student student = new Student();
		
		StudentRecord stuRecord = new StudentRecord(100, "Makarand", 60);
		System.out.println(stuRecord.studentId());
		System.out.println(stuRecord.studentName());
		System.out.println(stuRecord.studentScore());
		
		
		
		System.out.println(stuRecord.getX());
		
		StudentRecord stuRecord2 = new StudentRecord(101);
		
		System.out.println(stuRecord2.studentId());
		System.out.println(stuRecord2.studentName());
		System.out.println(stuRecord2.studentScore());
	}

}
