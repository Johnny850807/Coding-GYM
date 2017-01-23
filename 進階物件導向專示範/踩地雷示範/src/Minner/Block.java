package Minner;

public class Block implements MinnerItem {

	private int numOfMines = 0; // 周遭地雷數量
	private boolean isOpened = false;  //格子是否開啟
	private boolean isMine = false;  //是否是地雷
	
	@Override
	public void print() {
		// 印出格子內所有資訊
		if (isOpened)  //若打開
		{  
			if (isMine)  //是地雷
				System.out.print('*');
			else
				System.out.print(numOfMines);
		}
		else
			System.out.print('-');
	}

	
	public int getNumOfMines() {
		return numOfMines;
	}

	public void setNumOfMines(int numOfMines) {
		this.numOfMines = numOfMines;
	}

	public boolean isOpened() {
		return isOpened;
	}

	public void setOpened(boolean isOpened) {
		this.isOpened = isOpened;
	}

	public boolean isMine() {
		return isMine;
	}

	public void setMine(boolean isMine) {
		this.isMine = isMine;
	}

	
}
