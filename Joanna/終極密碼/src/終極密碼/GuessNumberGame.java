package ²×·¥±K½X;

import java.util.ArrayList;
import java.util.Random;

public class GuessNumberGame {
	int lowerBound;
	int upperBound;
	int answer;
	
	public GuessNumberGame() {
		super();
		this.lowerBound = 0;
		this.upperBound = 100;
		Random ran = new Random();
		answer = (int) ran.nextInt(99) + 1;
	}

	public GuessNumberGame(int lowerBound, int upperBound) {
		super();
		this.lowerBound = lowerBound;
		this.upperBound = upperBound;
		Random ran = new Random();
		answer = (int) ran.nextInt(99) + 1;
	}

	public boolean startGame(ArrayList<Player> players) {
		for (Player p : players) {
			System.out.println(lowerBound + "~" + upperBound);
			System.out.print(p.getName() + "²q");
			int playerAnswer = p.generateNumber(lowerBound, upperBound);
			System.out.println(playerAnswer);
			if (playerAnswer < answer) 
				lowerBound = playerAnswer;
			else if (playerAnswer > answer) 
				upperBound = playerAnswer;
			else {
				System.out.println("²q¤¤¤F!!!");
				return true;
			}
		}
		return false;
	}
}