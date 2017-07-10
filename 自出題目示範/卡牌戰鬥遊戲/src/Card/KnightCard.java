package Card;

import Player.Player;

public class KnightCard extends Card {

	public KnightCard(Player ofPlayer) {
		super(ofPlayer);
	}

	@Override
	public int compareTo(Card o) {
		return 0;
	}

	@Override
	public String getName() {
		return "ÃM¤h";
	}

}
