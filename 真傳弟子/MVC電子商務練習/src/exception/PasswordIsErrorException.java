package exception;

public class PasswordIsErrorException extends Exception {
    public PasswordIsErrorException() {
        super("密碼輸入錯誤");
    }
}
