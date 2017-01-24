package game;

import java.util.Random;

public class guessNumber {
	private static guessNumber instance;  //共同享受 
	private int MaxRange;
	private int MinRange;
	private int Answer;
	private boolean bgo = false; 
	private guessNumber(int maxRange){
		MaxRange = maxRange;
		MinRange = 1;
		createRandomAnswer();
	}
	public void createRandomAnswer(){
		Answer = new Random().nextInt(100)+1;
		System.out.println("答案是 : " + Answer);
	}
	public static guessNumber getInstance(){  //水哥教的
		if ( instance == null )
			instance = new guessNumber(100);
		return instance;
	}
	public boolean checkGuess(AI guessingPlayer){
		System.out.println("範圍 : " + MinRange + " ~ " + MaxRange);
		if (MaxRange - MinRange == 1)
			return true;
		int guess = guessingPlayer.guessNumber(MinRange , MaxRange);
		if ( guess == Answer ){
			System.out.println(guessingPlayer.getName() + " 猜中了 !! "+ "答案是 " + Answer + "!!" );
			return true;
		}	
		else if ( guess < Answer )
			MinRange = guess;
		else
			MaxRange = guess;
		return false;
		
	}
	
}
