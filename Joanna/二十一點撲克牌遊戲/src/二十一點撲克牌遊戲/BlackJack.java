package �G�Q�@�I���J�P�C��;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

public class BlackJack {
	ArrayList<Player> players = new ArrayList<Player>();
	ArrayList<Player> playersRanking = new ArrayList<Player>();
	
	public BlackJack(int humanAmount, int AIAmount) {
		super();
		for (int i=0; i<humanAmount; i++) {
			System.out.println("��J��" + (i+1) + "�쪱�a�W��");
			Human h = new Human();
			players.add(h);
		}
		
		for (int i=0; i<AIAmount; i++) {
			AI a = new AI();
			players.add(a);
		}
		
		playersRanking.addAll(players);
	}

	public void decideOrder() {
		for (int i=0; i<players.size(); i++) {
			Random ran = new Random();
			int temp = (int) ran.nextInt(players.size());
			Collections.swap(players, i, temp);
		}
		
	}
	
	public void displayPlayerOrder() {
		for (Player p : players) {
			System.out.println(p.getName());
		}
	}
	
	public void playGame() {
		CardGroup cardgroup = new CardGroup();
		decideOrder();
		for (int i = 1; i <= 3; i++) {
			System.out.println("��" + i + "�^�X�}�l!!");
			int maxSite = 0;
			int maxScore = 0;
			for (Player p : players) {
				System.out.println("���� " + p.getName() + " �F !!");
				boolean again;
				int score = 0;
				do {
					if (cardgroup.cards.isEmpty()) {
						cardgroup = new CardGroup(); 
					}
					System.out.print("½�}�F .... ");
					score += cardgroup.gainOneCard();
					System.out.println();
					if (score > 21) {
						score = 0;
						break;
					}
					System.out.println("�а� " + p.getName() + " �n½�}�U�@�i�P��(y/n)?");
					again = p.needCard(score);
				} while(again);
				if (score > maxScore) {
					maxScore = score;
					maxSite = players.indexOf(p);
				}
				p.computeScore(score);
				System.out.println(p.getName() + " �o��F .. " + score + "��");
			}
			players.get(maxSite).computeScore(1);
			System.out.println("���^�X�� " + players.get(maxSite).getName() + " �o��@�� !!");
			sort();
			System.out.println();
		}

		System.out.println("�C������!!!!!!");
		System.out.println();
		
		displayRanking();
	}
	
	public void sort() {
		Collections.sort(playersRanking, new Comparator<Player>(){
			 @Override
			 public int compare(Player p1, Player p2) {
			  return p2.getScore() - p1.getScore();
			 }   
			});
	}
	
	public void displayRanking() {
		for (int i = 0; i < playersRanking.size(); i++) {
			System.out.println("��" + (i + 1) + "�W --" + playersRanking.get(i).getName());
		}
	}
	
}
