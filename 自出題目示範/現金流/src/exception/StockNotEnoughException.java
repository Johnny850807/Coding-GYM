package exception;

import stocks.Stock;

public class StockNotEnoughException extends CashFlowException {
    private Stock stock;
    private int requiredAmount;

    public StockNotEnoughException(Stock stock, int requiredAmount) {
        this.stock = stock;
        this.requiredAmount = requiredAmount;
    }

    public Stock getStock() {
        return stock;
    }

    public int getRequiredAmount() {
        return requiredAmount;
    }
}
