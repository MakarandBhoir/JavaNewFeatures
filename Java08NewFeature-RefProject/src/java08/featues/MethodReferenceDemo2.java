package java08.featues;

import java.util.function.BiFunction;
import java.util.function.Function;
import java.util.function.Supplier;

public class MethodReferenceDemo2 {
    public static void main(String[] args) {
        // No Person being passed in => Supplier
        Supplier<Integer> lambda1 = () -> Student.howMany();
        Supplier<Integer> mr1     = Student::howMany;
        System.out.println(lambda1.get());  // 0
        System.out.println(mr1.get());      // 0

        // One Person to be passed in => Function
        Function<Student, Integer> lambda2 = person -> Student.howMany(person);
        Function<Student, Integer> mr2     = Student::howMany;
        System.out.println(lambda2.apply(new Student()));  // 1
        System.out.println(mr2.apply(new Student()));      // 1

        // Two Person's to be passed in => BiFunction
        BiFunction<Student, Student, Integer> lambda3 = (p1, p2) -> Student.howMany(p1, p2);
        BiFunction<Student, Student, Integer> mr3     = Student::howMany;
        System.out.println(lambda3.apply(new Student(), new Student()));  // 2
        System.out.println(mr3.apply(new Student(), new Student()));      // 2
    }
}
class Student{
    public static Integer howMany(Student... people){
        return people.length;
    } 
}