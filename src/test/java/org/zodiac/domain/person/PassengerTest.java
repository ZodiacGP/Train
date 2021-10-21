package org.zodiac.domain.person;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PassengerTest {

	@Test
	public void checkPassengerCreating_Should_Throw_Exception() {
		assertThrows(IllegalArgumentException.class, () -> new Passenger("John", "Doe", 160));
		assertThrows(IllegalArgumentException.class, () -> new Passenger("John", "Doe", 40, 0));
		assertThrows(IllegalArgumentException.class, () -> new Passenger("John", "Doe", 40, -1));
		assertThrows(IllegalArgumentException.class, () -> new Passenger("John", "Doe", 40, 200));
	}

	@Test
	public void checkGivingTicketMethod_Should_Throw_Exception() {
		Passenger passenger = new Passenger("John", "Doe", 40);
	  	assertThrows(IllegalArgumentException.class, () -> passenger.giveTicket(160));
	  	assertThrows(IllegalArgumentException.class, () -> passenger.giveTicket(0));
	  	assertThrows(IllegalArgumentException.class, () -> passenger.giveTicket(-1));
	  	assertDoesNotThrow(() -> passenger.giveTicket(50));
	  	assertThrows(IllegalArgumentException.class, () -> passenger.giveTicket(50));
	}

	@Test
	public void checkHasTicketMethod_Should_Return_True() {
		Passenger passenger1 = new Passenger("John", "Doe", 40, 25);
		assertTrue(passenger1.hasTicket());
	}

	@Test
	public void checkHasTicketMethod_Should_Return_False() {
		Passenger passenger2= new Passenger("Joe", "Bloggs", 30);
		assertFalse(passenger2.hasTicket());
	}
}