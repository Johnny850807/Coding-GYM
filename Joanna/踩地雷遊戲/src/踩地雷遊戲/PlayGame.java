package 踩地雷遊戲;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String again;
		int mapSize;
		int landmineAmount;
		
		do {
			System.out.println("輸入地圖大小(1~10)");
			mapSize = input.nextInt();
			System.out.println("輸入地雷數量(1~" + (mapSize * mapSize) + ")");
			landmineAmount = input.nextInt();

			LandmineGame landmineGame = new LandmineGame(mapSize, landmineAmount);
			landmineGame.playGame();
			

			System.out.println("是否要再來一場?(y/n):");
			again = input.next();
			
		} while (again.equals("y") || again.equals("Y"));
		
	}

}
