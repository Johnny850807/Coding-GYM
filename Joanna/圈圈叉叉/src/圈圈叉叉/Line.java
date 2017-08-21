package °é°é¤e¤e;

public class Line {
	private Block[] blocks = new Block[3];
	private char winnerSymbol;
	
	public char getWinnerSymbol() {
		return winnerSymbol;
	}

	public void createThreeBlocks(Block block1, Block block2, Block block3) {
		blocks[0] = block1;
		blocks[1] = block2;
		blocks[2] = block3;
	}
	
	public boolean asLine() {
		if (blocks[0].getSymbol() == blocks[1].getSymbol() && blocks[1].getSymbol() == blocks[2].getSymbol()) {
			winnerSymbol = blocks[0].getSymbol();
			return true;
		}
		else
			return false;
	}
	
}
