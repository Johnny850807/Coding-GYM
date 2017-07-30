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
		System.out.println(String.format("%s �X�F  %s %n",
				player1.getName() , card1.getName()));
		delay();
		System.out.println(String.format("%s �X�F  %s %n",
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
		System.out.println(winner.getName() + "�b�o����M��o�ӧQ�C");
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
