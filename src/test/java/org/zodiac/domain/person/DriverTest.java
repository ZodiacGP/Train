package org.zodiac.domain.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

	@Test
	public void checkDriverCreating() {
		assertDoesNotThrow(() -> new Driver("John", "Doe", 23));
		assertDoesNotThrow(() -> new Driver("John", "Doe", 63));
	}

	@Test
	public void checkGiveLicenseMethod_Should_Throw_Exception() {
		Driver child = new Driver("John", "Doe", 13);
		assertThrows(IllegalStateException.class, child::giveLicense);

		Driver adult = new Driver("Joe", "Bloggs", 23);
		assertDoesNotThrow(adult::giveLicense);
		assertThrows(IllegalStateException.class, adult::giveLicense);
	}

	@Test
	public void checkHasLicenseMethod_Should_Return_True() {
		Driver adult = new Driver("Joe", "Bloggs", 23);
		assertDoesNotThrow(adult::giveLicense);
		assertTrue(adult.hasLicense());
	}

	@Test
	public void checkHasLicenseMethod_Should_Return_False() {
		Driver adult = new Driver("Joe", "Bloggs", 23);
		assertFalse(adult.hasLicense());
	}
}