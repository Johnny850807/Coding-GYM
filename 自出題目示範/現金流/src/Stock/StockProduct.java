package Stock;

import java.util.Map;

public class StockProduct {
	private Stock stock;
	private Order order;
	private int cost;

	public StockProduct(Stock stock, Order order, int cost) {

		this.stock = stock;
		this.order = order;
		this.cost = cost;
	}
	
	public int getAmount(){
		return order.getAmount();
	}

	public Stock getStock() {
		return stock;
	}

	public void setStock(Stock stock) {
		this.stock = stock;
	}

	public Order getOrder() {
		return order;
	}

	public void setOrder(Order order) {
		this.order = order;
	}

	public int getCost() {
		return cost;
	}

	public void setCost(int cost) {
		this.cost = cost;
	}
	
	@Override
	public String toString(){
		int amount = order.isSelling() ? order.getAmount() * -1 : order.getAmount();
		return String.format("%s ¤F  %s %d ±i", order.getAction(), stock.getName(), amount);
	}
	
	
}
