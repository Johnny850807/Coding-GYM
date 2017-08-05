package BlackJack;

import java.util.ArrayList;
import java.util.Collections;

public class PokerCard {

	ArrayList<Card> pokerCards = new ArrayList<>();

	public PokerCard() {
		createCards();
		shuffle();
	}

	public void createCards() {
		int index = 0;
		for (int i = 0; i < 4; i++)
			for (int j = 1; j < 14; j++) {
				pokerCards.add(new Card());
				pokerCards.get(index).setSuit(i);
				pokerCards.get(index++).setNumber(j);

			}

	}

	public void shuffle() {
		// Collections.shuffle(pokerCards);
		for (int time = 0; time < 3; time++)
			for (int i = 0; i < pokerCards.size(); i++) {
				int index = (int) (Math.random() * pokerCards.size());
				Card temp = pokerCards.get(i);
				pokerCards.set(i, pokerCards.get(index));
				pokerCards.set(index, temp);
			}

	}

	public int drawCard() {
		int number = pokerCards.get(0).getNumber();
		pokerCards.remove(0);
		return number;
	}

	public String toString() {
		return pokerCards.get(0).showCard(pokerCards.get(0).getSuit(), pokerCards.get(0).getNumber());
	}

}
