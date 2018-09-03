package exception;

public class UserSignInFailException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Pls check your account & password is correct";
    }
}
