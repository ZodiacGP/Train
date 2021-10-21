package org.zodiac.domain.carriage;

import org.zodiac.domain.Cargo;

import java.util.ArrayList;
import java.util.List;

public class FreightCarriage implements Carriage {
	private final int carryingCapacity;
	private final List<Cargo> cargos = new ArrayList<>();
	private int freeSpace;

	public FreightCarriage() {
		carryingCapacity = freeSpace = 60_000;
	}

	public FreightCarriage(int carryingCapacity) {
		if (carryingCapacity <= 0 || carryingCapacity > 100_000) {
			throw new IllegalArgumentException("Incorrect carrying capacity");
		}
		this.carryingCapacity = freeSpace = carryingCapacity;
	}

	public int freeSpace() {
		return freeSpace;
	}

	public boolean canAccommodateCargo(Cargo cargo) {
		return cargo.getWeight() <= freeSpace;
	}

	public void addCargo(Cargo cargo) {
		if (cargo == null || !canAccommodateCargo(cargo)) {
			throw new IllegalArgumentException("This carriage can't accommodate this cargo");
		}
		cargos.add(cargo);
		freeSpace -= cargo.getWeight();
	}

	public List<Cargo> getCargos() {
		return List.copyOf(cargos);
	}
}
