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
	
	public abstract int getLevel();  //卡片的等級 等級高 勝 等級低  (除了一些例外)

	@Override
	public int compareTo(Card c) {
		return getLevel() - c.getLevel();
	}
	
	
}
