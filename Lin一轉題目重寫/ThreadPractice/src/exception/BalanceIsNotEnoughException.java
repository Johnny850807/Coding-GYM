package exception;

public class BalanceIsNotEnoughException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The balance is not enough to withdraw";
    }
}
