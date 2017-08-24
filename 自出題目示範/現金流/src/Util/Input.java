package Util;

import java.util.Scanner;
public class Input {
	private static final Scanner scanner = new Scanner(System.in);
	
	public static String nextLine(String message){
		String input;
		System.out.print(message);
		if (!message.isEmpty())
			System.out.println();
		do
		{
			input = scanner.nextLine();
		}while(input.isEmpty());
		return input;
	}
	
	public static String next(){
		return nextLine("");  // empty message
	}
	
	public static String next(String message){
		String input;
		System.out.print(message);
		if (!message.isEmpty())
			System.out.println();
		do
		{
			input = scanner.next();
		}while(input.isEmpty());
		return input;
	}
	
	public static String nextLine(){
		return nextLine("");  // empty message
	}
	
	public static int nextInt(String message){
		while(true)
		{
			try{
				String input  = next(message);
				return Integer.valueOf(input.trim());
			}catch(NumberFormatException err){ 
				System.out.println("輸入錯誤");
			}
		}
	}
	
	public static int nextInt(String message, int min, int max){
		int input;
		do
		{
			input = nextInt(message);
			if (input > max || input < min)
				System.out.println("請輸入數字" + min + "~" + max);
		}while(input > max || input < min);
		return input;
	}
	
	
	public static int nextInt(){
		return nextInt("");
	}
	
	public static int nextInt(int min, int max){
		return nextInt("", min, max);
	}
}
