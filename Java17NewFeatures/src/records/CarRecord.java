package records;
// regNumber and owner are known as 'components'
public record CarRecord(String regNumber, String owner) implements I {
	// 3. Define an instance method; cannot define an instance field
//    private final int age; // instance fields must be listed in constructor signatiure above
 // 4. Define a static field
    public static final String currentYear = "23";
    public boolean isNewCar(){
        return regNumber().substring(0,2).equals(currentYear);
    }
//    public CarRecord(String regNumber, String owner)  {
//        if(regNumber.length() <= 4){
//            throw new IllegalArgumentException();
//        }
//        this.regNumber=regNumber;
//        this.owner    =owner;
//    }
    
    public CarRecord  {
      if(regNumber.length() <= 4){
          throw new IllegalArgumentException();
      }
    }
    public CarRecord(){
        this("     ", "");
    }
    
    @Override
    public String owner(){
        return owner.toUpperCase();
    }

}

//class X extends CarRecord{}
interface I{}

    /*
// 3. Define an instance method; cannot define an instance field
    private final int age; // instance fields must be listed in constructor signatiure above
    public boolean isNewCar(){
        return regNumber().substring(0,2).equals(currentYear);
    }

// 4. Define a static field
    public static final String currentYear = "23";

// 5. Define a static method
    public static CarRecord createBlankCarRecord(){
        return new CarRecord("     ", "");
    }

// 6. Custom canonical constructor and compact constructor
    // custom canonical constructor
    public CarRecord(String regNumber, String owner)  {
        if(regNumber.length() <= 4){
            throw new IllegalArgumentException();
        }
        this.regNumber=regNumber;
        this.owner    =owner;
    }
    // compact constructor - specific to records
//    public CarRecord  {
//        if(regNumber.length() <= 4){
//            throw new IllegalArgumentException();
//        }
//    }

// 7. Non-canonical record constructor must delegate to another constructor
    public CarRecord(){
        this("     ", "");
    }

// 8. Override the owner() accessor method
    @Override
    public String owner(){
        return owner.toUpperCase();
    }

// 9. Cannot define a subtype based on a record
class X extends CarRecord{}  // records are final by default (cannot define a subtype)

// 10. Can implement an interface

// 11. When defining your record, you cannot extend from another type

*/
//interface I{}
//class A{}




