package exception;

import stocks.Stock;

public class StockNotEnoughException extends CashFlowException {
    public StockNotEnoughException(Stock stock) {
        super(String.format("股票數量不足", stock.getName()));
    }
}
