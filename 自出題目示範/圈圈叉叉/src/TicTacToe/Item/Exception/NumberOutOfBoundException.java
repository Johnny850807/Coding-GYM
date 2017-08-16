package TicTacToe.Item.Exception;

public class NumberOutOfBoundException extends TicTacToeException{
	
	public NumberOutOfBoundException() {
		super("請選擇1~9的格子 !");
	}

}
