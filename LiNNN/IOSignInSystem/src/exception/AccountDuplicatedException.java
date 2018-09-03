package exception;

public class AccountDuplicatedException extends RuntimeException {
    @Override
    public String getMessage() {
        return "This account is duplicated, pls change another one";
    }
}
