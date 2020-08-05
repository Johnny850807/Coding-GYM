package stocks;

import exception.StockNotFoundException;
import players.Player;

import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

public class StockMarket implements StockLifecycle {
    private final Map<Integer, Stock> stockMap = new TreeMap<>(); // key: id  value: stock
    private final Agent agent = new Agent();

    public Agent getAgent() {
        return agent;
    }

    public Collection<Stock> getStocks() {
        return stockMap.values();
    }

    public Stock getStockById(int stockId) {
        if (stockMap.containsKey(stockId)) {
            return stockMap.get(stockId);
        }
        throw new StockNotFoundException(stockId);
    }

    public void addStock(Stock stock) {
        stockMap.put(stock.getId(), stock);
    }

    @Override
    public void onDayBegins() {
        stockMap.values().forEach(Stock::onDayBegins);
    }

    @Override
    public void onDayEnds() {
        stockMap.values().forEach(Stock::onDayEnds);
    }

    public class Agent {
        public void buyStocks(Player player, int stockId, int amount) {
            Stock stock = getStockById(stockId);
            int requiredPrice = stock.getCurrentPrice() * amount;
            player.costMoney(requiredPrice);
            player.addStocks(stock, amount);
        }

        public void sellStocks(Player player, int stockId, int amount) {
            Stock stock = getStockById(stockId);
            int gainedMoney = stock.getCurrentPrice() * amount;
            player.consumeStocks(stock, amount);
            player.gainMoney(gainedMoney);
        }
    }
}
