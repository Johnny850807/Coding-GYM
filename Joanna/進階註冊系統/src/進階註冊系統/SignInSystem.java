package �i�����U�t��;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

public class SignInSystem extends RegistrationSystem {
	
	public void signIn() throws UserInformationNotFoundException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("��J�b��: ");
		account = input.next();
		System.out.println("��J�K�X: ");
		password = input.next();

		compare();
	}
	
	public void compare() throws UserInformationNotFoundException {
		UserInformation ui = UserInformation.getInstance();
		name = ui.compare(account, password);
		System.out.println("�w��n�J !! " + name);
	}
	
}
