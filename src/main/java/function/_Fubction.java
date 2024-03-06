package function;

import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@Data
public class _Fubction {

	public static void main(String[] args) {

		System.out.println(incrementBy1.apply(1));
		int a = incrementBy1.apply(2);
		System.out.println(addTwoInts.apply(5, 6));
		System.out.println(multiplyBy10.apply(20));
		System.out.println(incrementBy1.apply(multiplyBy10.apply(20)));
		Customer customer = null;
		System.out.println(greetCustomer.apply(customer));
		System.out.println(greetCustomerBi.apply(customer, "pilska"));
		greetCustomerConsumer.accept(customer);
		greetBiCustomerConsumer.accept(customer, true);
		greetBiCustomerConsumer.accept(customer, false);
		System.out.println(validatePhone.test(customer));
		System.out.println(getLink.get());
	}

	static Consumer<Customer> greetCustomerConsumer = customer -> System.out
			.println("Consumer " + customer.getName() + "  " + customer.getPhone());
	static BiConsumer<Customer, Boolean> greetBiCustomerConsumer = ((customer, showPhone) -> System.out.println(
			showPhone ? "Consumer has phone" + customer.getName() + "  " + customer.getPhone() : "there is no phone"));
	static Predicate<Customer> validatePhone = customer -> customer.phone.startsWith("9");
	static Supplier<List> getLink = () -> List.of("He is good", "He is good", "He is good");

	static Function<Integer, Integer> incrementBy1 = a -> a + 1;
	static BiFunction<Integer, Integer, Integer> addTwoInts = (a, b) -> a + b;
	static Function<Integer, Integer> multiplyBy10 = a -> a * 10;
	static Function<Customer, String> greetCustomer = customer -> "Hello " + customer.getName()
			+ " Thanks for registering " + customer.getPhone();
	static BiFunction<Customer, String, String> greetCustomerBi = (customer, s) -> s + " Hello " + customer.getName()
			+ " Thanks for registering " + customer.getPhone();

}
