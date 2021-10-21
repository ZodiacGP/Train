package org.zodiac.domain.carriage;

import org.zodiac.domain.person.Passenger;

import java.util.HashMap;
import java.util.Map;

public class PassengerCarriage implements Carriage {
	private final Map<Integer, Passenger> passengers = new HashMap<>();
	private final int seats;

	public PassengerCarriage() {
		seats = 60;
	}

	public PassengerCarriage(int seats) {
		if (seats <= 0 || seats > 150) {
			throw new IllegalArgumentException("Invalid number of seats");
		}
		this.seats = seats;
	}

	public int numberOfFreeSeats() {
		return seats - passengers.size();
	}

	public int numberOfSeats() {
		return seats;
	}

	public Passenger addPassenger(Passenger passenger) {
		if (!passenger.hasTicket()) {
			throw new IllegalStateException("This passenger has no ticket");
		}
		if (passenger.getSeat() > seats) {
			throw new IllegalArgumentException("There is no such seat in the train");
		}
		if (passengers.containsKey(passenger.getSeat())) {
			throw new IllegalStateException("This seat is already taken");
		}
		passengers.put(passenger.getSeat(), passenger);
		return passenger;
	}
}
