package ConsoleFramework;

import TicTacToe.GameConfiguration;
import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import TicTacToe.Player.Player;
import TicTacToe.Player.WaterballAI;

public class ConsoleGameConfiguration implements GameConfiguration{
	private final String OPTIONS = "(1) 玩家 (2) 電腦";
	private Board board = new Board();
	private Player[] players = new Player[2];
	
	@Override
	public void setup(){
		inputPlayersType();
	}
	
	private void inputPlayersType(){
		players[0] = createPlayer(ConsoleInput.nextChar("請輸入玩家1 類型：" + OPTIONS));
		players[0].setTeam(Team.CIRCLE);
		players[1] = createPlayer(ConsoleInput.nextChar("請輸入玩家2 類型：" + OPTIONS));
		players[1].setTeam(Team.CROSS);
	}
	
	private Player createPlayer(char type)
	{
		return type == '1' ? new ConsolePlayer() : new WaterballAI(board);
	}

	@Override
	public Board getBoard() {
		return board;
	}
	
	@Override
	public Player[] getPlayers() {
		return players;
	}
	
}
