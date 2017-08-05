package �d�P�԰��C��;

import Card.*;
import Player.*;

public class Game {
	private Player[] players = new Player[2];
	
	public Game(int selection) {
		createPlayer(selection);
	}

	public void createPlayer(int humanPlayerAmount) {
		players[0] = new HumanPlayer();
		if (humanPlayerAmount == 2) 
			players[1] = new HumanPlayer();
		else 
			players[1] = new AIPlayer();
	}
	
	public void startGame() {
		int[] selection = new int[2];
		int[] score = new int[2];
		for (int i = 0; i < 7; i++) {
			System.out.println("��" + (i + 1) + "�^�X�}�l!!");
			selection = takeThreeCardsSelectOne();
			score = compareCard(selection);
			whoWin(score);
			calculateScore(score);
			removeCard();
		}
		System.out.println("�C������!!!");
		displayResult();
	}
	
	public int[] takeThreeCardsSelectOne() {
		int[] selection = new int[2]; 
		for (int i = 0; i < 2; i++) {
			System.out.print(players[i].getName() + " �п�ܡG ");
			players[i].getCardDeck().take3Cards();
			System.out.println();
			selection[i] = players[i].selectCard();
		}
		return selection;
	}
		
	public int[] compareCard(int[] selection) {
		int[] score = new int[2];
		Card[] card = new Card[2];
		for (int i = 0; i < 2; i++) 
			card[i] = players[i].getCardDeck().getCards().get(selection[i]);
		score[0] = card[0].isWin(card[1])?1:0;
		score[1] = card[1].isWin(card[0])?1:0;
		return score;
	}
	
	public void whoWin(int[] score) {
		if (score[0] > score[1]) 
			System.out.println(players[0].getName() + " Ĺ");
		else if (score[1] > score[0]) 
			System.out.println(players[1].getName() + " Ĺ");
		else
			System.out.println("����");
	}
	
	public void calculateScore(int[] score) {
		for (int i = 0; i < 2; i++)
			players[i].computeScore(score[i]);
	}
	
	public void removeCard() {
		for (Player p : players)
			p.getCardDeck().removeCard();
	}
	
	public void displayResult() {
		int[] score = new int[2];
		for (int i = 0; i < 2; i++) 
			score[i] = players[i].getScore();
		whoWin(score);
	}
	
}
