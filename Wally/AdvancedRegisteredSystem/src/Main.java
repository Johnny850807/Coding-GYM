import java.io.*;
import java.util.Scanner; 

public class Main {
	
	public static Scanner input = new Scanner(System.in);

	public static void main(String[] args)	throws IOException {
		
		// ..//資源區//IO進階登入//帳密.txt
		
		do {
			System.out.println("(0) 登入 (1) 註冊帳密 (2) 離開:");
			
			try {
			
			userSignInOrCreateNewAccountOrLeave();
			
			}catch(	InputWrongWordException e ){
				
			}catch(	IOException e ){
			System.out.println("No File");
			}
			
		}while(AskYesOrNoForNextRound());	
	
	}
	
	private static void userSignInOrCreateNewAccountOrLeave() throws IOException {
		
		String userOptions = input.nextLine() ;

		StringBuilder accountDatas = new StringBuilder () ;
		
		switch ( userOptions ) {
		
		case "0":
	
		AccountSystem signInSystem = new SignInSystem();
		
		break;
		
		case "1":
		
		AccountSystem signUpSystem = new SignUpSystem();
		
		break;
		
		case "2":
				
		System.out.println("系統關閉");
		
		break;
		
		default :
		
		throw new InputWrongWordException() ;
		
		}
	}
	
	private static boolean AskYesOrNoForNextRound() {
		
		System.out.println("是否要重來一次(Y/N)");
		
		String answer = input.nextLine().toUpperCase();
		
		return answer.equals("Y");
	}

}
