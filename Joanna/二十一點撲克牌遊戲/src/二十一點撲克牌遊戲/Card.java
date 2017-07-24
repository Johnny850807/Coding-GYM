package 二十一點撲克牌遊戲;

public class Card {
	private String name;
	private String suit;
	private int number;
	
	public String getName() {
		if (name == null) {
			if (number	>= 2 && number <= 10)
				name = suit + Integer.toString(number);
			else if (number == 1)
				name = suit + "A";
			else if (number == 11)
				name = suit + "J";
			else if (number == 12)
				name = suit + "Q";
			else if (number == 13)
				name = suit + "K";
		}
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getSuit() {
		return suit;
	}
	
	public void setSuit(String suit) {
		this.suit = suit;
	}
	
	public void setSuit(int suit) {
		if (suit == 0) {
			this.suit = "梅花";
		}
		else if (suit == 1) {
			this.suit = "方塊";
		}
		else if (suit == 2) {
			this.suit = "紅心";
		}
		else if (suit == 3) {
			this.suit = "黑桃";
		}
	}
	
	public int getNumber() {
		return number;
	}
	
	public void setNumber(int number) {
		this.number = number;
	}
	
	public void displayCard() {
		System.out.print(getName());
	}
	

}
