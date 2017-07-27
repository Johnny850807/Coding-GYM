package ½ò¦a¹p;

public class Chess {

	private boolean isOpen;
	private boolean isMine;
	private int nearByMines;

	public Chess() {
		boolean isOPen = false;
		boolean isMine = false;
		int nearByMines = 0;
	}

	public boolean isOpen() {
		return isOpen;
	}

	public void setOpen(boolean isOpen) {
		this.isOpen = isOpen;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	public int getNearByMines() {
		return nearByMines;
	}

	public void setNearByMines(int nearByMines) {
		this.nearByMines = nearByMines;
	}

	public void displayCheckerBoard(boolean gameover) {
		if (!gameover) {
			if (!isOpen)
				System.out.print("- ");
			else
				System.out.print(getNearByMines() + " ");
		}
		else
			if (!isMine)
				System.out.print(getNearByMines() + " ");
			else
				System.out.print("* ");
	}

}
