package eu.codeacademy.db.model;

import java.util.StringJoiner;

public class Auto {
	private final String number;

	public Auto(String number) {
		this.number = number;
	}

	public String getNumber() {
		return number;
	}

	@Override
	public String toString() {
		return new StringJoiner(", ", Auto.class.getSimpleName() + "[", "]")
				.add("number='" + number + "'")
				.toString();
	}
}
