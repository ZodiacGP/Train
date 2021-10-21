package org.zodiac.domain;

import lombok.EqualsAndHashCode;
import lombok.Getter;

import java.util.UUID;

@EqualsAndHashCode
@Getter
public class Cargo {
	private final String number;
	private final int weight;

	public Cargo(int weight) {
		number = UUID.randomUUID().toString();
		this.weight = weight;
	}
}
