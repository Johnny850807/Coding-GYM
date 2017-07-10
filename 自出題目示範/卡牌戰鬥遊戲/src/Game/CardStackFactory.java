package Game;

import Card.CardStack;
import Player.Player;

public interface CardStackFactory {
	CardStack createCardStack(Player ofPlayer);
}
