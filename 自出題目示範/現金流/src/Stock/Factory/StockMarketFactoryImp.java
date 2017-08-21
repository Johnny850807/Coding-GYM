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
		stockMarket.addStock(new Stock(1, "宗億農場", 160, normal));
		stockMarket.addStock(new Stock(2, "嘉偉雞場", 460, normal));
		stockMarket.addStock(new Stock(3, "水球企業", 975, normal));
		stockMarket.addStock(new Stock(4, "銘傳大學", 550, normal));
		
		return stockMarket;
	}

}
