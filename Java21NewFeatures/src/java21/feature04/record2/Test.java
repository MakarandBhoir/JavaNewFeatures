package java21.feature04.record2;

public class Test {
	public static void main(String[] args) {
		DepartmentRecord department = new DepartmentRecord(10, "IT");
		StudentRecord record1 = new StudentRecord(101, "Makarand", 60, department);
		StudentRecord record2 = new StudentRecord(102, "Makarand", 60, department);
		StudentRecord record3 = new StudentRecord(103, "Makarand", 60, department);
		
		
		System.out.println(record1);
		System.out.println(record2);
		System.out.println(record3);
//		System.out.println(record.studentName());
//		System.out.println(record.studentScore());
//		System.out.println(record.studentId());
//		System.out.println(record.deptartment().deptId());
//		System.out.println(record.deptartment().deptName());
		
	}
}
