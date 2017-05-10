package account;
import java.io.*;
import java.util.Scanner;

public class Main {
	
	public static void staring(){
		System.out.println("(0) LogIn (1) SignUp (2) Exit"+File.separator+"~~"+File.pathSeparator);

		
		
		
		
		Scanner sc=new Scanner(System.in);
		String choose=sc.nextLine();
		
		AccountSystem accountSystem=new AccountSystem();
		
		switch(choose)
		{
			case "0":
				accountSystem.LogIn();
				break;
	
			case "1":
				accountSystem.SingUp();
				break;
	
			case "2":
				System.out.println("Closing System");
				break;
		
		}
	}

	public static void main(String[] args){ 
	
		staring();
		

	}

}
