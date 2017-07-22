package ²×·¥±K½X;

import java.util.Random;

public class EvenAI extends AI {
	
	@Override
	public int generateNumber(int lowerBound, int upperBound) {
		Random ran = new Random();
		int range = upperBound - lowerBound;
		if (lowerBound % 2 == 1)
			answer = (int) (ran.nextInt(range / 2) * 2 + 1) + lowerBound;
		else 
			answer = (int) ran.nextInt(range / 2) * 2 + lowerBound;
		return answer;
	}
	
}
