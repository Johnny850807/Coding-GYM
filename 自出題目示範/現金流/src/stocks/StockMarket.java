package stocks;

import exception.StockNotFoundException;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

public class StockMarket implements StockLifecycle, Iterable<Stock> {
    private final Map<Integer, Stock> stocks = new HashMap<>(); // key: id  value: stock


    public Stock getStockById(int stockId) {
        if (stocks.containsKey(stockId)) {
            return stocks.get(stockId);
        }
        throw new StockNotFoundException(stockId);
    }

    public void addStock(Stock stock) {
        stocks.put(stock.getId(), stock);
    }

    @Override
    public void newDay() {
        stocks.values().forEach(Stock::newDay);
    }

    @Override
    public void display() {
        stocks.values().forEach(Stock::display);
    }

    public StockProduct executeOrder(Order order) {
        Stock stock = getStockById(order.getStockId());
        int cost = stock.getPrice() * order.getAmount();
        return new StockProduct(stock, order, cost);
    }

    @Override
    public Iterator<Stock> iterator() {
        return stocks.values().iterator();
    }
}
