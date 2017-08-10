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
			System.out.println("請輸入玩家 " + (i + 1) + " 類型: (1)玩家 (2)電腦");
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
				System.out.println(players.get(index).getName() + " 選擇了 " + choice);
				System.out.println();
				board.displayBoard();
				
				if (board.gameWinner()) {
					System.out.println(players.get(index).getName() + " 獲勝!!");
					gameover = true;
				} else if (board.draw()) {
					System.out.println("沒有玩家獲勝");
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
