package ¶i¶¥µù¥U¨t²Î;

import java.util.Scanner;

public class Main {
	
	public static void main(String [] args) {

		Scanner input = new Scanner(System.in);
		int selection;
		
		File file = File.getInstance();
		do {
			System.out.println("(0) µn¤J (1) µù¥U±b±K (2) Â÷¶}:");
			selection = input.nextInt();
			if (selection == 0) {
				SignInSystem signInSystem = new SignInSystem();
				signInSystem.signIn();
			}
			else if (selection == 1) {
				SignUpSystem signUpSystem = new SignUpSystem();
				signUpSystem.signUp();
			}
			else if (selection == 2) {
				break;
			}
			else {
				System.out.println("¿é¤J¿ù»~");
			}
		} while (selection != 2);
		file.writeFile();
		
	}
	
}
