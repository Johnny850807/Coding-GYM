package �i�����U�t��;

public class AccountDuplicatedException extends Exception {

	@Override
	public String getMessage() {
		return "Account is duplicated, please change a new one";
	}
	
}
