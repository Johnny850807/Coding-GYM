package players;

import stocks.Stock;

/**
 * @author johnny850807@gmail.com (Waterball))
 */
public class OwnStock {
    private final Stock stock;
    private int amount;

    public OwnStock(Stock stock, int amount) {
        this.stock = stock;
        this.amount = amount;
    }

    public int getId() {
        return stock.getId();
    }

    public String getName() {
        return stock.getName();
    }

    public int getCurrentPrice() {
        return stock.getCurrentPrice();
    }

    public Stock getStock() {
        return stock;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

    @Override
    public String toString() {
        return String.format("(%d) %s %d張", getId(), getName(), getAmount());
    }
}
