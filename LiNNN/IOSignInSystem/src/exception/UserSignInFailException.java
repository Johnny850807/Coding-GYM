package exception;

public class UserCanNotSignInException extends RuntimeException {
    @Override
    public String getMessage() {
        return "Pls check your account & password is correct";
    }
}
