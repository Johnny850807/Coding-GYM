package Stock.Factory;

import Stock.Stock;
import Stock.StockMarket;
import Stock.PriceStrategy.*;

public class StockMarketFactoryImp implements StockMarketFactory{
	private ExcitingPriceStrategy crazy = new ExcitingPriceStrategy();
	private SmallRatePriceStrategy cheap = new SmallRatePriceStrategy();
	private NormalPriceStrategy normal = new NormalPriceStrategy();
	private HighPriceStrategy high = new HighPriceStrategy();
	
	@Override
	public StockMarket createMarket() {
		StockMarket stockMarket = new StockMarket();
		stockMarket.addStock(new Stock(1, "�v���A��", 160, normal));
		stockMarket.addStock(new Stock(2, "�Ű�����", 460, normal));
		stockMarket.addStock(new Stock(3, "���y���~", 975, normal));
		stockMarket.addStock(new Stock(4, "�ʶǤj��", 550, normal));
		
		return stockMarket;
	}

}
