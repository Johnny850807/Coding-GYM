package BlackJack;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.Scanner;
import java.util.zip.ZipEntry;

public class BlackJack {
	Scanner input = new Scanner(System.in);

	PokerCard pokerCard = new PokerCard();
	ArrayList<Player> players = new ArrayList<>();

	public BlackJack(int realPlayerAmount, int AI_PlayerAmount) {
		for (int i = 0; i < realPlayerAmount; i++)
			players.add(new RealPlayer());
		for (int i = 0; i < AI_PlayerAmount; i++) {
			AI ai = new AI();
			players.add(ai);
		}
		playerOrder();
	}

	public void playerOrder() {
		for (int time = 0; time < 10; time++)
			for (int i = 0; i < players.size(); i++) {
				int index = (int) (Math.random() * players.size());
				Player temp = players.get(i);
				players.set(i, players.get(index));
				players.set(index, temp);
			}
		System.out.println();
		for (Player p : players)
			System.out.print(p.getName() + " -> ");
		System.out.println();
	}

	public void showResult() {

		Collections.sort(players, new Comparator<Player>() {

			public int compare(Player p1, Player p2) {
				if (p1.getScore() > p2.getScore())
					return -1;
				if (p1.getScore() < p2.getScore())
					return 1;
				return 0;
			}
		});
		for (Player p : players)
			System.out.println(p.getName());

	}

	public void startGame() throws InterruptedException {
		for (int round = 1; round < 4; round++) {
			int max = 0;
			int position = 0;
			System.out.println();
			System.out.println("��" + round + "�^�X");
			for (Player player : players) {
				boolean oneMore = false;
				int point = 0;
				System.out.println("---------------");
				System.out.println("���� " + player.getName() + " ���^�X");
				do {
					if (pokerCard.pokerCards.isEmpty()) {
						System.out.println("�P����F�A�~�P��");
						pokerCard = new PokerCard();
					}
					System.out.println("��P!! " + pokerCard.toString());
					point += pokerCard.drawCard();
					if (point > 21) {
						System.out.println("BOMB!");
						point = 0;
						break;
					}
					System.out.println("����:" + point);
					System.out.println("�A�@�i? Y/N");
					oneMore = player.choice(point);
					System.out.println();
				} while (oneMore);
				if (point > max) {
					max = point;
					position = players.indexOf(player);
				}

			}
			players.get(position).setScore(1);
			System.out.println("<< " + players.get(position).getName() + " >> Ĺ�o�o�^�X�ӧQ");

		}
		System.out.println();
		System.out.println("�ƦW(��->�C):");
		showResult();

	}

}
