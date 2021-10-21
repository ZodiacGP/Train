package org.zodiac.domain.person;

import lombok.Getter;

@Getter
public abstract class Person {
	private final String firstName;
	private final String lastName;
	private final int age;

	public Person(String firstName, String lastName, int age) {
		this.firstName = firstName;
		this.lastName = lastName;
		checkAge(age);
		this.age = age;
	}

	private void checkAge(int age) {
		if (age < 0 || age > 150) {
			throw new IllegalArgumentException("Incorrect age");
		}
	}
}
