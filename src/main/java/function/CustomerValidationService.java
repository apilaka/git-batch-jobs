package function;

import java.time.LocalDate;
import java.util.Date;
import java.util.function.Consumer;
import java.util.function.Predicate;

import learning.CustomerRegistrationValidator;

public class CustomerValidationService implements CustomerRegistrationValidator {

	public static void main(String[] args) {
		Customer customer = new Customer("Ananta", "apilaka@yahoo.ca", "804267-0940", LocalDate.now());
		CustomerValidationService service = new CustomerValidationService();
		hello("ananta", null, value -> {
			System.out.println("no last name provided for value " + value);

		});
		hello2("ananta", "Karima", () -> {
			System.out.println("no last name provided for value h2llo2 ");

		});
		
	}

	static boolean isEmailVald(Customer customer) {
		return customer.getEmail().contains("@");
	}

	static Predicate<Customer> isEmailValdV2 = (customer) -> customer.getEmail().contains("@");

	@Override
	public CustomerValidationResult apply(Customer t) {
		CustomerValidationResult result = this.apply(t);
		return result;

	}

	static void hello(String firstname, String lastname, Consumer<String> callback) {
		System.out.println(firstname);
		if (lastname != null) {
			System.out.println(lastname);
		} else {
			callback.accept(lastname);

		}
	}
	
	static void hello2(String firstname, String lastname, Runnable callback) {
		System.out.println(firstname);
		if (lastname != null) {
			System.out.println(lastname);
		} else {
			callback.run();

		}
	}


}
