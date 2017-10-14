package CardStack;

public class Infantry extends Card {

	public Infantry() {
		rank = "Infantry";
		attack = 200;
	}

	@Override
	public boolean winOrNot(Card card) {
		if (this.attack > card.attack)
			return true;
		return false;
	}

}
