package Card;

import Player.Player;

public class GeneralCard extends Card{

	public GeneralCard(Player ofPlayer) {
		super(ofPlayer);
	}

	@Override
	public int compareTo(Card o) {
		// TODO Auto-generated method stub
		return 1;
	}

	@Override
	public String getName() {
		return "±N­x";
	}


}
