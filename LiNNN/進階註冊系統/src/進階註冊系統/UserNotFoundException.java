package �i�����U�t��;

public class UserNotFoundException extends Exception {
	
	@Override
	public String getMessage() {
		return "Cannot find the user, please check if your account or password is correct.";
	}

}
