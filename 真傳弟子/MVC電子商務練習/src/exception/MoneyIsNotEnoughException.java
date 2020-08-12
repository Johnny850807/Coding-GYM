package exception;

public class MoneyIsNotEnoughException extends Exception {
    public MoneyIsNotEnoughException() {
        super("金錢不夠");
    }
}
