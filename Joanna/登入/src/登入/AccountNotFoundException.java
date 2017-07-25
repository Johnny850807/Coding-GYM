package 登入;

public class AccountNotFoundException extends PairInfoNotFoundException {
	
	@Override
	public String getMessage() {
	    return "帳號不符合";
	}

}
