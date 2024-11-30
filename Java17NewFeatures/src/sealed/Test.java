package sealed;

sealed interface Drivable permits Vehicle{
	
}
sealed class Vehicle implements Drivable permits Car{
	
}

sealed class Car extends Vehicle permits Ford, Volvo{
	
}

final class Ford extends Car{
	
}

final class Volvo extends Car{
	
}



//class Customer extends Volvo{
//	
//}

public class Test {
	public static void main(String[] args) {

	}
}
