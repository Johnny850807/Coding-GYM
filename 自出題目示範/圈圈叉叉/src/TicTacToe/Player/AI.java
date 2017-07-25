package TicTacToe.Player;

import TicTacToe.Item.Board;
import TicTacToe.Item.Team;
import Util.NameGenerator;

public abstract class AI extends Player{
	protected Board board;  //AI 需要讀取盤面資訊
	
	public AI(Board board){
		this.board = board;
	}
	
	@Override
	protected String createName() {
		return NameGenerator.getInstance().nextName();
	}

}
