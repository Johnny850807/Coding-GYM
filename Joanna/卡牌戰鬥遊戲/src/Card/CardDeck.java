package Card;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardDeck {
	private ArrayList<Card> cards = new ArrayList<Card>();

	public CardDeck() {
		super();
		createCards();
		shuffle();
	}
	
	public ArrayList<Card> getCards() {
		return cards;
	}

	public void createCards() {
		for (int i = 0; i < 3; i++) {
			General g = new General("general");
			cards.add(g);
		}
		for (int i = 0; i < 5; i++) {
			Knight k = new Knight("knight");
			cards.add(k);
		}
		for (int i = 0; i < 7; i++) {
			Infantry in = new Infantry("infantry");
			cards.add(in);
		}
		for (int i = 0; i < 6; i++) {
			Soldier s = new Soldier("soldier");
			cards.add(s);
		}
	}
	
	public void shuffle() {
		for (int i = 0; i < cards.size(); i++) {
			Random ran = new Random();
			int temp = (int) ran.nextInt(cards.size());
			Collections.swap(cards, i, temp);
		}
	}
	
	public void take3Cards() {
		for (int i = 0; i < 3; i++) {
			System.out.print("(" + i + ")");
			cards.get(i).displayCard();
		}
	}
	
	public void removeCard() {
		for (int i = 0; i < 3; i++)
			cards.remove(0);
	}
	
}
