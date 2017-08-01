package 例外處理_登入;

import java.util.Scanner;

import 登入系統.CheckUserAvailable;
import 登入系統.PairInfoNotFound;


public class signInSystem {

	public static void main(String[] args) throws PairInfoNotFound {
		Scanner input = new Scanner(System.in);
		CheckUserAvailable checkUserAvailable = new CheckUserAvailable();
		boolean isLogin = false;
		
		while (!isLogin) {
			System.out.print("請輸入帳號: ");
			String account = input.next();
			System.out.print("請輸入密碼: ");
			String password = input.next();
			
			try {
				checkUserAvailable.checkUser(account, password);
				isLogin = true;
			}catch (PairInfoNotFound ex) {
				System.out.println(ex.getMessage());
			}
			
		}
	}

}
