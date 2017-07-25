package ��a�p;

import java.util.Scanner;

public class GamePanel {
	Scanner input = new Scanner(System.in);

	public void startGame() {

		GameChecker GC = new GameChecker();

		System.out.print("�п�J�a�Ϥj�p(1~10): ");
		int size = input.nextInt();
		System.out.print("�п�J�a�p�ƶq(1~" + (size * size) + "): ");
		int landminesAmount = input.nextInt();
		Checkerboard checkerboard = new Checkerboard(size, landminesAmount);

		checkerboard.confLandmines(landminesAmount);
		checkerboard.displayCheckerBoard(size);

		do {
			System.out.print("�п�J��ܮ�l�y��: ");
			int row = input.nextInt();
			int col = input.nextInt();
			GC.checkChoose(row, col, checkerboard.getRow(), checkerboard.getCol());
			if (!GC.gameover())
				checkerboard.displayChooseResult(size, row, col, GC.getLandminesNearByChoose());
			else
				checkerboard.displayFinalResult(size, row, col);
			
		} while (!GC.gameover());

	}

}
