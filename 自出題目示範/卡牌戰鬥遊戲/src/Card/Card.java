package Card;

import Player.Player;

public abstract class Card implements Comparable<Card>{
	private Player ofPlayer;
	
	public Card(Player ofPlayer) {
		this.ofPlayer = ofPlayer;
	}
	
	public abstract String getName();
	
	public Player getOfPlayer() {
		return ofPlayer;
	}

	public void setOfPlayer(Player ofPlayer) {
		this.ofPlayer = ofPlayer;
	}
}
