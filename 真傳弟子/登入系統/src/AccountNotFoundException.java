public class AccountNotFoundException extends Exception {
    public AccountNotFoundException(){
        super("帳密不符合");
    }
}
