package TicTacToe.Item.Exception;

public class BlockHasBeenChosenException extends TicTacToeException{

	public BlockHasBeenChosenException() {
		super("該格子已被選取了 !");
	}
	
}
