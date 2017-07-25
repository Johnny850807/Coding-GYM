package TicTacToe;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import TicTacToe.Player.HumanPlayer;
import TicTacToe.Player.Player;
import TicTacToe.Player.WaterballAI;
import Util.Input;

public class GameConfiguration {
	private final String OPTIONS = "(1) ���a (2) �q��";
	private Board board = new Board();
	private Player[] players = new Player[2];
	
	public void setup(){
		inputPlayersType();
	}
	
	private void inputPlayersType(){
		players[0] = createPlayer(Input.nextChar("�п�J���a1 �����G" + OPTIONS));
		players[0].setTeam(Team.CIRCLE);
		players[1] = createPlayer(Input.nextChar("�п�J���a2 �����G" + OPTIONS));
		players[1].setTeam(Team.CROSS);
	}
	
	private Player createPlayer(char type)
	{
		return type == '1' ? new HumanPlayer() : new WaterballAI(board);
	}

	public Board getBoard() {
		return board;
	}

	public Player[] getPlayers() {
		return players;
	}
	
}
