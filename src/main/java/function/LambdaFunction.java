package function;

import java.util.function.BiFunction;
import java.util.function.Function;

public class LambdaFunction {
	
	public static void main(String[] args) {
		
		System.out.println(tomakeUpper.apply("Pilaka ",70));
	}
	
	static BiFunction<String, Integer, String> tomakeUpper =(name, in)-> {
		
		if(name.isBlank())
				throw new IllegalArgumentException();
		return name.toUpperCase()+in;
						
		
		};

}
