package Player;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import Exception.CashFlowException;
import Exception.MoneyNotEnoughException;
import Exception.StockNotEnoughException;
import Stock.Order;
import Stock.Stock;
import Stock.StockProduct;

public abstract class Player implements Serializable{
	protected Map<Stock,Integer> stocks = new HashMap<>();  // key: stock value: amount
	protected String name;
	protected int money = 6000;
	
	public Player(){
		name = nameSelf();
	}
	
	public abstract String nameSelf();  
	
	public void receiveStockProduct(StockProduct product){
		alterStockAmount(product.getStock(), product.getAmount());
		alterMoneyByTransactionCost(product.getCost());
		System.out.println(name + " " + product);
	}
	
	public void alterStockAmount(Stock stock, int amount){
		int currentAmount = stocks.get(stock) == null ? 0 : stocks.get(stock);
		int resultAmount = currentAmount + amount;
		if ( resultAmount < 0 )
			throw new StockNotEnoughException(this, stock);
		stocks.put(stock, resultAmount);
		if (stocks.get(stock) == 0)
			stocks.remove(stock);
	}
	
	private void alterMoneyByTransactionCost(int cost){
		int resultMoney = money - cost;
		if (resultMoney < 0)
			throw new MoneyNotEnoughException(this);
		money -= cost;
	}
	
	public boolean hasStocks(){
		return stocks.size() != 0;
	}
	
	public abstract int chooseActionOption();  
	
	public abstract Order chooseWhichStockToBuy();  
	
	public abstract Order chooseWhichStockToSell();  
	
	public String stocksToString(){
		StringBuilder strb = new StringBuilder();
		strb.append("-- 玩家 " + name + " 擁有 --\n");
		for ( Stock stock : stocks.keySet() )
			strb.append(String.format("(%d) %s %d張 %n", 
					stock.getId(), stock.getName(), stocks.get(stock)));
		return strb.toString();
	}
	
	public boolean isWin(){
		return money >= 10000;
	}
	
	

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}

	@Override
	public String toString() {
		return String.format("玩家： %s %n 手頭現金： %d %n", name, money);
	}

}
