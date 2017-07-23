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
			
			ArrayList<ArrayList<Item>> landmines = new ArrayList<ArrayList<Item>>();
			for (int i = 0; i < mapSize; i++) {
				landmines.add(new ArrayList<Item>());
				for (int j = 0; j < mapSize; j++) {
					Item item = new Item();
					landmines.get(i).add(item);
				}
			}

			/*
			int l = landmineAmount;
			do {
				Random ran = new Random(); 
				int row = (int) ran.nextInt(mapSize);
				int col = (int) ran.nextInt(mapSize);
				System.out.println(row + " " + col);
				if (landmines.get(row).get(col).isLandmine()) {
					continue;
				}
					
				else 
					landmines.get(row).get(col).setLandmine(true);
				l--;
			} while (l != 0);
			*/ 
			
			LandmineGame landmineGame = new LandmineGame(landmines, mapSize, landmineAmount);
			landmineGame.playGame();
			

			System.out.println("是否要再來一場?(y/n):");
			again = input.next();
			
		} while (again.equals("y") || again.equals("Y"));
		
	}

}
