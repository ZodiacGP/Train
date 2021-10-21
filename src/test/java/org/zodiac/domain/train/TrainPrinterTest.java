package org.zodiac.domain.train;

import org.junit.jupiter.api.Test;
import org.zodiac.domain.carriage.Carriage;
import org.zodiac.domain.carriage.FreightCarriage;
import org.zodiac.domain.carriage.Locomotive;
import org.zodiac.domain.carriage.PassengerCarriage;
import org.zodiac.domain.person.Driver;

import java.util.UnknownFormatConversionException;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.junit.jupiter.api.Assertions.assertThrows;

class TrainPrinterTest {

	@Test
	public void checkPrintMethod() {
		Train train = new Train();
		Driver driver = new Driver("John", "Doe", 23);
		driver.giveLicense();
		Locomotive locomotive = new Locomotive(driver);
		train.addCarriage(locomotive);
		train.addCarriage(new FreightCarriage());
		train.addCarriage(new PassengerCarriage());
		train.addCarriage(locomotive);
		train.addCarriage(new FreightCarriage());
		train.addCarriage(new PassengerCarriage());
		train.addCarriage(new FreightCarriage());
		train.addCarriage(new PassengerCarriage());
		train.addCarriage(new FreightCarriage());
		assertDoesNotThrow(() -> TrainPrinter.printTrain(train));
	}

	@Test
	public void checkPrintMethod_Should_Throw_Exception() {
		assertThrows(IllegalStateException.class, () -> TrainPrinter.printTrain(new Train()));
	}

	@Test
	public void checkPrintMethodWithUnknownCarriage() {
		Train train = new Train();
		Driver driver = new Driver("John", "Doe", 23);
		driver.giveLicense();
		Locomotive locomotive = new Locomotive(driver);
		train.addCarriage(locomotive);
		train.addCarriage(new Carriage() {});
		assertThrows(UnknownFormatConversionException.class, () -> TrainPrinter.printTrain(train));
	}
}