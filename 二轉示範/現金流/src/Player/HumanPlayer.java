package Player;

import Stock.Order;
import Stock.Order.Type;
import Util.Input;

public class HumanPlayer extends Player{

	@Override
	public String nameSelf() {
		return Input.nextLine("�п�J���a�W�l");
	}

	@Override
	public int chooseActionOption() {
		return Input.nextInt(1,3);
	}

	@Override
	public Order chooseWhichStockToBuy() {
		int stockId = Input.nextInt("�п�J���ʶR�Ѳ�Id: ");
		int amount = Input.nextInt("�п�J���ʶR�ƶq: (1~10)", 1, 10);
		return new Order(this, stockId, amount, Type.BUY);
	}

	@Override
	public Order chooseWhichStockToSell() {
		int stockId = Input.nextInt("�п�J���c��Ѳ�Id: ");
		int amount = Input.nextInt("�п�J���ʶR�ƶq: (1~10)", 1, 10);
		return new Order(this, stockId, amount, Type.SELL);
	}

}
