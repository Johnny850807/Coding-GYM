package Util;

import java.util.Scanner;

public class Input {
	private static Scanner scanner = new Scanner(System.in);
	
	public static String nextName(){
		System.out.println("請輸入名子: ");
		return scanner.nextLine();
	}
	
	public static int nextInt(String message){
		System.out.println(message);
		return scanner.nextInt();
	}
	
	public static char nextChar(String message){
		System.out.println(message);
		String input = getValidString();
		return input.charAt(0);
	}
	
	public static boolean nextYesOrNo(String message){
		System.out.println(message);
		String input = getValidString();
		return Character.toUpperCase(input.charAt(0)) == 'Y' ? true : false ;
	}
	
	private static String getValidString(){
		String input = "";
		do
		{
			input = scanner.nextLine();
		}while( input.isEmpty() );
		return input;
		
	}
}
