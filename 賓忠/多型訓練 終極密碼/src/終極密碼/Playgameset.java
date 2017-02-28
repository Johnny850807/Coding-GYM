package 終極密碼;

import java.util.Scanner;

public class Playgameset {
	
	public static Scanner input = new Scanner(System.in);
	public void set(){
		System.out.println("請輸入人類玩家數量: ");
		int human_number = input.nextInt();
		System.out.println("請輸入奇數AI數量: ");
		int oddAI_number = input.nextInt();
		System.out.println("請輸入偶數AI數量: ");
		int evenAI_number = input.nextInt();
		System.out.println("請輸入一般AI數量: ");
		int generl_number = input.nextInt();
		for(int i=1;i<=human_number;i++){
			String human_name = input.next();
			
		}
	}
}
