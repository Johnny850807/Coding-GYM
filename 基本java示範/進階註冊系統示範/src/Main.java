import java.io.IOException;
import java.util.Scanner;

import LoginSystem.LoginSystem;
import LoginSystem.UserInfo;
import LoginSystem.Exception.AccountDuplicateException;
import LoginSystem.Exception.UserNotFoundException;

public class Main {
	static Scanner input = new Scanner(System.in);
	static LoginSystem system = new LoginSystem();
	static boolean stop = false;
	public static void main(String[] args) {

		while(!stop)
		{
			System.out.println("(0) µn¤J (1) µù¥U±b±K  (2) Â÷¶}: ");
			int action = inputNumber();
			try {
				doAction(action);
			} catch (UserNotFoundException | AccountDuplicateException e) {
				System.out.println(e.getMessage());
			} catch( IOException e){
				e.printStackTrace();
			} finally{
				if (stop)
					closeSystem();
			}
		}
		
	}
	static int inputNumber(){
		int num;
		do{
			num = input.nextInt();
			if (num < 0 || num > 2)
				System.out.println("¿é¤J¿ù»~");
		}while(num < 0 || num > 2);
		return num;
	}
	static void doAction(int action) 
			throws UserNotFoundException, IOException, AccountDuplicateException{
		switch(action)
		{
		case 0:
			logIn();
			break;
		case 1:
			register();
			break;
		case 2:
			stop = true;
		}
	}
	
	static void logIn() throws UserNotFoundException{
		System.out.println("¿é¤J±b¸¹:");
		String account = inputText();
		System.out.println("¿é¤J±K½X:");
		String password = inputText();
		UserInfo user = system.searchUser(account, password);
		System.out.println("Åwªïµn¤J !! "+ user.getName());
	}
	
	static void register() throws IOException, AccountDuplicateException{
		System.out.println("¿é¤J¼ÊºÙ:");
		String name = inputText();
		System.out.println("¿é¤J±b¸¹:");
		String account = inputText();
		System.out.println("¿é¤J±K½X:");
		String password = inputText();
		system.registerUser(name, account, password);
	}
	
	static String inputText(){
		String text;
		do{
			text = input.nextLine();
		}while(text.length() == 0);
		return text;
	}
	
	static void closeSystem(){
		try {
			system.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
