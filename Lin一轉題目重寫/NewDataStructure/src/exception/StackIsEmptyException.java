package exception;

public class StackIsEmptyException extends RuntimeException {
    @Override
    public String getMessage() {
        return "The stack is empty";
    }
}
