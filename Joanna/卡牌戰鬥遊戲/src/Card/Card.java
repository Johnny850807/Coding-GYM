package Card;

public abstract class Card {
	protected String type;
	
	public Card(String type) {
		super();
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public abstract boolean isWin(Card card);
	
	public void displayCard() {
		System.out.print(getType() + " ");
	}
}
