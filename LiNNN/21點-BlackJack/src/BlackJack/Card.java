package BlackJack;

public class Card {

	private String card;
	private int suit;
	private int number;

	public String getCard() {
		return card;
	}

	public void setCard(int number) {
		if (number > 1 && number < 11)
			this.card = Integer.toString(number);
		else if (number == 1)
			this.card = "A";
		else if (number == 11)
			this.card = "J";
		else if (number == 12)
			this.card = "Q";
		else if (number == 13)
			this.card = "K";
	}

	public int getSuit() {
		return suit;
	}

	public void setSuit(int suit) {
		this.suit = suit;
	}

	public int getNumber() {
		return number;
	}

	public void setNumber(int number) {
		this.number = number;
	}

	public String showCard(int suit, int number) {
		if (number > 1 && number < 11)
			this.card = Integer.toString(number);
		else if (number == 1)
			this.card = "A";
		else if (number == 11)
			this.card = "J";
		else if (number == 12)
			this.card = "Q";
		else if (number == 13)
			this.card = "K";
		switch (suit) {
		case 0:
			return "±öªá " + card;
		case 1:
			return "¤è¶ô " + card;
		case 2:
			return "¬õ¤ß " + card;
		default:
			return "¶Â®ç " + card;
		}
	}

}
