package java21.feature05.record_pattern;

public class TestRecordPatterns {
	public static void main(String[] args) {
		recordPattern();
	}

	public static void recordPattern() {
		Person p1 = new Person("Makarand Bhoir", 38);
		Person p2 = new Person("Deepak Goyal", 40);
        nonNesting(p1);  // Makarand Bhoir: 38
        nonNesting(p2);  // Deepak Goyal : 40

		Player player1 = new Player(p1, Ability.WEAK);
		Player player2 = new Player(p2, Ability.STRONG);
		Doubles dbles = new Doubles(player1, player2);
//		nesting(dbles);
	}

	public static void nonNesting(Object obj) {
		// Inside instanceof `Person(String s, Integer nAge)` is a "record pattern" which does 2 things:
		// 1. Tests whether the object is of type Person (as usual)
		// 2. Extracts the records components by invoking the component accessor
		// methods on our behalf.
		if (obj instanceof Person(String s, Integer nAge)) { // record pattern
			System.out.println(s + " : " + nAge);
		}
	}

//	public static void nesting(Doubles dbles) {
//		// straightforward nesting
//		if (dbles instanceof Doubles(Player pl1, Player pl2)) { // LVTI works also
//			System.out.println(pl1.person() + "; " + pl1.ability());
//			System.out.println(pl2.person() + "; " + pl2.ability());
//		}
//		// more complex nesting
//		if (dbles instanceof Doubles(Player(Person p1, Ability ability), var pl2)) { // LVTI works also
//			System.out.println(p1.name() + "; " + p1.age() + "; " + ability.name());
//			System.out.println(pl2.person());
//		}
//	}
}
