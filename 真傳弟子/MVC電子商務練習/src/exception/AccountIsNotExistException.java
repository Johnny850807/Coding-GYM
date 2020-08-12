package exception;

public class AccountIsNotExistException extends Exception {
    public AccountIsNotExistException() {
        super("帳號不存在");
    }
}
