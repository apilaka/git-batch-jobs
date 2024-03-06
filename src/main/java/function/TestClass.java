package function;

public class TestClass {

	public static void main(String[] args) {
	
		int a =2;
		int b=0;
		
		
		try {
			System.out.println(a/b);
		} catch (ArithmeticException e) {
		System.out.println("Cannot divide by 0");
			//e.printStackTrace();
		}
		
		
		

	}
	
	

}
