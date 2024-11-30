package pattern_matching_switch;

sealed abstract class Vehicle permits Car, Boat, Train{
	abstract public String move();
}
final class Car extends Vehicle {
    // custom Car method
    public String move(){
        return "I can move on the road";
    }
}
final class Boat extends Vehicle{
	public String move(){
        return "I can move on the water";
    }
}
final class Train extends Vehicle{
	public String move(){
        return "I can move on the track";
    }
}

public class PatternMatchingSwitchExpressions 
{	
	public static void ifStatements1(Vehicle v)
	{
        if(v instanceof Car){ // Note the 'c' here
        	Car c = (Car) v;
            System.out.println("It's a Car: "+c.move());
        }else if(v instanceof Boat){
            System.out.println("It's a Boat: "+v.move());
        }else if(v instanceof Train){
            System.out.println("It's a Train: "+v.move());
        }else {
            throw new IllegalArgumentException("Invalid type");
        }
    }
	
	
	
	public static void ifStatements(Vehicle v)
	{
        // "...pattern matching introduces new language enhancements that enable you to
        // conditionally extract data from objects with code that's more concise and robust."
        // Pattern matching for instanceof is present since Java 16.
        if(v instanceof Car c){ // Note the 'c' here
            System.out.println("It's a Car: "+c.move());
        }else if(v instanceof Boat b){
            System.out.println("It's a Boat: "+b.move());
        }else if(v instanceof Train t){
            System.out.println("It's a Train: "+t.move());
        }else {
            throw new IllegalArgumentException("Invalid type");
        }
    }
    public static void patternMatchingSwitch(Vehicle v) {
        switch(v){
            // switch expression pattern matching
            case Car c   -> {
                System.out.println("It's a Car");
                System.out.println("It's a Car: "+c.move());
            }
            case Boat b  -> System.out.println("It's a Boat");
            case Train t -> System.out.println("It's a Train");
            default      -> throw new IllegalArgumentException("Invalid type");
        }
    }

    public static void main(String[] args) {
        ifStatements(new Car());
        ifStatements(new Boat());
        ifStatements(new Train());

//        patternMatchingSwitch(new Car());
//        patternMatchingSwitch(new Boat());
//        patternMatchingSwitch(new Train());

    }
}
