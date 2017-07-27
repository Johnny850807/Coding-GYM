package �i�����U�t��;

import java.util.Scanner;

public class SignUpSystem extends RegistrationSystem {
	
	public void signUp() throws UserAccountIsExistedException {
		
		Scanner input = new Scanner(System.in);

		System.out.println("��J�W��: ");
		name = input.next();
		System.out.println("��J�b��: ");
		account = input.next();
		System.out.println("��J�K�X: ");
		password = input.next();
		
		compare();
	}
	
	public void compare() throws UserAccountIsExistedException {
		UserInformation ui = UserInformation.getInstance();
		ui.compare(account);
		System.out.println("�n�J���\ " + name);
		saveUserInformation();
	}
	
	public void saveUserInformation() {
		UserInformation ui = UserInformation.getInstance();
		ui.addUserInformation(account, password, name);
	}
	
}
