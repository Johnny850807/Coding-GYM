package �ҥ~�B�z_�n�J;

import java.util.Scanner;

import �n�J�t��.CheckUserAvailable;
import �n�J�t��.PairInfoNotFound;


public class signInSystem {

	public static void main(String[] args) throws PairInfoNotFound {
		Scanner input = new Scanner(System.in);
		CheckUserAvailable checkUserAvailable = new CheckUserAvailable();
		boolean isLogin = false;
		
		while (!isLogin) {
			System.out.print("�п�J�b��: ");
			String account = input.next();
			System.out.print("�п�J�K�X: ");
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
