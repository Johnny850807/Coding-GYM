package ¶i¶¥µù¥U¨t²Î;

public class UserNotFoundException extends Exception {
	
	@Override
	public String getMessage() {
		return "Cannot find the user, please check if your account or password is correct.";
	}

}
