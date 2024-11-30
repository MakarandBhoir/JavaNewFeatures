package java21.feature04.record;

//0. Class object and records object
//1. Define an instance method, cannot define an instance field
//2. Define static field
//3. Define static method
//4. Custom canonical constructor and compact constructor
//5. Non-canonical records constructor must delegate to other constructor
//6. Override the accessor method
//7. Cannot define a subtype based on record
//8. Can implemt an interface
//9. Cannot extends from another type

public final record StudentRecord(int studentId, String studentName, double studentScore) implements I1{
	
	static int x = 100;
	
	int getX() {
		return x;
	}

	@Override
	public String studentName() {
		return this.studentName.toUpperCase();
	}
	
//	public void setStudentId(int studentId) {
//		this.studentId = studentId;
//	}
	
	public StudentRecord(int studentId) {
		this(studentId, "No Student", 0.0);
	}
}


interface I1{
	
}