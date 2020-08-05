package exception;

import players.Player;

public class MoneyNotEnoughException extends CashFlowException {
    public MoneyNotEnoughException() {
        super("金錢不足");
    }
}
