package Stock;

import Player.Player;

//訂單用來包裝 玩家 每次的交易資訊
public class Order {
	private Player player;
	private int stockId;
	private int amount;
	private Type type;  //訂單種類  買 或 賣

	public Order(Player player, int stockId, int amount, Type type) {
		this.player = player;
		this.type = type;
		this.stockId = stockId;
		this.amount = amount;
	}
	
	public int getStockId() {
		return stockId;
	}
	public void setStockId(int stockId) {
		this.stockId = stockId;
	}
	
	public Player getPlayer() {
		return player;
	}

	public int getAmount() { // 若 type 為購買 則 數量為正數  若是販賣 則數量為負數
		return type == Type.BUY ? amount : amount * -1;
	}
	public void setAmount(int amount) {
		this.amount = amount;
	}
	
	public String getAction(){
		return type.toString();
	}
	
	public boolean isSelling(){
		return type == Type.SELL;
	}
	
	public enum Type{
		BUY("購買"), SELL("販賣");
		
		private String action;
		private Type(String action){
			this.action = action;
		}
		
		@Override
		public String toString(){
			return action;
		}
	}
}
