package 踩地雷;

import java.util.Scanner;

public class GamePanel {
	Scanner input = new Scanner(System.in);

	public void startGame() {

		GameChecker GC = new GameChecker();

		System.out.print("請輸入地圖大小(1~10): ");
		int size = input.nextInt();
		System.out.print("請輸入地雷數量(1~" + (size * size) + "): ");
		int landminesAmount = input.nextInt();
		Checkerboard checkerboard = new Checkerboard(size, landminesAmount);

		checkerboard.confLandmines(landminesAmount);
		checkerboard.displayCheckerBoard(size);

		do {
			System.out.print("請輸入選擇格子座標: ");
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
