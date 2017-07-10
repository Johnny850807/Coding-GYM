package Game;

import Card.Card;
import Player.Player;

public abstract class War {
	protected Player player1;
	protected Player player2;
	
	public War(Player player1, Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}

	public abstract void fightAndPrintResult(Card card1, Card card2);
}
