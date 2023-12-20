package eu.codeacademy.db.model;

import java.util.StringJoiner;

public class Person {

	private final String name;
	private final String surname;
	private final short age;

	public Person(String name, String surname, short age) {
		this.name = name;
		this.surname = surname;
		this.age = age;
	}

	public String getName() {
		return name;
	}

	public String getSurname() {
		return surname;
	}

	public short getAge() {
		return age;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Person.class.getSimpleName() + "[", "]")
				.add("name='" + name + "'")
				.add("surname='" + surname + "'")
				.add("age=" + age)
				.toString();
	}
}
