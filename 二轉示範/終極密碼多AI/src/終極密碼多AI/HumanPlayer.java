package �׷��K�X�hAI;

import Util.Input;

public class HumanPlayer extends Player{

	@Override
	protected String nameSelf() {
		return Input.next("�п�J�W��");
	}

	@Override
	protected String getPlayerType() {
		return "���a";
	}

	@Override
	protected int guess(int min, int max) {
		return Input.nextInt(min,max);
	}

}
