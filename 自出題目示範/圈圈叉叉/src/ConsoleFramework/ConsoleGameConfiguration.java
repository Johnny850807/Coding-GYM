package ConsoleFramework;

import TicTacToe.GameConfiguration;
import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import TicTacToe.Player.Player;
import TicTacToe.Player.WaterballAI;

public class ConsoleGameConfiguration implements GameConfiguration{
	private final String OPTIONS = "(1) ���a (2) �q��";
	private Board board = new Board();
	private Player[] players = new Player[2];
	
	@Override
	public void setup(){
		inputPlayersType();
	}
	
	private void inputPlayersType(){
		players[0] = createPlayer(ConsoleInput.nextChar("�п�J���a1 �����G" + OPTIONS));
		players[0].setTeam(Team.CIRCLE);
		players[1] = createPlayer(ConsoleInput.nextChar("�п�J���a2 �����G" + OPTIONS));
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
