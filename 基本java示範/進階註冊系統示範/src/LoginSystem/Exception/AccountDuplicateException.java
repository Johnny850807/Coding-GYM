package LoginSystem.Exception;

public class AccountDuplicateException extends Exception{
	public AccountDuplicateException(){
		super("帳號已存在 !!");
	}
}
