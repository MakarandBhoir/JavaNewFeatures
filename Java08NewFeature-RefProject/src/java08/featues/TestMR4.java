package java08.featues;

@FunctionalInterface
interface MyInterface2 {
	Hello display(String say);
}

interface MyInterface3{
	Hello display();
}

class Hello {
	public Hello(String say) {
		System.out.print(say);
	}
	public Hello() {
		System.out.println("Hello");
	}
}

public class TestMR4 {
	public static void main(String[] args) {
		// Method reference to a constructor
		
		MyInterface2 ref = Hello::new;
		Hello obj = ref.display("Hello World!");
		
		MyInterface3 ref2 = Hello::new;
		ref2.display();
		
		MyInterface3 ref4 = ()-> new Hello("");
	}
}



