package �i�����U�t��;

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

		System.out.println("�п�J�b��: ");
		account = input.nextLine();
		System.out.println("�п�J�K�X: ");
		password = input.nextLine();

		String str = UI.checkSignIn(account, password);
		System.out.println("-------------");
		System.out.print(str);

	}

	public void signUp() throws AccountDuplicatedException {

		System.out.println("�п�J�b��: ");
		account = input.nextLine();
		System.out.println("�п�J�K�X: ");
		password = input.nextLine();
		System.out.println("�п�J�W��: ");
		name = input.nextLine();

		System.out.println("���U���\!");
		UI.checkAccountDuplicated(account);
		UI.addUser(account, password, name);
	}

}
