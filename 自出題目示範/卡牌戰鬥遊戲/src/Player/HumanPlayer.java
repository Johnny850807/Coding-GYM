package Player;

import Card.Card;
import Game.Input;

public class HumanPlayer extends Player {

	@Override
	public String createName() {
		return Input.nextLine("請輸入姓名");
	}
	
	@Override
	public Card chooseCardToFight() {
		printThreeCardsInfo();
		int choose = Input.nextInt("請輸入欲選擇卡片", 3);
		return threeCards[choose];
	}

}
