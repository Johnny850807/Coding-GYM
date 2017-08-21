package Exception;

import Player.Player;

public class MoneyNotEnoughException extends CashFlowException{
	public MoneyNotEnoughException(Player errorPlayer){
		super(errorPlayer, "ª÷¿ú¤£¨¬¡C");
	}
}
