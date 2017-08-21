import java.util.ArrayList;
import java.util.Scanner;

import Exception.BlockHasBeenChosenException;


public class Game {
	Scanner input = new Scanner(System.in);
	private Board board = new Board();
	private ArrayList<Player> players = new ArrayList<>();
	private boolean gameover;

	public Game() {
		super();
		gameover = false;
	}

	public void confGame() {

		createPlayer();
		players.get(0).setGroup(Group.CIRCLE);
		createPlayer();
		players.get(1).setGroup(Group.CROSS);

		showBoard();
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

	public void createPlayer() {
		System.out.println("請輸入玩家類型: (1)玩家 (2)電腦");
		int player = input.nextInt();
		players.add((player == 1) ? new RealPlayer() : new AI());
	}

	public void showBoard() {
		String[] B = board.toString().split(",");

		for (int i = 1; i < 10; i++) {
			System.out.print(B[i - 1] + "    ");
			if (i % 3 == 0)
				System.out.print("\n\n");
		}
	}

	public void playerChoose(int index) {
		while (true) {
			try {
				int choice = players.get(index).choice();
				board.confPosition(choice, players.get(index).getGroup());
				System.out.println(players.get(index).getName() + " 選擇了 " + choice);
				showBoard();
				judge(index);

				break;
			} catch (BlockHasBeenChosenException e) {
				System.out.println();
			}
		}
	}

	public void judge(int index) {
		switch (board.gameJudge()) {
		case 1:
			System.out.println(players.get(index).getName() + "獲勝");
			gameover = true;
			break;
		case 2:
			System.out.println("沒有人獲勝");
			gameover = true;
			break;
		}
	}

}
