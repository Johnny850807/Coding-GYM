package advancedloginsystem.execption;

public class UserDuplicateException extends RuntimeException{
    public UserDuplicateException() {
        super("帳號已存在!!!");
    }
}
