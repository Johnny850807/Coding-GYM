package ½ò¦a¹p;

public class GameChecker {
	private boolean gameover = false;
	private int landminesNearByChoose = 0;

	public void checkChoose(int row, int col, int[] row_A, int[] col_A) {
		for (int i = 0; i < row_A.length; i++) {
			if (row == row_A[i] && col == col_A[i]) {
				gameover = true;
			}
		}
		if (!gameover)
			checkLandminesNearByChoose(row, col, row_A, col_A);
	}

	public void checkLandminesNearByChoose(int row, int col, int[] row_A, int[] col_A) {
		landminesNearByChoose = 0;
		for (int i = row - 1; i <= row + 1; i++)
			for (int j = col - 1; j <= col + 1; j++)
				for (int x = 0; x < row_A.length; x++)
					if (i == row_A[x] && j == col_A[x])
						landminesNearByChoose++;
	}

	public boolean gameover() {
		return gameover;
	}

	public int getLandminesNearByChoose() {
		return landminesNearByChoose;
	}

}
