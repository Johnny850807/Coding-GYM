package Card;

import Player.Player;

public class SmallSoldierCard extends Card{

	public SmallSoldierCard(Player ofPlayer) {
		super(ofPlayer);
		// TODO Auto-generated constructor stub
	}

	@Override
	public int compareTo(Card c) {
		if ( c instanceof GeneralCard )
			return 1;
		return super.compareTo(c);
	}

	@Override
	public String getName() {
		return "¤p§L";
	}
	
	@Override
	public int getLevel() {
		return 0;
	}

}
