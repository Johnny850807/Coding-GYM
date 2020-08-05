package stocks.factories;

import stocks.Stock;
import stocks.StockMarket;
import stocks.strategies.NormalPriceFluctuationStrategy;

public class StockMarketFactoryImp implements StockMarketFactory {

    @Override
    public StockMarket createMarket() {
        StockMarket stockMarket = new StockMarket();
        stockMarket.addStock(new Stock(1, "鴻海", 160, new NormalPriceFluctuationStrategy()));
        stockMarket.addStock(new Stock(2, "Taiwan LINE", 460, new NormalPriceFluctuationStrategy()));
        stockMarket.addStock(new Stock(3, "冠宇科技", 975, new NormalPriceFluctuationStrategy()));
        stockMarket.addStock(new Stock(4, "榮華農場", 550, new NormalPriceFluctuationStrategy()));

        return stockMarket;
    }

}
