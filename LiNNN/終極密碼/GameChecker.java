package ²×·¥±K½X;

public class GameChecker {
	AnswerOfGame answerOfGame = new AnswerOfGame();
	int answer = answerOfGame.getAnswerOfGame();
	int small = 1, big = 100;
	
	public void checkAnswer(int guessNumber) {
		if ( guessNumber < answer ) {
			small = guessNumber;
			System.out.println(small + " ~ " + "big");
		}
		if ( guessNumber > answer ) {
			big = guessNumber;
			System.out.println(small + " ~ " + "big");
		}
		else
			System.out.println("Bingo!!");
		
	}
	
}
