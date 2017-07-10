package Game;

import java.util.Scanner;

public class Input {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String nextLine(String message){
		String input = "-";
		do
		{
			if (input.isEmpty())
				System.out.println("請再輸入一次 ! ");
			System.out.println(message);
			input = scanner.nextLine();
		}while( input.isEmpty() );  
		return input;
	}
	
	public static int nextInt(String message, int max){
		int input = 0;
		do
		{
			if ( input >= max || input < 0 )
				System.out.println("請再輸入一次 ! ");
			System.out.println(message);
			input = scanner.nextInt();
		}while( input >= max || input < 0  );  
		return input;
	}
}
