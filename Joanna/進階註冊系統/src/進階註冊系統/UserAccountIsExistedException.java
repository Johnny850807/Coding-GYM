package 進階註冊系統;

public class UserAccountIsExistedException extends Exception {
	
	@Override
	public String getMessage() {
	    return "帳號已存在";
	}
	
}
