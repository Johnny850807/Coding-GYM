package exception;

import players.Player;

public class CashFlowException extends RuntimeException {

    public CashFlowException(String message) {
        super(message);
    }

}
