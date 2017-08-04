package �i�����U�t��;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LoginSystem loginSystem = new LoginSystem();
		File file = new File();
		boolean Exit = false;

		while (!Exit) {
			System.out.println("�п�� 1.�n�J 2.���U 3.Exit: ");
			int choice = input.nextInt();

			switch (choice) {
			case 1:
				try {
					loginSystem.signIn();
					Exit = true;
				} catch (UserNotFoundException e) {
					e.printStackTrace();
				}
				break;

			case 2:
				try {
					loginSystem.signUp();
					file.writeFile();
				} catch (AccountDuplicatedException e) {
					e.printStackTrace();
				}
				break;

			default:
				System.out.print("Exit...");
				Exit = true;
				break;
			}
		}
	}
}
