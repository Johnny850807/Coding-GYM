package ²×·¥±K½X¦hAI;

import java.util.Random;

public class GuessGame {
	private int min = 0;
	private int max = 100;
	private int answer;
	
	public GuessGame(){}
	
	public void createAnswer(){
		answer = new Random().nextInt(101);
	}
	
	public boolean guess(int number){
		if (answer == number)
		{
			min = max = answer;
			return true;
		}
	
		if (answer > number)
			min = number;
		else if (answer < number)
			max = number;
		
		return false;
	}
	
	public boolean isOver(){
		return min == max;
	}

	public int getMin() {
		return min;
	}

	public int getMax() {
		return max;
	}
	
	
}	
