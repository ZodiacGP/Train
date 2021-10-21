package org.zodiac.domain.train;

import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.zodiac.domain.Cargo;
import org.zodiac.domain.carriage.Carriage;
import org.zodiac.domain.carriage.FreightCarriage;
import org.zodiac.domain.carriage.Locomotive;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Slf4j
public class Train {
	@Getter
	private final String number;
	private Node<Carriage> head;

	static class Node<Carriage> {
		Carriage carriage;
		Node<Carriage> next;

		public Node(Carriage carriage) {
			this.carriage = carriage;
		}
	}

	public Train() {
		number = UUID.randomUUID().toString();
		log.info("Train has been created with random number: " + number);
	}

	public Train(String number) {
		log.info("Train has been created with specified number: " + number);
		this.number = number;
	}

	public void addCarriage(Carriage carriage) {
		Node<Carriage> node = new Node<>(carriage);
		node.next = null;

		if (this.head == null) {
			if (!(carriage instanceof Locomotive)) {
				log.error("Locomotive should be the first carriage");
				throw new IllegalArgumentException("Locomotive should be the first carriage");
			}
			this.head = node;
		} else {
			Node<Carriage> last = this.head;
			while (last.next != null) {
				last = last.next;
			}
			last.next = node;
		}
		log.debug(carriage.getClass().getSimpleName() + " has been successfully added");
	}

	public List<Carriage> getCarriages() {
		List<Carriage> list = new ArrayList<>();
		Node<Carriage> currNode = this.head;

		while (currNode != null) {
			list.add(currNode.carriage);
			currNode = currNode.next;
		}
		return list;
	}

	public Optional<FreightCarriage> findFirstSuitableFreightCarriage(Cargo cargo) {
		Node<Carriage> currNode = this.head;

		while (currNode != null) {
			if (currNode.carriage instanceof FreightCarriage) {
				FreightCarriage carriage = (FreightCarriage) currNode.carriage;
				if (carriage.canAccommodateCargo(cargo)) {
					log.debug("A suitable carriage was found");
					return Optional.of(carriage);
				}
			}
			currNode = currNode.next;
		}
		log.debug("A suitable carriage wasn't found");
		return Optional.empty();
	}

}
