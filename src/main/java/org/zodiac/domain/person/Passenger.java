package org.zodiac.domain.person;

import lombok.Getter;

@Getter
public class Passenger extends Person {
	private int seat;

	public Passenger(String firstName, String lastName, int age) {
		super(firstName, lastName, age);
	}

	public Passenger(String firstName, String lastName, int age, int seat) {
		super(firstName, lastName, age);
		validateSeat(seat);
		this.seat = seat;
	}

	public boolean hasTicket() {
		return seat > 0;
	}

	private void validateSeat(int seat) {
		if (seat < 1 || seat > 150) {
			throw new IllegalArgumentException("Invalid seat number");
		}
	}

	public void giveTicket(int seat) {
		validateSeat(seat);
		if (this.seat == seat) {
			throw new IllegalArgumentException("This person already has this ticket");
		}
		this.seat = seat;
	}
}
