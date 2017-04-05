package LoginSystem;
import java.util.Scanner;

public class Login {
	
		private final static String account="123",password="567";
		private static String LogIn_Account,LogIn_Password;
		private static boolean login_fail=true;

	public static void main(String[] args) {
		

		do{
			
					Scanner sc=new Scanner(System.in);
					System.out.print("輸入帳號: ");
					LogIn_Account =sc.nextLine();

					System.out.print("輸入密碼: ");
					LogIn_Password =sc.nextLine();
				
				try{
				
						if(!LogIn_Account.equals(account)){
							login_fail=false;
							throw new AccountNotFoundException();
						}
						else if(!LogIn_Password.equals(password)){
							login_fail=false;
							throw new PasswordNotFoundException();
						}
						else if(!LogIn_Account.equals(account) && !LogIn_Password .equals(password)){
							login_fail=false;
							throw new PairInfoNotFoundException();
						}
						
						
						if(login_fail=true){
							System.out.println("登入成功");
							break;
						}
						
				
					}catch(AccountNotFoundException a){
							a.printStackTrace();
						}
					 catch(PasswordNotFoundException p){
						 	p.printStackTrace();
				 		}
					 catch(PairInfoNotFoundException p){
						 	p.printStackTrace();
					 	}
			
				
				
		}while(login_fail==false);
				
			
					
				
	


}
}
