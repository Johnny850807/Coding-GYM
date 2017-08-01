package 卡牌戰鬥遊戲;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("選擇對抗：(1)AI玩家 (2)真實玩家");
		int selection = input.nextInt();
		Game game = new Game(selection);
		game.startGame();
	}

}
