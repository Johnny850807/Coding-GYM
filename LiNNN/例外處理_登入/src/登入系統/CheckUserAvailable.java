package �n�J�t��;

public class CheckUserAvailable {
	
	static final String account = "123";
	static final String password = "567";
	
	public void checkUser(String input_account, String input_password) throws PairInfoNotFound{
		
		if (!account.equals(input_account) && !password.equals(input_password)) {
			throw new PairInfoNotFound();
		}
		else if (!account.equals(input_account)) {
			throw new AccountNotFound();
		}
		else if (!password.equals(input_password)) {
			throw new PasswordNotFound();
		}
		else
			System.out.println("�n�J���\");
	}

}
