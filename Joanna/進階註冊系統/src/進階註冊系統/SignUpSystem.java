package 進階註冊系統;

import java.util.Scanner;

public class SignUpSystem extends RegistrationSystem {
	
	public void signUp() {
		
		Scanner input = new Scanner(System.in);

		System.out.println("輸入名稱: ");
		name = input.next();
		System.out.println("輸入帳號: ");
		account = input.next();
		System.out.println("輸入密碼: ");
		password = input.next();
		
		compare();
		
	}
	
	public void compare() {
		UserInformation ui = UserInformation.getInstance();
		try {
			ui.compare(account);
			System.out.println("登入成功 " + name);
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
