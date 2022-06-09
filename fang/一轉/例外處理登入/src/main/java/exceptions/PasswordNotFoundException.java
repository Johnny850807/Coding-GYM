package exceptions;

public class PasswordNotFoundException extends RuntimeException{
    public PasswordNotFoundException(String msg) {
        super(msg);
    }
}
