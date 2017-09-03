package CardStack;

public class General extends Card {

	public General() {
		rank = "General";
		attack = 400;
	}

	@Override
	public boolean winOrNot(Card card) {
		if (this.attack > card.attack && card.attack != 100)
			return true;

		return false;
	}

}
