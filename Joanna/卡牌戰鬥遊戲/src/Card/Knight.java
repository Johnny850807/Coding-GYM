package Card;

public class Knight extends Card {

	public Knight(String type) {
		super(type);
	}

	@Override
	public boolean isWin(Card card) {
		if (card.getType() == "infantry" || card.getType() == "soldier") 
			return true;
		return false;
	}

}
