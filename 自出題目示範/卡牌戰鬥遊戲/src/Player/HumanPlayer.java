package Player;

import Card.Card;
import Game.Input;

public class HumanPlayer extends Player {

	@Override
	public String createName() {
		return Input.nextLine("�п�J�m�W");
	}
	
	@Override
	public Card chooseCardToFight() {
		printThreeCardsInfo();
		int choose = Input.nextInt("�п�J����ܥd��", 3);
		return threeCards[choose];
	}

}
