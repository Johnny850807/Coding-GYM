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
				System.out.print("��J�b�� :");
				account = scanner.nextLine() ;
				System.out.print("��J�K�X :");
				password = scanner.nextLine();
			
				checkAccountAndPassword(account,password);	
				System.out.println("�n�J���\!!!");
				break;
			}catch(Exception e){
				System.out.println(e);
	//			e.printStackTrace();
			}
		}while(true);
	}
}