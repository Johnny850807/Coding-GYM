package Exception;

import Player.Player;
import Stock.Stock;

public class StockNotEnoughException extends CashFlowException{
	public StockNotEnoughException(Player errorPlayer, Stock stock){
		super(errorPlayer, String.format("股票 %s 數量不足。", stock.getName()));
	}
}
