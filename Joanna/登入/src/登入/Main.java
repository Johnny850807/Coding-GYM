package �n�J;

import java.util.Scanner;

public class Main {

	public static void main(String [] args) throws PairInfoNotFoundException {

		Scanner input = new Scanner(System.in);
		boolean isSignIn = false;
		
		SignInSystem signInSystem = new SignInSystem();
		do {
			System.out.println("��J�b��:");
			String account = input.next();
			System.out.println("��J�K�X: ");
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
