package Game;

import Card.Card;
import Card.CardStack;
import Card.GeneralCard;
import Card.InfantryCard;
import Card.KnightCard;
import Card.SmallSoldierCard;
import Player.NoPlayer;
import Player.Player;

public class CardStackFactoryImp implements CardStackFactory{

	@Override
	public CardStack createCardStack(Player ofPlayer) {
		return new CardStack.Builder()
				.cardType(()-> new GeneralCard(ofPlayer))
				.cardAmount(3)
				.cardType(()-> new SmallSoldierCard(ofPlayer))
				.cardAmount(6) 
				.cardType(()-> new InfantryCard(ofPlayer))
				.cardAmount(7)
				.cardType(()-> new KnightCard(ofPlayer))
				.cardAmount(5)
				.shuffle()
				.build();
	}
	
	public static void main(String[] argv){
		CardStack cs = new CardStackFactoryImp().createCardStack(new NoPlayer());
		for (Card c : cs)
			System.out.println(c.getName());
	}
	

}
