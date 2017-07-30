package Game;

import Card.Card;
import Player.AiPlayer;
import Player.HumanPlayer;
import Player.NoPlayer;
import Player.Player;

public class Game {
	private Player player1;
	private Player player2;

	private CardStackFactory factory;
	private War war;
	
	public Game(CardStackFactory factory){
		this.factory = factory;
	}
	
	public void start(){
		definePlayerType();
		inputName();
		gameStarting();
	}

	private void definePlayerType() {
		player1 = Input.nextLine("請輸入玩家1 類型 (A) 真人  (B) 電腦: ").equalsIgnoreCase("A") ?
				new HumanPlayer() : new AiPlayer();
		player1.setCardStack(factory.createCardStack(player1));
		player2 = Input.nextLine("請輸入玩家2 類型 (A) 真人  (B) 電腦: ").equalsIgnoreCase("A") ?
						new HumanPlayer() : new AiPlayer();	
		war = new WarImp(player1,player2);
		player2.setCardStack(factory.createCardStack(player2));
	}

	private void inputName() {
		player1.setName(player1.createName());
		player2.setName(player2.createName());
	}
	
	private void gameStarting(){
		for ( int i = 0 ; i < 7 ; i ++ )
			oneRound();
		onGameResult();
	}

	private void oneRound() {
		player1.fetchThreeCardsFromStack();
		player2.fetchThreeCardsFromStack();
		Card card1 = player1.chooseCardToFight(); 
		Card card2 = player2.chooseCardToFight(); 
		war.fightAndPrintResult(card1, card2);
	}
	
	private void onGameResult() {
		Player winner;
		int p1Win = player1.getWinRound();
		int p2Win = player2.getWinRound();
		if ( p1Win > p2Win )
			winner = player1;
		else if ( p1Win < p2Win )
			winner = player2;
		else
			winner = new NoPlayer();
		
		System.out.println(p1Win + ":" + p2Win + " => " + winner.getName() + " 贏得這場遊戲的勝利。");
	}
	
	
	
	public static void main(String[] argv){
		Game game = new Game(new CardStackFactoryImp());
		game.start();
		
	}
}
