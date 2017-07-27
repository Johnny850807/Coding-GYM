package 進階註冊系統;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SignInSystem extends RegistrationSystem {
	
	public void signIn() throws UserInformationNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("輸入帳號: ");
		account = input.next();
		System.out.println("輸入密碼: ");
		password = input.next();

		compare();
	}
	
	public void compare() throws UserInformationNotFoundException {
		UserInformation ui = UserInformation.getInstance();
		name = ui.compare(account, password);
		System.out.println("歡迎登入 !! " + name);
	}
	
}
