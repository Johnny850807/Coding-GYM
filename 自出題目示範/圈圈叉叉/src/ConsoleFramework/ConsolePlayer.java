package ConsoleFramework;

import TicTacToe.Item.Team;
import TicTacToe.Player.Player;

public class ConsolePlayer extends Player{

	@Override
	protected String createName() {
		return ConsoleInput.nextName();
	}

	@Override
	public int makeChoice() {
		return ConsoleInput.nextInt("請輸入欲選擇格子數(1~9)");
	}

}
