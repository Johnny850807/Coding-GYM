package TicTacToe.Player;

import TicTacToe.Item.Team;
import Util.Input;

public class HumanPlayer extends Player{

	@Override
	protected String createName() {
		return Input.nextName();
	}

	@Override
	public int makeChoice() {
		return Input.nextInt("�п�J����ܮ�l��(1~9)");
	}

}
