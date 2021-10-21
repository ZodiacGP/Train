package org.zodiac.domain.train;

import org.zodiac.domain.carriage.Carriage;
import org.zodiac.domain.carriage.FreightCarriage;
import org.zodiac.domain.carriage.Locomotive;
import org.zodiac.domain.carriage.PassengerCarriage;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.UnknownFormatConversionException;
import java.util.stream.IntStream;

/*
 * Just
 * For
 * Fun
 */

public class TrainPrinter {

	private final static String l1 = "      ====        ________                ___________";
	private final static String l2 = "  _D _|  |_______/        \\__I_I_____===__|_________|";
	private final static String l3 = "   |(_)---  |   H\\________/ |   |        =|___ ___|  ";
	private final static String l4 = "   /     |  |   H  |  |     |   |         ||_| |_||  ";
	private final static String l5 = "  |      |  |   H  |__--------------------| [___] |  ";
	private final static String l6 = "  | ________|___H__/__|_____/[][]~\\_______|       |  ";
	private final static String l7 = "__|/ |   |-----------I_____I [][] []  D   |=======|__";
	private final static String l8 = "__/ =| o |=-~~\\  /~~\\  /~~\\  /~~\\ ____Y___________|__";
	private final static String l9 = "|/-=|___|=    ||    ||    ||    |_____/~\\___/        ";
	private final static String l10 = " \\_/      \\O=====O=====O=====O_/      \\_/            ";
	private final static List<String> locomotive =
			List.of(l1, l2, l3, l4, l5, l6, l7, l8, l9, l10);


	private final static String fc1 = "                              ";
	private final static String fc2 = "                              ";
	private final static String fc3 = "    _________________         ";
	private final static String fc4 = "  _|                \\_____A   ";
	private final static String fc5 = " =|                        |  ";
	private final static String fc6 = " -|                        |  ";
	private final static String fc7 = "__|________________________|__";
	private final static String fc8 = "___________________________|__";
	private final static String fc9 = "   |_D__D__D_|  |_D__D__D_|   ";
	private final static String fc10 = "    \\_/   \\_/    \\_/   \\_/    ";
	private final static List<String> freightCarriage =
			List.of(fc1, fc2, fc3, fc4, fc5, fc6, fc7, fc8, fc9, fc10);

	private final static String pc1 = "                                ";
	private final static String pc2 = "                                ";
	private final static String pc3 = "  __________________________  ";
	private final static String pc4 = "  |                        |  ";
	private final static String pc5 = "  |   ___    ___    ___    |  ";
	private final static String pc6 = "  |   |_|    |_|    |_|    |  ";
	private final static String pc7 = "__|________________________|__";
	private final static String pc8 = "__|________________________|__";
	private final static String pc9 = "   |_D__D__D_|  |_D__D__D_|   ";
	private final static String pc10 = "    \\_/   \\_/    \\_/   \\_/    ";
	private final static List<String> passengerCarriage =
			List.of(pc1, pc2, pc3, pc4, pc5, pc6, pc7, pc8, pc9, pc10);


	private static List<String> checkCarriageType(Carriage carriage) {
		if (carriage instanceof Locomotive) {
			return locomotive;
		} else if (carriage instanceof FreightCarriage) {
			return freightCarriage;
		} else if (carriage instanceof PassengerCarriage) {
			return passengerCarriage;
		}
		return Collections.emptyList();
	}

	private static List<StringBuilder> createTrainForPrinting(Train train) {
		List<Carriage> carriages = train.getCarriages();
		if (!carriages.isEmpty()) {
			List<StringBuilder> list = new ArrayList<>(10);

			for (Carriage c : carriages) {
				List<String> carriageImage = checkCarriageType(c);
				if (carriageImage.isEmpty()) {
					throw new UnknownFormatConversionException("Unknown carriage type");
				}
				for (int i = 0; i < 10; i++) {
					list.add(new StringBuilder());
					list.get(i).append(carriageImage.get(i));
				}
			}
			return list;
		}
		return Collections.emptyList();
	}

	public static void printTrain(Train train) {
		List<StringBuilder> list = createTrainForPrinting(train);
		if (list.isEmpty()) {
			throw new IllegalStateException("Train should have at least one carriage");
		}
		System.out.println("\n");
		list.forEach(System.out::println);
	}
}
