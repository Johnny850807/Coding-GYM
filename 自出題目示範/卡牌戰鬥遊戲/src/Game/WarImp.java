package Game;

import Card.Card;
import Player.NoPlayer;
import Player.Player;

public class WarImp extends War{
	
	public WarImp(Player player1, Player player2) {
		super(player1, player2);
	}

	@Override
	public void fightAndPrintResult(Card card1, Card card2) {
		System.out.println(String.format("%s 出了  %s %n",
				player1.getName() , card1.getName()));
		delay();
		System.out.println(String.format("%s 出了  %s %n",
				player2.getName() , card2.getName()));
		delay();
		int result = card1.compareTo(card2);	
		Player winner;
		
		if ( result > 0 )
			winner = card1.getOfPlayer();
		else if (result < 0)
			winner = card2.getOfPlayer();
		else
			winner = new NoPlayer();
		
		winAndPrintResult(winner);
	}
	
	private void winAndPrintResult(Player winner){
		delay();
		winner.win();
		System.out.println(winner.getName() + "在這次對決獲得勝利。");
		delay();
	}
	
	private void delay(){
		try {
			Thread.sleep(900);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

}
