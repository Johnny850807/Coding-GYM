package °é°é¤e¤e;

public class Board {
	private Block[][] blocks = new Block[3][3];
	private Line[] lines = new Line[8];
	private char winnerSymbol;
	
	public Board() {
		super();
		createNineBlocks();
		createEightLines();
	}

	public Block[][] getBlocks() {
		return blocks;
	}

	public char getWinnerSymbol() {
		return winnerSymbol;
	}
	
	public void createNineBlocks() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				blocks[i][j] = new Block();
				blocks[i][j].setSymbol((char)(i * 3 + j + 1 + 48));
			}
		}
	}
	
	public void createEightLines() {
		int lineSite = -1;
		for (int i = 0; i < 8; i++) 
			lines[i] = new Line();
		for (int i = 0; i < 3; i++) {
			lines[++lineSite].createThreeBlocks(blocks[i][0], blocks[i][1], blocks[i][2]);
			lines[++lineSite].createThreeBlocks(blocks[0][i], blocks[1][i], blocks[2][i]);
		}
		lines[++lineSite].createThreeBlocks(blocks[0][0], blocks[1][1], blocks[2][2]);
		lines[++lineSite].createThreeBlocks(blocks[0][2], blocks[1][1], blocks[2][0]);
	}
	
	public boolean judgeWinOrNot() {
		for (int i = 0; i < 8; i++)
			if (lines[i].asLine()) {
				winnerSymbol = lines[i].getWinnerSymbol();
				return true;
			}
		return false;
	}
	
	public void blockSelected(int number, char symbol) {
		int row = (number - 1) / 3;
		int col = (number - 1) % 3;
		blocks[row][col].setSymbol(symbol);
	}
	
	public void display() {
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) 
				System.out.print(" " + blocks[i][j].getSymbol() + " ");
			System.out.println();
		}
	}
}
