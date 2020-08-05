package exception;

import players.Player;

public class NoStockException extends CashFlowException {
    public NoStockException() {
        super(String.format("不擁有任何股票"));
    }
}
