package Main;

import java.util.Scanner;
import LoginSystem.*;
import static LoginSystem.LoginSystem.*;


public class Main {
	static Scanner input = new Scanner(System.in);
	public static void main(String[] args) {
		boolean available = false;
		do{
			try {
				checkUserAvailable(userInputAccount(),userInputPassword());
				available = true;
			} catch (AccountNotFoundException | PasswordNotFoundException | PairInfoNotFoundException e) {
				System.out.println(e.getMessage());
			}
		}while(!available);
		System.out.println("登入成功!");
	}
	static String userInputAccount(){
		String account;
		do
		{
			System.out.println("輸入帳號:");
			account = input.nextLine();
		}while(account.length() == 0);
		return account;
	}
	static String userInputPassword(){
		String password;
		do
		{
			System.out.println("輸入密碼:");
			password = input.nextLine();
		}while(password.length() == 0);
		return password;
	}
}
