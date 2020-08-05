package stocks;

import players.Player;

public class Order {
    private Player player;
    private int stockId;
    private int amount;
    private Type type;

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

    public int getAmount() { // �Y type ���ʶR �h �ƶq������  �Y�O�c�� �h�ƶq���t��
        return type == Type.BUY ? amount : amount * -1;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    public String getAction() {
        return type.toString();
    }

    public boolean isSelling() {
        return type == Type.SELL;
    }

    public enum Type {
        BUY("購買"), SELL("販賣");

        private final String action;

        Type(String action) {
            this.action = action;
        }

        @Override
        public String toString() {
            return action;
        }
    }
}
