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
	
	public abstract int getLevel();  //�d�������� ���Ű� �� ���ŧC  (���F�@�Ǩҥ~)

	@Override
	public int compareTo(Card c) {
		return getLevel() - c.getLevel();
	}
	
	
}
