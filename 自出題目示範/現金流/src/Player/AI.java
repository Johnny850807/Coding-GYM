package Player;

import Stock.StockMarket;
import Util.NameGenerator;

public abstract class AI extends Player{
	protected StockMarket market;
		
	public AI(StockMarket market) {
		this.market = market;
	}


	public String nameSelf(){
		return NameGenerator.getInstance().nextName();
	}

}
