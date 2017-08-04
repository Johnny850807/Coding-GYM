package ¶i¶¥µù¥U¨t²Î;

public class AccountDuplicatedException extends Exception {

	@Override
	public String getMessage() {
		return "Account is duplicated, please change a new one";
	}
	
}
