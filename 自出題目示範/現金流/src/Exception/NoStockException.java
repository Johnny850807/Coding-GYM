package Exception;

import Player.Player;
import Stock.Stock;

public class NoStockException extends CashFlowException{
	public NoStockException(Player errorPlayer){
		super(errorPlayer, String.format("沒有股票。"));
	}
}
