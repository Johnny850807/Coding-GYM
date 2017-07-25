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
			} catch (AccountNotFoundException a) {
				System.out.println("帳號不符合");
			} catch (PasswordNotFoundException p) {
				System.out.println("密碼不符合");
			} catch (PairInfoNotFoundException p) {
				System.out.println("帳密不符合");
			}
			System.out.println();
			
		} while (!isSignIn);
		
		
	}
}
