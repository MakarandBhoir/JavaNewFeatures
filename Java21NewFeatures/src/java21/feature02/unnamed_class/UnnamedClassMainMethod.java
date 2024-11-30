/**
 * To run: `java --enable-preview --source 21 UnnamedClassMainMethod.java`
 * 
 * To compile: `javac --enable-preview --source 21 UnnamedClassMainMethod.java`
 * To run: `java --enable-preview UnnamedClassMainMethod`
 */

// 0. HelloWorld working
// 1. Access instance methods/variables.
// 2. Show error if no main() method present.
// 3. Show error if constructor coded.
// 4. What happens if we try to new UnnamedClassMainMethod()?
// 5. What happens if another class is in this file?

public void main() {
  System.out.println("Welcome To Java 21 World!");
}

/**
 * To see the generated class:
 * - `javac --enable-preview --source 21 UnnamedClassMainMethod.java`
 * - `javap UnnamedClassMainMethod`
 * 
 * Output:
 * 
 * ```
 * Compiled from "UnnamedClassMainMethod.java"
 * final class UnnamedClassMainMethod {
 * UnnamedClassMainMethod();
 * void main();
 * }
 * ```
 */