package 二十一點撲克牌遊戲;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class CardGroup {
	//Card[] cards = new Card[52];
	ArrayList<Card> cards = new ArrayList<Card>();
	
	public CardGroup() {
		super();
		generateCards();
		shuffle();
	}
	

	public void generateCards() {
		int temp = 0;
		for (int i = 0; i < 4; i++) {
			for (int j = 1; j < 14 ; j++) {
				Card c = new Card();
				cards.add(c);
				cards.get(temp).setSuit(i);
				cards.get(temp++).setNumber(j);
			}
		}
	}
	
	public void shuffle() {
		System.out.println("========洗牌中========");
		for (int i = 0; i < cards.size(); i++) {
			Random ran = new Random();
			int temp = (int) ran.nextInt(cards.size());
			Collections.swap(cards, i, temp);
		}
	}
	
	public static void swap(Card[] cards, int i, int j) {
		Card temp = cards[j];
        cards[j] = cards[i];
        cards[i] = temp;

	}
	
	public int gainOneCard() {
		cards.get(0).displayCard();
		int number = cards.get(0).getNumber();
		cards.remove(0);
		return number;
	}
	
	public void displayCards() {
		for (int i = 0; i < 52; i++) {
			cards.get(i).displayCard();
			System.out.println();
		}
	}
}
