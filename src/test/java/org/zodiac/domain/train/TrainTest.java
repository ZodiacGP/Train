package org.zodiac.domain.train;

import org.junit.jupiter.api.Test;
import org.zodiac.domain.Cargo;
import org.zodiac.domain.carriage.FreightCarriage;
import org.zodiac.domain.carriage.Locomotive;
import org.zodiac.domain.carriage.PassengerCarriage;
import org.zodiac.domain.person.Driver;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;

class TrainTest {

	@Test
	public void checkTrainCreation() {
		Train train = new Train("1224452324");
		assertFalse(train.getNumber().isEmpty());
	}

	@Test
	public void checkCarriagesAdding() {
		Train train = new Train();
		Driver driver = new Driver("John", "Doe", 23);
		driver.giveLicense();
		assertDoesNotThrow(() -> train.addCarriage(new Locomotive(driver)));
		assertDoesNotThrow(() -> train.addCarriage(new PassengerCarriage()));
		assertDoesNotThrow(() -> train.addCarriage(new FreightCarriage()));
		assertFalse(train.getCarriages().isEmpty());
	}

	@Test
	public void checkCarriagesAdding_Should_Throw_Exception() {
		Train train = new Train();
		assertThrows(IllegalArgumentException.class, () -> train.addCarriage(new PassengerCarriage()));
	}

	@Test
	public void checkFindingFirstSuitableFreightCarriage() {
		Train train = new Train();
		Driver driver = new Driver("John", "Doe", 23);
		driver.giveLicense();
		assertDoesNotThrow(() -> train.addCarriage(new Locomotive(driver)));
		assertDoesNotThrow(() -> train.addCarriage(new PassengerCarriage()));
		assertDoesNotThrow(() -> train.addCarriage(new FreightCarriage()));
		assertNotEquals(Optional.empty(), train.findFirstSuitableFreightCarriage(new Cargo(40_000)));
	}

	@Test
	public void checkFindingFirstSuitableFreightCarriage_Should_Return_Empty() {
		Train train = new Train();
		Driver driver = new Driver("John", "Doe", 23);
		driver.giveLicense();
		assertDoesNotThrow(() -> train.addCarriage(new Locomotive(driver)));
		assertDoesNotThrow(() -> train.addCarriage(new PassengerCarriage()));
		assertDoesNotThrow(() -> train.addCarriage(new FreightCarriage(80_000)));
		assertEquals(Optional.empty(), train.findFirstSuitableFreightCarriage(new Cargo(100_000)));
	}
}