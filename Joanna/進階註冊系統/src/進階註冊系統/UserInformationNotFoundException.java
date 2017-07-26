package 進階註冊系統;

public class UserInformationNotFoundException extends Exception {
	
	@Override
	public String getMessage() {
	    return "帳密不符合";
	}
	
}
