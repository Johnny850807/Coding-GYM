package 登入;

public class SignInSystem {
	final static String account = "123";
	final static String password = "567";
	
	public boolean compare(String account, String password) throws PairInfoNotFoundException {
		
		if (!SignInSystem.account.equals(account) && !SignInSystem.password.equals(password)) {
			throw new PairInfoNotFoundException(); 
		}
		else if (!SignInSystem.account.equals(account)) {
			throw new AccountNotFoundException();
		}
		else if (!SignInSystem.password.equals(password)) {
			throw new PasswordNotFoundException();
		}
		else {
			System.out.println("登入成功");
			return true;
		}
		
	}
	
}
