package Exception;

import Player.Player;

public class StockNotFoundException extends CashFlowException{
	public StockNotFoundException(Player errorPlayer, int stockId){
		super(errorPlayer, "��L Id (" + stockId + ") ���Ѳ� ");
	}
}
