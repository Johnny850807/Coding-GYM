package CardStack;

public abstract class Card {

	protected String rank;
	protected int attack;

	public String getRank() {
		return rank;
	}

	public abstract boolean winOrNot(Card card);

}
