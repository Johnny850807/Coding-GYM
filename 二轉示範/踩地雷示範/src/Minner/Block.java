package Minner;

public class Block implements MinnerItem {

	private int numOfMines = 0; // �P�D�a�p�ƶq
	private boolean isOpened = false;  //��l�O�_�}��
	private boolean isMine = false;  //�O�_�O�a�p
	
	@Override
	public void print() {
		// �L�X��l���Ҧ���T
		if (isOpened)  //�Y���}
		{  
			if (isMine)  //�O�a�p
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
