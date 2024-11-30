package java21.feature04.record2;

public class Test2 {
	public static void main(String[] args) {
		DepartmentRecord department1 = new DepartmentRecord(10, "IT");
		DepartmentRecord department2 = new DepartmentRecord(20, "Civil");
		
		StudentRecord student1 = new StudentRecord(101, "Makarand", 60, department1);
		StudentRecord student2 = new StudentRecord(102, "Vijay", 80, department2);
		StudentRecord student3 = new StudentRecord(103, "Rahul", 85, department1);
		StudentRecord student4 = new StudentRecord(104, "Sam", 70, department2);
		StudentRecord student5 = new StudentRecord(105, "Rina", 81, department1);
		
		
		StudentRecord arr[] = new StudentRecord[5];
		arr[0] = student1;
		arr[1] = student2;
		arr[2] = student3;
		arr[3] = student4;
		arr[4] = student5;

		findById(arr, 102);

	}

	private static void findById(StudentRecord[] arr, int id) {
		for(StudentRecord student : arr) {
			switch(student) {
			case StudentRecord s when s.studentId()==id -> System.out.println(s);
			
			//default -> System.out.println("Default");
			}
		}
	}
}
