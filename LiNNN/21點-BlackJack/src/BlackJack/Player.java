package BlackJack;

import java.util.Scanner;

public abstract class Player {
	Scanner input = new Scanner(System.in);
	protected String name;
	private int score;

	
	public Player() {
		super();
		this.name = named();
		score = 0;
	}
	
	
	public int getScore() {
		return score;
	}


	public void setScore(int score) {
		this.score += score;
	}


	public abstract String named();
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	public abstract boolean choice(int point) throws InterruptedException;

}
