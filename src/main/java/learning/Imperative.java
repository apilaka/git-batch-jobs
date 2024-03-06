package learning;

import java.util.List;

public class Imperative {

	public static void main(String[] args) {
		List<Person> persons = List.of (
			new Person("John", Gender.FEMALE),
			new Person("John", Gender.MALE),
			new Person("John", Gender.MALE),
			new Person("John", Gender.MALE),
			new Person("John", Gender.FEMALE),
			new Person("John", Gender.MALE)		
		);
		
		System.out.println("all");
		persons.forEach(p->{
			System.out.println(p.toString());
		});
		System.out.println("FEMALE");
		persons.stream()
		.filter(person->!Gender.FEMALE.equals(person.gender))
		//.collect(Collectors.toList())
		.forEach(p->{
			System.out.println(p.toString());
		});


	}
	static class Person {
		private  final String name;
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
