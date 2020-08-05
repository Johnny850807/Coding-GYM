package game;

import stocks.Stock;
import stocks.StockMarket;

import java.util.HashMap;
import java.util.Map;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class StockMarketSnapshot {
    private final Map<Stock, Integer> stockPriceMap = new HashMap<>();

    public StockMarketSnapshot(StockMarket stockMarket) {
        takeSnapshot(stockMarket);
    }

    private void takeSnapshot(StockMarket stockMarket) {
        for (Stock stock : stockMarket.getStocks()) {
            stockPriceMap.put(stock, stock.getCurrentPrice());
        }
    }

    public void applyToMarket(StockMarket stockMarket) {
        for (Map.Entry<Stock, Integer> stockPriceEntry : stockPriceMap.entrySet()) {
            stockMarket.getStockById(stockPriceEntry.getKey().getId())
                    .setCurrentPrice(stockPriceEntry.getValue());
        }
    }
}
