package 二十一點撲克牌遊戲;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		int humanAmount;
		int AIAmount;
		Scanner input = new Scanner(System.in);
		System.out.println("設置玩家數量(0~10):");
		humanAmount = input.nextInt();
		System.out.println("設置電腦數量(1~" + (10-humanAmount) + "):");
		AIAmount = input.nextInt();
		
		BlackJack game = new BlackJack(humanAmount, AIAmount);
		game.playGame();
		
	}

}
