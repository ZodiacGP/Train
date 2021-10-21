package org.zodiac.domain.carriage;

import org.junit.jupiter.api.Test;
import org.zodiac.domain.person.Driver;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class LocomotiveTest {

	@Test
	public void checkLocomotiveCreation() {
		Driver driver = new Driver("John", "Doe", 23);
		driver.giveLicense();
		assertDoesNotThrow(() -> new Locomotive(driver));
	}

	@Test
	public void checkLocomotiveCreation_Should_Throw_Exception() {
		Driver driver = new Driver("John", "Doe", 23);
		assertThrows(IllegalStateException.class, () -> new Locomotive(driver));
	}
}