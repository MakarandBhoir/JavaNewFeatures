package java08.featues;

@FunctionalInterface
interface MyInterface {
	void display();
}

public class TestMR1 {
	public void myMethod() {
		System.out.println("Instance Method");
	}

	public static void main(String[] args) {
		MyInterface ref1 = () -> new TestMR1().myMethod();
		
		MyInterface ref2 = new TestMR1() :: myMethod;
		ref2.display();
		
		TestMR1 obj = new TestMR1();
		// Method reference using the object of the class
		
		MyInterface ref = obj::myMethod;
		// Calling the method of functional interface
		ref.display();
	}
}