import Exception.ChoiceDuplicatedException;

public class Board {
	public static final int SIZE = 9;

	private Block[] blocks;

	public Board() {
		blocks = new Block[SIZE];
		for (int j = 0; j < SIZE; j++)
			blocks[j] = new Block();
	}

	public void displayBoard() {
		int k = 1;
		for (int j = 0; j < SIZE; j++) {
			blocks[j].displayBlock(k);
			if (k % 3 == 0) {
				System.out.println();
				System.out.println();
			}
			k++;
		}
	}

	public void confPosition(int choice, boolean graph) throws ChoiceDuplicatedException {
		if (blocks[choice - 1].isChoose() == true)
			throw new ChoiceDuplicatedException();
		blocks[choice - 1].setChoose(true);
		blocks[choice - 1].setCircle(graph);
	}

	public boolean gameWinner() { //超鳥演算法，可以不用看了
		boolean win = false;
		for (int i = 0; i < 3; i++) {
			if (blocks[i % 9].isCircle() && blocks[(i + 3) % 9].isCircle() && blocks[(i + 6) % 9].isCircle())
				win = true;
			else if ((blocks[i % 9].isChoose() && !blocks[i % 9].isCircle())
					&& (blocks[(i + 3) % 9].isChoose() && !blocks[(i + 3) % 9].isCircle())
					&& (blocks[(i + 6) % 9].isChoose() && !blocks[(i + 6) % 9].isCircle()))
				win = true;
		}

		for (int i = 0; i < 3; i++) {
			if (blocks[i % 9].isCircle() && blocks[(i + 1) % 9].isCircle() && blocks[(i + 2) % 9].isCircle())
				win = true;
			else if ((blocks[i % 9].isChoose() && !blocks[i % 9].isCircle())
					&& (blocks[(i + 1) % 9].isChoose() && !blocks[(i + 1) % 9].isCircle())
					&& (blocks[(i + 2) % 9].isChoose() && !blocks[(i + 2) % 9].isCircle()))
				win = true;
		}

		if (blocks[0].isCircle() && blocks[4].isCircle() && blocks[8].isCircle())
			win = true;
		else if ( (blocks[0].isChoose() && !blocks[0].isCircle() )
				&& ( blocks[4].isChoose() && !blocks[4].isCircle() )
				&& (blocks[8].isChoose() && !blocks[8].isCircle() ) )
			win = true;
		else if (blocks[2].isCircle() && blocks[4].isCircle() && blocks[6].isCircle())
			win = true;
		else if ( (blocks[2].isChoose() && !blocks[2].isCircle() )
				&& ( blocks[4].isChoose() && !blocks[4].isCircle() )
				&& (blocks[6].isChoose() && !blocks[6].isCircle() ) )
			win = true;
		return win;
	}

	public boolean draw() {
		boolean draw = false;
		int count = 0;
		for (int i = 0; i < 9; i++) {
			if (blocks[i].isChoose())
				count++;
		}
		if (count == 9)
			draw = true;
		return draw;
	}

}
