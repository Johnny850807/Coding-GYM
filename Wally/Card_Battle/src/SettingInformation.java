import java.util.Scanner;

public abstract class SettingInformation {
	
	static Scanner input = new Scanner(System.in);
	private	static String userOption = " " ;

	public SettingInformation() {
	}
	
	public static void setUserOption(){ 
		String inputUserOption = " ";
		do{
		System.out.println("�п�ܪ��a�ιq�� : (A) �q��  (B) ���a ");	
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
			return "�q��" ;
		else
			return "���a" ;
	}

	private static boolean isWrongWord ( char inputUserOption ) {
		
		switch( inputUserOption ){	
		case 'A':	
		System.out.println("�w��ܤF�q��!");
		return 	false ;	
		
		case 'B':	
		System.out.println("�w��ܤF���a!");
		return 	false ;	
		
		default :
		System.out.println("��J���~ , �Э��s��J:");
		return 	true ;
		}
	}	
}
