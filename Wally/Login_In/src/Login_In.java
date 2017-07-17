import java.io.IOException;
import java.util.Scanner;
public abstract class Login_In {

public static final String account = "123" ;
public static final String password = "567" ;

public static void checkAccountAndPassword ( String account , String password ) throws AccountNotFoundException,PasswordNotFoundException,PairInfoNotFoundException{
	if (!account.equals(Login_In.account) && !password.equals(Login_In.password) )
	throw new PairInfoNotFoundException() ;
	else if (!account.equals(Login_In.account) && password.equals(Login_In.password))
		throw new AccountNotFoundException() ;
	else if (account.equals(Login_In.account) && !password.equals(Login_In.password))
		throw new PasswordNotFoundException() ;
	else
		return ;
}
	public static void main(String[] args) {
	
		Scanner scanner = new Scanner(System.in);
		String account , password ;
		
		do
		{
			try{
				System.out.print("輸入帳號 :");
				account = scanner.nextLine() ;
				System.out.print("輸入密碼 :");
				password = scanner.nextLine();
			
				checkAccountAndPassword(account,password);	
				System.out.println("登入成功!!!");
				break;
			}catch(Exception e){
				System.out.println(e);
	//			e.printStackTrace();
			}
		}while(true);
	}
}