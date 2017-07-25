package TicTacToe.Player;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import Util.NameGenerator;

public abstract class AI extends Player{
	protected Board board;  //AI �ݭnŪ���L����T
	
	public AI(Board board){
		this.board = board;
	}
	
	@Override
	protected String createName() {
		return NameGenerator.getInstance().nextName();
	}

}
