package Exception;

import Player.Player;

public class StockNotFoundException extends CashFlowException{
	public StockNotFoundException(Player errorPlayer, int stockId){
		super(errorPlayer, "找無 Id (" + stockId + ") 的股票 ");
	}
}
