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
				System.out.print("��J�b��: ");
				inputAccount = scanner.next();
				System.out.print("��J�K�X: ");
				inputPassword = scanner.next();
				if( inputAccount.equals(account) == false && inputPassword.equals(password)){
					throw new AccountException("�b�����ŦX");
				}
				else if(inputAccount.equals(account) && inputPassword.equals(password) == false){
					throw new PasswordException("�K�X���ŦX");
				}
				else if(inputAccount.equals(account) == false && inputPassword.equals(password) == false){
					throw new AccountAndPasswordException("�b�K���ŦX");
				}
			}catch(Exception e){
				e.printStackTrace();
	        }
			
		}
				
	}
}
