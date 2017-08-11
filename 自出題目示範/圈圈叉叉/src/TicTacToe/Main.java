package TicTacToe;

import ConsoleFramework.ConsoleCallback;
import ConsoleFramework.ConsoleGameConfiguration;
import TicTacToe.Item.Board;
import TicTacToe.Player.Player;

public class Main {
	public static void main(String[] args) {
		TicTacToe game = new TicTacToe(new ConsoleGameConfiguration());
		ConsoleCallback callback = new ConsoleCallback(game);
		game.setCallback(callback); 
		game.startGame();
	}

}
