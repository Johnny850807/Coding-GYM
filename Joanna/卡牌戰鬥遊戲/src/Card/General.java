package Card;

public class General extends Card {

	public General(String type) {
		super(type);
	}

	@Override
	public boolean isWin(Card card) {
		if (card.getType() == "infantry" || card.getType() == "knight") 
			return true;
		return false;
	}

}
