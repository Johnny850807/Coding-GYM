package 踩地雷遊戲;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class LandmineGame {
	private ArrayList<ArrayList<Item>> landmines;
	private int size;
	private int landmineAmount;
	private int guessTimes;
	private boolean isOver;
	
	public LandmineGame(ArrayList<ArrayList<Item>> landmines, int size, int landmineAmount) {
		super();
		this.landmines = landmines;
		this.size = size;
		this.landmineAmount = landmineAmount;
		guessTimes = 0;
		isOver = false;
	}

	public LandmineGame() {
		super();
		guessTimes = 0;
		isOver = false;
	}

	public void computeNearbyLandmineAmount() {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				if(!landmines.get(i).get(j).isLandmine()) {
					int landmineAmount = 0;
					for (int k = i-1; k < i+2 ; k++) {
						if (k >= 0 && k < size) {
							for (int l = j-1; l < j+2 ; l++) {
								if (l >= 0 && l < size && landmines.get(k).get(l).isLandmine())
										landmineAmount++;
							}
						}
					}
					landmines.get(i).get(j).setNearbyLandmineAmount(landmineAmount);
				}
			}
		}
	}
	
	public void siteLandmine() {
		int l = landmineAmount;
		do {
			Random ran = new Random(); 
			int row = (int) ran.nextInt(size);
			int col = (int) ran.nextInt(size);
			if (landmines.get(row).get(col).isLandmine()) {
				continue;
			}
				
			else 
				landmines.get(row).get(col).setLandmine(true);
			l--;
		} while (l != 0);
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
			if(landmines.get(row).get(col).isLandmine()) {
				isOver = true;
				displayNearbyLandmineAmount();
				System.out.println("====== 踩到地雷了 !!!! 遊戲結束 ======");
			}
			else {
				landmines.get(row).get(col).setOpen(true);
				if (guessTimes + landmineAmount == size * size) {
					isOver = true;
					System.out.println("====== 贏了 !!!! 遊戲結束 ======");
				}
				displayNearbyLandmineAmount();
			}
		}
			
	}
	
	public void displayNearbyLandmineAmount() {
		System.out.print("  ");
		for (int i = 0; i < size; i++) 
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				if (!isOver) {
					if(landmines.get(i).get(j).isOpen())
						System.out.print(landmines.get(i).get(j).getNearbyLandmineAmount() + " ");
					else
						System.out.print("- ");
				}
				else {
					if (landmines.get(i).get(j).isLandmine())
						System.out.print("* ");
					else 
						System.out.print(landmines.get(i).get(j).getNearbyLandmineAmount() + " ");
				}
			}
			System.out.println();
		}
	}
	
	public void displayLandmineSite() {
		System.out.print("  ");
		for (int i = 0; i < size; i++) 
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				if (landmines.get(i).get(j).isLandmine())
					System.out.print("1 ");
				else 
					System.out.print("0 ");
			}
			System.out.println();
		}
	}
	
}
