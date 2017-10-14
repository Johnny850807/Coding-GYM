package CardStack;

public class Solider extends Card {

	public Solider() {
		rank = "Solider";
		attack = 100;
	}

	@Override
	public boolean winOrNot(Card card) {
		if (card.attack == 400)
			return true;
		return false;
	}

}
