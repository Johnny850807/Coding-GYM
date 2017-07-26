package �i�����U�t��;

import java.util.Scanner;

public class SignUpSystem extends RegistrationSystem {
	
	public void signUp() {
		
		Scanner input = new Scanner(System.in);

		System.out.println("��J�W��: ");
		name = input.next();
		System.out.println("��J�b��: ");
		account = input.next();
		System.out.println("��J�K�X: ");
		password = input.next();
		
		compare();
		
	}
	
	public void compare() {
		UserInformation ui = UserInformation.getInstance();
		try {
			ui.compare(account);
			System.out.println("�n�J���\ " + name);
			addUserInformation();
		} catch (UserAccountIsExistedException e) {
			System.out.println(e.getMessage());
		}
	}
	
	public void addUserInformation() {
		UserInformation ui = UserInformation.getInstance();
		ui.addUserInformation(account, password, name);
	}
	
}
