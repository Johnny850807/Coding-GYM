package 登入系統;

public class AccountNotFound extends PairInfoNotFound{

	@Override
	public String getMessage() {
		return "帳號錯誤";
	}
	
}
