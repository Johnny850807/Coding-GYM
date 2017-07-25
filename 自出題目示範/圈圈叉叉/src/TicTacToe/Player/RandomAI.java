package TicTacToe.Player;

import java.util.Random;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;

public class RandomAI extends AI{

	public RandomAI(Board board) {
		super(board);
	}

	@Override
	public int makeChoice() {
		return new Random().nextInt(9) + 1;
	}
	

}
