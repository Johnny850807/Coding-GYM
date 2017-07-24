package ��a�p�C��;

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
			System.out.println("��J�a�Ϥj�p(1~10)");
			mapSize = input.nextInt();
			System.out.println("��J�a�p�ƶq(1~" + (mapSize * mapSize) + ")");
			landmineAmount = input.nextInt();

			LandmineGame landmineGame = new LandmineGame(mapSize, landmineAmount);
			landmineGame.playGame();
			

			System.out.println("�O�_�n�A�Ӥ@��?(y/n):");
			again = input.next();
			
		} while (again.equals("y") || again.equals("Y"));
		
	}

}
