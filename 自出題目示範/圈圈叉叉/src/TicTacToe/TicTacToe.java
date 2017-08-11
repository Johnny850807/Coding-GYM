package TicTacToe;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import TicTacToe.Item.Exception.TicTacToeException;
import TicTacToe.Player.NoPlayer;
import TicTacToe.Player.Player;

public class TicTacToe {
	private CallBack callback;
	private GameConfiguration config;
	private Board board;
	private Player[] players;
	private int turn = 0;
	
	public TicTacToe(GameConfiguration config) {
		this.config = config;
	}


	public void setCallback(CallBack callback) {
		this.callback = callback;
	}


	public void startGame(){
		config.setup();
		board = config.getBoard();
		players = config.getPlayers();
		callback.onDrawBoard(board);
		callback.onNextTurn(players[turn]);
	}
	
	private int nextTurn(){
		return turn + 1 > 1 ? 0 : 1;
	}
	
	public void makeChoice(Player owner, int number){
		try {
			board.makeChoice(owner, number);
			callback.onDrawBoard(board);
			if (board.isGameOver())
			{
				Player winner = producePlayer(board.getWinTeam());
				callback.onGameResult(winner);
				return;  //close the game
			}
			turn = nextTurn();
		} catch (TicTacToeException e) {
			callback.onError(e);
		}
		
		callback.onNextTurn(players[turn]);
	}
	
	private Player producePlayer(Team winTeam){
		if (winTeam == players[0].getTeam())
			return players[0];
		else if (winTeam == players[1].getTeam())
			return players[1];
		else
			return new NoPlayer();
	}
	
	public interface CallBack{
		void onError(Throwable err);
		void onDrawBoard(Board board);
		void onNextTurn(Player player);
		void onGameResult(Player winner);
	}
}
