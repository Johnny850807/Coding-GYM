package Stock;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import Exception.StockNotFoundException;

public class StockMarket implements StockItem, Iterable<Stock>{
	private Map<Integer,Stock> stocks = new HashMap<>(); // key: id  value: stock
	
	public StockMarket(){}
	
	public Stock getStockById(int stockId){
		if (stocks.containsKey(stockId))
			return stocks.get(stockId);
		return null;
	}
	
	public void addStock(Stock stock){
		stocks.put(stock.getId(), stock);
	}
	
	@Override
	public void newDay() {
		for (Stock stock : stocks.values())
			stock.newDay();
	}
	
	@Override
	public void display() {
		for (Stock stock : stocks.values())
			stock.display();
	}
	
	public StockProduct executeOrder(Order order){
		Stock stock = getStockById(order.getStockId());
		if (stock == null)
			throw new StockNotFoundException(order.getPlayer(), order.getStockId());
		int cost = stock.getPrice() * order.getAmount();
		
		return new StockProduct(stock, order, cost);
	}

	@Override
	public Iterator<Stock> iterator() {
		return stocks.values().iterator();
	}
}
