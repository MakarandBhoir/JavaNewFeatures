package java21.feature05.record_pattern;

public class TestRecords {
	public static void main(String[] args) {
		records();
	}

	public static void records() {
		Person p1 = new Person("Deepak", 40);		
		System.out.println(p1);
		System.out.println(p1.name() + "; " + p1.age());
//		patternMatching(p1); // Name: Deepak, Age: 40
		
		patternMatching("Makarand Bhoir");
//
		Pair<String> pair1 = new Pair<>("Makarand", "Bhoir");
		Pair<Integer> pair2 = new Pair<>(10, 20);
//		patternMatching(pair1); // x: Makarand, y: Bhoir
//		patternMatching(pair2); // x: 10, y: 20
	}

	public static void patternMatching(Object obj) {
		// "Person person" is a "type pattern". At runtime, "pattern matching" is
		// performed by instanceof to see if "obj" is referring to a Person object;
		// is so, "person" is made to refer to that Person object.
		
		if (obj instanceof Person person) {
			System.out.println("Name: " + person.name() + ", Age: " + person.age());
		} else if (obj instanceof Pair pair) {
			System.out.println("x: " + pair.x() + ", y: " + pair.y());
		}else {
			System.out.println(obj.toString() + " Nighter instance Person nor Pair. It is instance of "+obj.getClass().getName());
		}

	}
}

// old pre-Java 16 instanceof-and-cast idiom
//        if(obj instanceof String){
//            String s = (String)obj;
//            System.out.println(s.toUpperCase());
//        }

// new post-Java 16 idiom
//        if(obj instanceof String s){
//            System.out.println(s.toUpperCase());
//        }
