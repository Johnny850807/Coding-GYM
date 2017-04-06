import java.util.Scanner;

public class Account {
	Scanner input = new Scanner (System.in);
	
	private String account;
	private String password;
	
	public void SignUp() {
	
		System.out.println("Sign up");
		System.out.println("------------------------");
		System.out.println("Enter account: ");
		account = input.nextLine();
		System.out.println("Enter password: ");
		password = input.nextLine();
		System.out.println("------------------------");
	
	}
	
}
