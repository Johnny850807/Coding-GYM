package Player;

import Stock.Order;
import Stock.StockMarket;
import Util.NameGenerator;

public class GodAI extends AI{

	public GodAI(StockMarket market) {
		super(market);
	}
	
	@Override
	public String nameSelf() {
		return "пл-" + NameGenerator.getInstance().nextName();
	}

	@Override
	public int chooseActionOption() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Order chooseWhichStockToBuy() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Order chooseWhichStockToSell() {
		// TODO Auto-generated method stub
		return null;
	}

	

}
