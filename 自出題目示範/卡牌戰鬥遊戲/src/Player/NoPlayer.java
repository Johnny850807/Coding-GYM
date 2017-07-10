package Player;

import Card.Card;

public class NoPlayer extends Player{

	public NoPlayer(){
		super("沒有人");
	}
	
	@Override
	public String createName() {
		return "沒有人";
	}
	
	@Override
	public Card chooseCardToFight() {
		return null;
	}
	
}
