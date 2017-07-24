package 踩地雷遊戲;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LandmineGame {
	private Item[][] landmines;
	private int mapSize;
	private int landmineAmount;
	private int guessTimes;
	private boolean isOver;
	
	public LandmineGame(int mapSize, int landmineAmount) {
		super();
		this.mapSize = mapSize;
		this.landmineAmount = landmineAmount;
		landmines = new Item[mapSize][mapSize];
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				landmines[i][j] = new Item();
			}
		}
		guessTimes = 0;
		isOver = false;
	}

	public LandmineGame() {
		super();
		guessTimes = 0;
		isOver = false;
	}

	public void computeNearbyLandmineAmount() {
		for (int i = 0; i < mapSize; i++) {
			for (int j = 0; j < mapSize; j++) {
				if(!landmines[i][j].isLandmine()) {
					int nearbyLandmineAmount = 0;
					for (int k = i-1; k < i+2 ; k++) {
						if (k >= 0 && k < mapSize) {
							for (int l = j-1; l < j+2 ; l++) {
								if (l >= 0 && l < mapSize && landmines[k][l].isLandmine()) {
									nearbyLandmineAmount++;
								}
							}
						}
					}
					landmines[i][j].setNearbyLandmineAmount(nearbyLandmineAmount);
				}
			}
		}
	}
	
	public void siteLandmine() {
		int temp = landmineAmount;
		do {
			Random ran = new Random(); 
			int row = (int) ran.nextInt(mapSize);
			int col = (int) ran.nextInt(mapSize);
			if (landmines[row][col].isLandmine()) {
				continue;
			}	
			else 
				landmines[row][col].setLandmine(true);
			temp--;
		} while (temp != 0);
	}
	
	public void playGame() {
		Scanner input = new Scanner(System.in);
		siteLandmine();
		computeNearbyLandmineAmount();
		displayNearbyLandmineAmount();
		while (!isOver) {
			System.out.println("請輸入欲選擇格子座標(y/x):");
			int row = input.nextInt();
			int col = input.nextInt();
			guessTimes++;
			if(landmines[row][col].isLandmine()) {
				isOver = true;
				displayNearbyLandmineAmount();
				System.out.println("====== 踩到地雷了 !!!! 遊戲結束 ======");
			}
			else {
				landmines[row][col].setOpen(true);
				if (guessTimes + landmineAmount == mapSize * mapSize) {
					isOver = true;
					System.out.println("====== 贏了 !!!! 遊戲結束 ======");
				}
				displayNearbyLandmineAmount();
			}
		}
			
	}
	
	public void displayNearbyLandmineAmount() {
		System.out.print("  ");
		for (int i = 0; i < mapSize; i++) 
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < mapSize; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < mapSize; j++) {
				landmines[i][j].displayNearbyLandmineAmount(isOver);
			}
			System.out.println();
		}
	}
	
	public void displayLandmineSite() {
		System.out.print("  ");
		for (int i = 0; i < mapSize; i++) 
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < mapSize; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < mapSize; j++) {
				landmines[i][j].displayLandmine();
			}
			System.out.println();
		}
	}
	
}
