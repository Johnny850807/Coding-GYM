package advancedloginsystem.execption;

public class UserNotFoundException extends RuntimeException{
    public UserNotFoundException() {
        super("帳密錯誤!");
    }
}
