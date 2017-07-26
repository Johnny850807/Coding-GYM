package 進階註冊系統;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SignInSystem extends RegistrationSystem {
	
	public void signIn() {
		Scanner input = new Scanner(System.in);
		
		System.out.println("輸入帳號: ");
		account = input.next();
		System.out.println("輸入密碼: ");
		password = input.next();

		compare();
		
	}
	
	public void compare() {
		UserInformation ui = UserInformation.getInstance();
		try {
			name = ui.compare(account, password);
			System.out.println("歡迎登入 !! " + name);
		} catch (UserInformationNotFoundException e) {
			System.out.println(e.getMessage());
		}
	}
	
}
