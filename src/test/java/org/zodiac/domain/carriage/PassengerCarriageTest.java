package org.zodiac.domain.carriage;

import org.junit.jupiter.api.Test;
import org.zodiac.domain.person.Passenger;

import static org.junit.jupiter.api.Assertions.*;

class PassengerCarriageTest {

	@Test
	public void checkPassengerCarriageCreating() {
		assertDoesNotThrow(() -> new PassengerCarriage());
		assertDoesNotThrow(() -> new PassengerCarriage(100));
	}

	@Test
	public void checkPassengerCarriageCreating_Should_Throw_Exception() {
		assertThrows(IllegalArgumentException.class, () -> new PassengerCarriage(200));
	}

	@Test
	public void checkPassengersAdding() {
		PassengerCarriage passengerCarriage = new PassengerCarriage(100);
		Passenger passenger = new Passenger("John", "Doe", 15, 30);
		assertDoesNotThrow(() -> passengerCarriage.addPassenger(passenger));
	}

	@Test
	public void checkPassengersAdding_Should_Throw_Exception() {
		PassengerCarriage passengerCarriage = new PassengerCarriage(100);

		Passenger passenger1 = new Passenger("John", "Doe", 15, 130);
		assertThrows(IllegalArgumentException.class, () -> passengerCarriage.addPassenger(passenger1));

		Passenger passenger2 = new Passenger("John", "Doe", 15);
		assertThrows(IllegalStateException.class, () -> passengerCarriage.addPassenger(passenger2));

		Passenger passenger3 = new Passenger("John", "Doe", 15, 30);
		assertDoesNotThrow(() -> passengerCarriage.addPassenger(passenger3));

		Passenger passenger4 = new Passenger("Joe", "Bloggs", 25, 30);
		assertThrows(IllegalStateException.class, () -> passengerCarriage.addPassenger(passenger4));
	}

	@Test
	public void checkNumberOfFreeSeatsMethod() {
		PassengerCarriage passengerCarriage = new PassengerCarriage();
		assertEquals(passengerCarriage.numberOfFreeSeats(), passengerCarriage.numberOfSeats());
		passengerCarriage.addPassenger(new Passenger("John", "Doe", 15, 25));
		assertNotEquals(passengerCarriage.numberOfSeats(), passengerCarriage.numberOfFreeSeats());
	}
}