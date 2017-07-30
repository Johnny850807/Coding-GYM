package Card;

import Player.Player;

public class KnightCard extends Card {

	public KnightCard(Player ofPlayer) {
		super(ofPlayer);
	}

	@Override
	public String getName() {
		return "�M�h";
	}
	
	@Override
	public int getLevel() {
		return 2;
	}

}
