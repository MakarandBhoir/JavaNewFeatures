package java08.featues;

// Define a functional interface
@FunctionalInterface
interface Greeting {
    void sayHello(String name);
}

public class LambdaExample {
    public static void main(String[] args) {
        // Using a lambda expression to implement the Greeting interface
        Greeting greeting = (name) -> System.out.println("Hello, " + name + "!");

        // Call the method
        greeting.sayHello("World");
    }
}
