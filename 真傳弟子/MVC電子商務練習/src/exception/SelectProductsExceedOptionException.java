package exception;

public class SelectProductsExceedOptionException extends Exception {
    public SelectProductsExceedOptionException() {
        super("超出選項範圍了");
    }
}
