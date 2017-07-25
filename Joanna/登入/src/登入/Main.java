package 登入;

import java.util.Scanner;

public class Main {

	public static void main(String [] args) throws PairInfoNotFoundException {

		Scanner input = new Scanner(System.in);
		boolean isSignIn = false;
		
		SignInSystem signInSystem = new SignInSystem();
		do {
			System.out.println("輸入帳號:");
			String account = input.next();
			System.out.println("輸入密碼: ");
			String password = input.next();
			
			try {
				isSignIn = signInSystem.compare(account, password);
			} catch (Exception ex) {
				System.out.println(ex.getMessage());
			}
			System.out.println();
			
		} while (!isSignIn);
		
		
	}
}
