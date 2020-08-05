package exception;

import players.Player;

public class CashFlowException extends RuntimeException {
    public CashFlowException() {
    }
    public CashFlowException(String message, Throwable cause) {
        super(message, cause);
    }

    public CashFlowException(Throwable cause) {
        super(cause);
    }

    public CashFlowException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }

    public CashFlowException(String message) {
        super(message);
    }

}
