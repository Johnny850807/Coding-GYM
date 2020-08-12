package exception;

public class HaveSameAccountException extends Exception {
    public HaveSameAccountException() {
        super("已有帳號，無法註冊");
    }
}
