package TicTacToe;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import TicTacToe.Item.Exception.TicTacToeException;
import TicTacToe.Player.NoPlayer;
import TicTacToe.Player.Player;
import Util.Input;

public class TicTacToe {
	private GameConfiguration config;
	private Board board;
	private Player[] players;
	
	public TicTacToe(GameConfiguration config) {
		super();
		this.config = config;
	}
	
	
	public void startGame(){
		config.setup();
		board = config.getBoard();
		players = config.getPlayers();
		
		while (oneRound())
			board.clear();
	}

	private boolean oneRound() {
		int turn = 0;
		while(!board.isGameOver())
		{
			int choose = 0;
			board.print();
			while(true)
			{
				try {
					choose = players[turn].makeChoice();
					board.makeChoice(players[turn], choose);
					break;  //�S���ҥ~�N�|�����j��
				} catch (TicTacToeException e) {}	
				
			}
			System.out.println(players[turn] + " ��ܤF " + choose);
			turn = turn == 0 ? 1 : 0; //���y
		}
		
		printWinner(board.getWinTeam());
		return Input.nextYesOrNo("�٭n�A�i��@���C����(y/n)");
	}
	
	private void printWinner(Team winTeam){
		board.print();
		if (winTeam == players[0].getTeam())
			printWinMessage(players[0]);
		else if (winTeam == players[1].getTeam())
			printWinMessage(players[1]);
		else
			printWinMessage(new NoPlayer());

	}
	
	private void printWinMessage(Player player){
		System.out.println("���߳o�@�����ɤ�" + player + "��o�F�ӧQ�C" );
	}
		
}
