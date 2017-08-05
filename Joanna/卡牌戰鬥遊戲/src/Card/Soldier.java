package Card;

public class Soldier extends Card {

	public Soldier(String type) {
		super(type);
	}

	@Override
	public boolean isWin(Card card) {
		if (card.getType() == "general") 
			return true;
		return false;
	}

}
