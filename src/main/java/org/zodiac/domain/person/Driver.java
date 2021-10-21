package org.zodiac.domain.person;

public class Driver extends Person {
	private boolean license;

	public Driver(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}

	public void giveLicense() {
		if (license) {
			throw new IllegalStateException("This person already has license");
		}
		if (this.getAge() < 18) {
			throw new IllegalStateException("This person is underage");
		}
		license = true;
	}

	public boolean hasLicense() {
		return license;
	}
}
