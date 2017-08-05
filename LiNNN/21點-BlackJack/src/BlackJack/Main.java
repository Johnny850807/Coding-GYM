package BlackJack;

import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("請輸入玩家人數: ");
		int realPlayerAmount = input.nextInt();
		System.out.println("請輸入AI人數: ");
		int AiPlayerAmount = input.nextInt();
		BlackJack blackJack = new BlackJack(realPlayerAmount, AiPlayerAmount);
		blackJack.startGame();
	}

}
