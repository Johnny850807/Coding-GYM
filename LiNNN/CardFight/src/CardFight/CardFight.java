package CardFight;

import java.util.ArrayList;
import java.util.Scanner;

import CardStack.Card;

public class CardFight {

	Scanner input = new Scanner(System.in);
	ArrayList<Player> players = new ArrayList<>();
	private int round;

	void startGame() {
		createPlayer();

		for (round = 1; round <= 7; round++) {
			System.out.println("------------------------------------");
			System.out.println("Round: " + round);

			Card card1 = players.get(0).fight();
			Card card2 = players.get(1).fight();

			if (judge(card1, card2) == 2)
				System.out.println("平手");
			else
				players.get(judge(card1, card2)).setVictory(true);

			players.get(0).handCards.clear();
			players.get(1).handCards.clear();
		}
		System.out.println("ˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇˇ");
		winner(players.get(0), players.get(1));
	}

	private int judge(Card card1, Card card2) {
		if (card1.winOrNot(card2))
			return 0;
		else if (card2.winOrNot(card1))
			return 1;
		else
			return 2;
	}

	private void winner(Player player1, Player player2) {
		player1.isFinalWinner(player2);
	}

	private void createPlayer() {
		for (int i = 0; i < 2; i++) {
			System.out.print("請輸入玩家類型: (1) 真實玩家  (2) AI : ");
			int player = input.nextInt();
			players.add((player == 1) ? new RealPlayer() : new AI());
		}
	}

}
