package °é°é¤e¤e;

import java.util.Random;

public class AIPlayer extends Player {

	@Override
	public int chooseBlockNumber(Board board) {
		Random ran = new Random();
		Block[][] blocks = board.getBlocks();
		int number, row, col;
		do {
			number = (int)ran.nextInt(9) + 1;
			row = (number - 1) / 3;
			col = (number - 1) % 3;
		} while (blocks[row][col].wasSelected());
		System.out.println(number);
		return number;
	}

	@Override
	protected String nameSelf() {
		String name = "AI";
		return name;
	}

}
