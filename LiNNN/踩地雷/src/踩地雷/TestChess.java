package 踩地雷;

import java.util.Scanner;

public class TestChess {

	public static void main(String[] args) {
		int size, mineAmount;
		
		Scanner input = new Scanner(System.in);
		System.out.print("請輸入地圖大小: ");
		size = input.nextInt();
		System.out.print("請輸入地雷數量(1 ~ " + (size * size) + " ): ");
		mineAmount = input.nextInt();
		Game game = new Game(size, mineAmount);
		game.startGame();

		
	}
}
