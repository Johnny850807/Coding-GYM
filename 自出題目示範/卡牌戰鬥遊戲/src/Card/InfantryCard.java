package Card;

import Player.Player;

public class InfantryCard extends Card {

	public InfantryCard(Player ofPlayer) {
		super(ofPlayer);
	}

	@Override
	public String getName() {
		return "¨B§L";
	}
	
	@Override
	public int getLevel() {
		return 1;
	}

}
