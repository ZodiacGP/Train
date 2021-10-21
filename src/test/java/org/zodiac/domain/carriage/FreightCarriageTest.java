package org.zodiac.domain.carriage;

import org.junit.jupiter.api.Test;
import org.zodiac.domain.Cargo;

import static org.junit.jupiter.api.Assertions.*;

class FreightCarriageTest {

	@Test
	public void checkFreightCarriageCreating() {
		FreightCarriage freightCarriage = new FreightCarriage();
		assertEquals(60_000, freightCarriage.freeSpace());
		FreightCarriage freightCarriage2 = new FreightCarriage(90_000);
		assertEquals(90_000, freightCarriage2.freeSpace());
	}

	@Test
	public void checkFreightCarriageCreating_Should_Throw_Exception() {
		assertThrows(IllegalArgumentException.class, () -> new FreightCarriage(120_000));
		assertThrows(IllegalArgumentException.class, () -> new FreightCarriage(0));
		assertThrows(IllegalArgumentException.class, () -> new FreightCarriage(-1));
	}

	@Test
	public void checkCargoAdding() {
		FreightCarriage freightCarriage = new FreightCarriage(80_000);
		freightCarriage.addCargo(new Cargo(20_000));
		assertFalse(freightCarriage.getCargos().isEmpty());
		assertEquals(60_000, freightCarriage.freeSpace());
	}

	@Test
	public void checkCargoAdding_Should_Throw_Exception() {
		FreightCarriage freightCarriage = new FreightCarriage(60_000);
		assertThrows(IllegalArgumentException.class, () -> freightCarriage.addCargo(new Cargo(70_000)));
		assertThrows(IllegalArgumentException.class, () -> freightCarriage.addCargo(null));
	}
}