package TicTacToe;

import TicTacToe.Item.Board;
import TicTacToe.Player.Player;

public interface GameConfiguration {
	public void setup();
	public Board getBoard();
	public Player[] getPlayers();
}
