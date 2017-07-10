package Player;

import java.util.Random;

import Card.Card;

public class AiPlayer extends Player {
	private final String[] NAMES = { "©v»õ" , "¹Å°¶" , "­³³Ç"};
	@Override
	public String createName() {
		return NAMES[new Random().nextInt(NAMES.length)];
	}

	@Override
	public Card chooseCardToFight() {
		return threeCards[new Random().nextInt(threeCards.length)];
	}

}
