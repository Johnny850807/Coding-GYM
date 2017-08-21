package Player;

import Stock.Order;
import Stock.Order.Type;
import Util.Input;

public class HumanPlayer extends Player{

	@Override
	public String nameSelf() {
		return Input.nextLine("請輸入玩家名子");
	}

	@Override
	public int chooseActionOption() {
		return Input.nextInt(1,3);
	}

	@Override
	public Order chooseWhichStockToBuy() {
		int stockId = Input.nextInt("請輸入欲購買股票Id: ");
		int amount = Input.nextInt("請輸入欲購買數量: (1~10)", 1, 10);
		return new Order(this, stockId, amount, Type.BUY);
	}

	@Override
	public Order chooseWhichStockToSell() {
		int stockId = Input.nextInt("請輸入欲販賣股票Id: ");
		int amount = Input.nextInt("請輸入欲購買數量: (1~10)", 1, 10);
		return new Order(this, stockId, amount, Type.SELL);
	}

}
