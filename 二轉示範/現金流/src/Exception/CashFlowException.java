package Exception;

import Player.Player;

public class CashFlowException extends RuntimeException{
	private Player errorPlayer;
	
	public CashFlowException(Player errorPlayer, String message){
		super(message);
		this.errorPlayer = errorPlayer;
	}
	
	public Player getErrorPlayer(){
		return this.errorPlayer;
	}
}
