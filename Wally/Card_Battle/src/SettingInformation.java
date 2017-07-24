import java.util.Scanner;

public abstract class SettingInformation {
	
	static Scanner input = new Scanner(System.in);
	private	static String userOption = " " ;

	public SettingInformation() {
	}
	
	public static void setUserOption(){ 
		String inputUserOption = " ";
		do{
		System.out.println("請選擇玩家或電腦 : (A) 電腦  (B) 玩家 ");	
		inputUserOption = input.nextLine();
		inputUserOption = inputUserOption.toUpperCase();
		}while (isWrongWord(inputUserOption.charAt(0)));
		
		userOption = opponent(inputUserOption.charAt(0)) ;
	}
	
	public static String getUserOption(){
		return userOption ;
	}
	
	private static String opponent ( char userOption ){
		if	( userOption == 'A' )
			return "電腦" ;
		else
			return "玩家" ;
	}

	private static boolean isWrongWord ( char inputUserOption ) {
		
		switch( inputUserOption ){	
		case 'A':	
		System.out.println("已選擇了電腦!");
		return 	false ;	
		
		case 'B':	
		System.out.println("已選擇了玩家!");
		return 	false ;	
		
		default :
		System.out.println("輸入錯誤 , 請重新輸入:");
		return 	true ;
		}
	}	
}
