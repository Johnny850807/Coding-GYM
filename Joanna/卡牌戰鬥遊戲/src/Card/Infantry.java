package Card;

public class Infantry extends Card {

	public Infantry(String type) {
		super(type);
	}

	@Override
	public boolean isWin(Card card) {
		if (card.getType() == "soldier") 
			return true;
		return false;
	}

}
