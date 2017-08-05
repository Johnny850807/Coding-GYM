package 進階註冊系統;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		LoginSystem loginSystem = new LoginSystem();
		File file = new File();
		boolean Exit = false;

		while (!Exit) {
			System.out.println("請選擇 1.登入 2.註冊 3.Exit: ");
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
