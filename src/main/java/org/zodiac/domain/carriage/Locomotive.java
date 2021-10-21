package org.zodiac.domain.carriage;

import org.zodiac.domain.person.Driver;

public class Locomotive implements Carriage {
	private final Driver driver;

	public Locomotive(Driver driver) {
		if (!driver.hasLicense()) {
			throw new IllegalStateException("This person has no license and can't drive a locomotive");
		}
		this.driver = driver;
	}
}
