package BlackJack;

import java.util.Scanner;

public class Main {
	
	public static void main (String[] args) throws InterruptedException {
		Scanner input = new Scanner(System.in);
		
		System.out.println("�п�J���a�H��: ");
		int realPlayerAmount = input.nextInt();
		System.out.println("�п�JAI�H��: ");
		int AiPlayerAmount = input.nextInt();
		BlackJack blackJack = new BlackJack(realPlayerAmount, AiPlayerAmount);
		blackJack.startGame();
	}

}
