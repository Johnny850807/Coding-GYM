package ½ò¦a¹p;

public class Checkerboard {
	private int size;
	private int landminesAmount;
	private String[][] checkerBoard;
	private int[] row_A;
	private int[] col_A;
	int row, col;

	public Checkerboard(int size, int landminesAmount) {
		this.size = size;
		this.landminesAmount = landminesAmount;
		checkerBoard = new String[size][size];
		row_A = new int[landminesAmount];
		col_A = new int[landminesAmount];
	}

	public void displayCheckerBoard(int size) {
		for (int i = 0; i < size; i++) {
			for (int j = 0; j < size; j++) {
				checkerBoard[i][j] = "-";
			}
		}

		System.out.print("¢@ ");
		for (int i = 0; i < size; i++)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				System.out.print(checkerBoard[i][j] + " ");
			}
			System.out.println();
		}

	}

	public void confLandmines(int landminesAmount) {
		for (int i = 0; i < landminesAmount; i++) {
			boolean isLandmines = false;
			while (!isLandmines) {
				row = (int) (Math.random() * 5);
				col = (int) (Math.random() * 5);
				if (checkerBoard[row][col] != "*") {
					checkerBoard[row][col] = "*";
					isLandmines = true;
				}
				row_A[i] = row;
				col_A[i] = col;
			}

		}

	}

	public void displayChooseResult(int size, int row, int col, int landminesNearByChoose) {
		checkerBoard[row][col] = Integer.toString(landminesNearByChoose);

		System.out.print("¢@ ");
		for (int i = 0; i < size; i++)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				System.out.print(checkerBoard[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void displayFinalResult(int size, int row, int col) {
		GameChecker GC = new GameChecker();

		System.out.print("¢@ ");
		for (int i = 0; i < size; i++)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				GC.checkLandminesNearByChoose(i, j, row_A, col_A);
				checkerBoard[i][j] = Integer.toString(GC.getLandminesNearByChoose());
				for (int x = 0; x < landminesAmount; x++)
					if (i == row_A[x] && j == col_A[x])
						checkerBoard[i][j] = "*";
				System.out.print(checkerBoard[i][j] + " ");
			}
			System.out.println();
		}
		System.out.println("GameOver!! Bitch!!");
	}

	public int[] getRow() {
		return row_A;
	}

	public int[] getCol() {
		return col_A;
	}

}
