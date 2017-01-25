package game;

import java.util.Random;

public class guessNumber {
	private static guessNumber instance;  //�@�P�ɨ� 
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
		System.out.println("���׬O : " + Answer);
	}
	public static guessNumber getInstance(){  //�����Ъ�
		if ( instance == null )
			instance = new guessNumber(100);
		return instance;
	}
	public boolean checkGuess(AI guessingPlayer){
		System.out.println("�d�� : " + MinRange + " ~ " + MaxRange);
		if (MaxRange - MinRange == 1)
			return true;
		int guess = guessingPlayer.guessNumber(MinRange , MaxRange);
		if ( guess == Answer ){
			System.out.println(guessingPlayer.getName() + " �q���F !! "+ "���׬O " + Answer + "!!" );
			return true;
		}	
		else if ( guess < Answer )
			MinRange = guess;
		else
			MaxRange = guess;
		return false;
		
	}
	
}
