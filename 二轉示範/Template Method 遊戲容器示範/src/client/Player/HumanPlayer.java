package client.Player;

import Util.Input;

public class HumanPlayer extends Player{

	@Override
	protected String nameSelf() {
		return Input.nextLine("��J���a�W��");
	}

	@Override
	public int guess(int min, int max) {
		return Input.nextInt("��J�Ʀr ("+min + "~"+max+") :", min, max);
	}

}
