package CardStack;

public class Knight extends Card {

	public Knight() {
		rank = "Knight";
		attack = 300;
	}

	@Override
	public boolean winOrNot(Card card) {
		if (this.attack > card.attack)
			return true;
		return false;
	}

}
