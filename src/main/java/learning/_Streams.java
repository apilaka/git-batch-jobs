package learning;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class _Streams {
	public static void main(String[] args) {

		List<Person> people = List.of(new Person("Maria", Gender.FEMALE), new Person("John", Gender.MALE),
				new Person("Aisha", Gender.MALE), new Person("John", Gender.MALE), new Person("Aysha", Gender.FEMALE),
				new Person("Alex", Gender.MALE));
		people.stream().map(person -> person.gender).collect(Collectors.toList()).forEach(p -> {
			System.out.println(p.toString());
		});
		people.stream().map(p -> p.name).mapToInt(String::length).forEach(System.out::println);
		Boolean allMales =people.stream().allMatch(p->Gender.FEMALE.equals(p.gender));
		Boolean nonMatch =people.stream().anyMatch(p->Gender.FEMALE.equals(p.gender));
		System.out.println(allMales);
		System.out.println(nonMatch);
	Object value = Optional.ofNullable("India").orElseThrow(()-> new IllegalStateException());
		System.out.println(value);
//	Optional.ofNullable("apilaka@yahoo.ca").ifPresent(email->Gender.FEMALE.equals(email)->{
//		
//	});
	
	Optional.ofNullable(null).ifPresentOrElse(email->System.out.println("sending mail to "+email), 
			()->{System.out.println("Email not available");});
	}
Optional<Person> value = Optional.empty();
 

	static class Person {
		private final String name;
		final Gender gender;

		public Person(String name, Gender gender) {
			super();
			this.name = name;
			this.gender = gender;
		}

		@Override
		public String toString() {
			return "Person [name=" + name + ", gender=" + gender + "]";
		}

	}

	enum Gender {
		MALE, FEMALE
	}
}
