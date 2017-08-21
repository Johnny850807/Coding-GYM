package client.Player;

import Util.Input;

public class HumanPlayer extends Player{

	@Override
	protected String nameSelf() {
		return Input.nextLine("輸入玩家名稱");
	}

	@Override
	public int guess(int min, int max) {
		return Input.nextInt("輸入數字 ("+min + "~"+max+") :", min, max);
	}

}
