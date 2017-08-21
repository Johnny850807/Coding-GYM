package Exception;

import Player.Player;
import Stock.Stock;

public class StockNotEnoughException extends CashFlowException{
	public StockNotEnoughException(Player errorPlayer, Stock stock){
		super(errorPlayer, String.format("�Ѳ� %s �ƶq�����C", stock.getName()));
	}
}
