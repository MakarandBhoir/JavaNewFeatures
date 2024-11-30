package java21.feature07.sealed_classes;

// sealed classes can specify which are allowed child classes.
sealed class Account permits SavingAccount, CurrentAccount{
	
}

// This class should be declared as final / sealed / non-sealed
final class SavingAccount extends Account{
	
}

// non-sealed classes can be extended if you don't want declare final
//non-sealed class CurrentAccount extends Account {
//	
//}

final class CurrentAccount extends Account {
	
}

// you can not extends Account class.
class Shape {
	
}

public class Test {
	public static void main(String[] args) {

	}
}
