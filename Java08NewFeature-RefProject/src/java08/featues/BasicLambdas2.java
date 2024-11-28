package java08.featues;
@FunctionalInterface
interface Max{
	int max(int n1, int n2);
}

public class BasicLambdas2 {
	public static void main(String[] args) {
		// version 1
		Max lambdaExpression1 = (int n1, int n2)->{
			if(n1>n2) {
				return n1;
			}else {
				return n2;
			}
		};
		
		// version 2
		Max lambdaExpression2 = (n1, n2)->{
			if(n1>n2) {
				return n1;
			}else {
				return n2;
			}
		};
		
		// version 3
		Max lambdaExpression3 = (n1, n2) -> (n1 > n2)?n1:n2;
		
		System.out.println("Max: "+lambdaExpression1.max(100, 99));
		System.out.println("Max: "+lambdaExpression2.max(100, 99));
		System.out.println("Max: "+lambdaExpression3.max(100, 99));
				
	}
}
