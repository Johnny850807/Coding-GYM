package 踩地雷;

import java.util.Scanner;

public class Game {

	Scanner input = new Scanner(System.in);
	private int size, mineAmount;
	private Chess[][] chess;
	private boolean gameover;
	private int guessTime;
	private int row, col;

	public Game(int size, int mineAmount) {
		this.size = size;
		this.mineAmount = mineAmount;
		chess = new Chess[size][size];
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				chess[i][j] = new Chess();
		gameover = false;
		guessTime = 0;
	}

	public void startGame() {

		confMines(mineAmount);
		minesNearByChoose();
		do {
			displayCheckerBoard(size);
			System.out.println("請輸入欲選座標: ");
			row = input.nextInt();
			col = input.nextInt();
			guessTime++;
			if (chess[row][col].isMine()) {
				gameover = true;
				displayFianlResult();
				System.out.println("You Lose!!");
			} else {
				chess[row][col].setOpen(true);
				if (size * size - guessTime == mineAmount) {
					displayFianlResult();
					System.out.println("You Win!!");
					gameover = true;
				}
			}

		} while (!gameover);

	}

	public void confMines(int mineAmount) {
		for (int i = 0; i < mineAmount; i++) {
			boolean isMine = false;
			while (!isMine) {
				row = (int) (Math.random() * mineAmount);
				col = (int) (Math.random() * mineAmount);
				if (!chess[row][col].isMine()) {
					chess[row][col].setMine(true);
					isMine = true;
				}
			}
		}

	}

	public void displayCheckerBoard(int size) {
		System.out.print("＼ ");
		for (int i = 0; i < size; i++)
			System.out.print(i + " ");
		System.out.println();

		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++) {
				chess[i][j].displayCheckerBoard(gameover);
			}
			System.out.println();
		}

	}

	public void minesNearByChoose() {
		for (int i = 0; i < size; i++)
			for (int j = 0; j < size; j++)
				if (!chess[i][j].isMine()) {
					int nearByMines = 0;
					for (int k = i - 1; k < i + 2; k++)
						if (k >= 0 && k < size)
							for (int l = j - 1; l < j + 2; l++)
								if (l >= 0 && l < size && chess[k][l].isMine())
									nearByMines++;
					chess[i][j].setNearByMines(nearByMines);
				}
	}

	public void displayFianlResult() {
		System.out.print("＼ ");
		for (int i = 0; i < size; i++)
			System.out.print(i + " ");
		System.out.println();
		for (int i = 0; i < size; i++) {
			System.out.print(i + " ");
			for (int j = 0; j < size; j++)
				chess[i][j].displayCheckerBoard(gameover);
			System.out.println();
		}
	}

}
