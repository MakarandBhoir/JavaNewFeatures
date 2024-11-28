package java08.featues;

@FunctionalInterface
interface I{
	void m(int version); // a function interface i.e. it has only one
			  // abstract method	
}

public class BasicLambdas {
	public static void main(String[] args) {
		
		System.out.println();
		// pre-Java 8
		I i = new I() {
			@Override
			public void m(int version) {
				System.out.println("Old version");
			}
		};
		i.m(0); // I::m()
		
		I lambdaI = (int v1)->{
			System.out.println("Lambda version "+v1);
		};
		I lambdaI2 = (v2) -> System.out.println("Lambda version "+v2);
		
		I lambdaI3 = v3 -> System.out.println("Lambda version "+v3);
		lambdaI.m(1);
		lambdaI2.m(2);
		lambdaI3.m(3);
	}
	// write function 2 add two numbers
	
}
