package ²×·¥±K½X;

public class GameChecker {
	
	private int small = 1, big = 100;
	private boolean bingo = false;
	
	public void checkAnswer(int answer, int guessNumber) {
		
		if ( guessNumber < answer ) {
			setSmall(guessNumber);
			System.out.println();
		}
		else if ( guessNumber > answer ) {
			setBig(guessNumber);
			System.out.println();
		}
		else {
			System.out.println();
			System.out.println("Bingo");
			bingo = true;
		}
		
	}

	public int getSmall() {
		return small;
	}

	public void setSmall(int small) {
		this.small = small;
	}

	public int getBig() {
		return big;
	}

	public void setBig(int big) {
		this.big = big;
	}
	
	public boolean getBingo() {
		return bingo;
	}
}
