import java.util.ArrayList;
import java.util.Scanner;

import Exception.ChoiceDuplicatedException;

public class Game {
	Scanner input = new Scanner(System.in);
	Board board = new Board();
	ArrayList<Player> players = new ArrayList<>();
	private boolean gameover;

	public Game() {
		super();
		gameover = false;
	}

	public void confGame() {
		for (int i = 0; i < 2; i++) {
			System.out.println("�п�J���a " + (i + 1) + " ����: (1)���a (2)�q��");
			int player = input.nextInt();
			players.add((player == 1) ? new RealPlayer() : new AI());

			players.get(i).setGraph(i);
		}

		System.out.println();
		board.displayBoard();

		startGame();
	}

	private void startGame() {
		while (!gameover) {
			int index = 0;
			playerChoose(index);
			if (gameover)
				break;
			index++;

			playerChoose(index);
		}
	}

	public void playerChoose(int index) {
		while (true) {
			try {
				int choice = players.get(index).Choice();
				board.confPosition(choice, players.get(index).getGraph());
				System.out.println(players.get(index).getName() + " ��ܤF " + choice);
				System.out.println();
				board.displayBoard();
				
				if (board.gameWinner()) {
					System.out.println(players.get(index).getName() + " ���!!");
					gameover = true;
				} else if (board.draw()) {
					System.out.println("�S�����a���");
					gameover = true;
					break;
				}
				break;
			} catch (ChoiceDuplicatedException e) {
				System.out.println();
			}
		}
	}

}
