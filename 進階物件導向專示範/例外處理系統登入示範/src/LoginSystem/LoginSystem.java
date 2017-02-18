package LoginSystem;

public class LoginSystem {
	private final static String ACCOUNT = "123";
	private final static String PASSWORD = "567";
	public static void checkUserAvailable(String account , String password)
	throws AccountNotFoundException,PasswordNotFoundException,PairInfoNotFoundException
	{
		boolean accountError = checkAccountError(account);
		boolean passwordError = checkPasswordError(password);
		if( accountError && passwordError)
			throw new PairInfoNotFoundException();
		if(accountError)
			throw new AccountNotFoundException();
		if(passwordError)
			throw new PasswordNotFoundException();
	}
	public static boolean checkAccountError(String account){
		return !account.equals(ACCOUNT);
	}
	public static boolean checkPasswordError(String password){
		return !password.equals(PASSWORD);
	}
}
