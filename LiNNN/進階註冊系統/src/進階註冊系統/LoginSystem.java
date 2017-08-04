package 進階註冊系統;

import java.util.Scanner;

public class LoginSystem {
	Scanner input = new Scanner(System.in);
	UserList UI = UserList.getInstance();
	File file = new File();
	User user = new User();

	String account;
	String password;
	String name;

	public void signIn() throws UserNotFoundException {

		System.out.println("請輸入帳號: ");
		account = input.nextLine();
		System.out.println("請輸入密碼: ");
		password = input.nextLine();

		String str = UI.checkSignIn(account, password);
		System.out.println("-------------");
		System.out.print(str);

	}

	public void signUp() throws AccountDuplicatedException {

		System.out.println("請輸入帳號: ");
		account = input.nextLine();
		System.out.println("請輸入密碼: ");
		password = input.nextLine();
		System.out.println("請輸入名稱: ");
		name = input.nextLine();

		System.out.println("註冊成功!");
		UI.checkAccountDuplicated(account);
		UI.addUser(account, password, name);
	}

}
