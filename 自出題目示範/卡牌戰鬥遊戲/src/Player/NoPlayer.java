package Player;

import Card.Card;

public class NoPlayer extends Player{

	public NoPlayer(){
		super("�S���H");
	}
	
	@Override
	public String createName() {
		return "�S���H";
	}
	
	@Override
	public Card chooseCardToFight() {
		return null;
	}
	
}
