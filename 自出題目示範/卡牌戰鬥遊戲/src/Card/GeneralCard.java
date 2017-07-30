package Card;

import Player.Player;

public class GeneralCard extends Card{

	public GeneralCard(Player ofPlayer) {
		super(ofPlayer);
	}

	@Override
	public int compareTo(Card c) {
		if ( c instanceof SmallSoldierCard )
			return -1;
		return super.compareTo(c);
	}

	@Override
	public String getName() {
		return "±N­x";
	}

	@Override
	public int getLevel() {
		return 4;
	}


}
