package �G�Q�@�I���J�P�C��;

import java.util.Scanner;

public abstract class Player {
	protected String name;
	protected int score;
	
	public Player() {
		super();
		name = nameSelf();
		score = 0;
	}
	
	public String getName() {
		return name;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public int getScore() {
		return score;
	}
	
	public void setScore(int score) {
		this.score = score;
	}
	
	public void computeScore(int score) {
		this.score += score;
	}
	
	protected abstract String nameSelf();
	
	protected abstract boolean needCard(int score);
	
}
