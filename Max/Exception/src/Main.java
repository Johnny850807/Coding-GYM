import java.util.Scanner;

public class Main {
	public static void main(String[] args){
		final String account = "123";
		final String password = "567";
		String inputAccount;
		String inputPassword;
		boolean check = false;
		Scanner scanner = new Scanner(System.in); 
		while(!check){
			
			try{
				System.out.print("輸入帳號: ");
				inputAccount = scanner.next();
				System.out.print("輸入密碼: ");
				inputPassword = scanner.next();
				if( inputAccount.equals(account) == false && inputPassword.equals(password)){
					throw new AccountException("帳號不符合");
				}
				else if(inputAccount.equals(account) && inputPassword.equals(password) == false){
					throw new PasswordException("密碼不符合");
				}
				else if(inputAccount.equals(account) == false && inputPassword.equals(password) == false){
					throw new AccountAndPasswordException("帳密不符合");
				}
			}catch(Exception e){
				e.printStackTrace();
	        }
			
		}
				
	}
}
