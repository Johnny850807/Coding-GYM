package exception;

public class StockNotFoundException extends CashFlowException {
    public StockNotFoundException(int stockId) {
        super(String.format("股票 %d 不存在", stockId));
    }

    public StockNotFoundException(String message) {
        super(message);
    }
}
