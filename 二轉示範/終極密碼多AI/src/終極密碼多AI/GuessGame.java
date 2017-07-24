package 終極密碼多AI;

import java.util.Random;

public class GuessGame {
	private static GuessGame instance;
	private int maxBound;
	private int minBound;
	private int answer;
	private boolean isOver = false;  //猜中者出現沒
	
	private GuessGame(int maxBound){
		this.maxBound = maxBound;
		minBound = 1;
		createRandomAnswer();
	}
	
	public void createRandomAnswer(){
		answer = new Random().nextInt(maxBound)+1;
	}
	
	public static GuessGame getInstance(){
		// singleton
		if ( instance == null )
			instance = new GuessGame(100);
		return instance;
	}
	
	public boolean doGuessingAction(Player guessingPlayer){
		int guess = guessingPlayer.doGuessingAction();
		System.out.println(guessingPlayer.getGuessMessage(guess));
		if ( guess >= minBound && guess <= maxBound )
		{
			
			if ( guess == answer )
			{
				System.out.println(guessingPlayer.getName() + " 猜中了 !! "
						+ "答案是 " + answer + "!!" );
				isOver = true;
			}
			else if ( guess < answer )
				
				minBound = guess+1;
			else
				maxBound = guess-1;
			return true;
		}
		else
			return false;
	}
	public String getStateMessage(){
		return String.format("範圍 %d ~ %d%n", minBound , maxBound);
	}
	
	public boolean isOver(){
		return isOver;
	}
	public int getMaxBound() {
		return maxBound;
	}
	public int getMinBound() {
		return minBound;
	}
	
}
