package ²×·¥±K½X;

import java.util.Random;

public class AI extends Player {
	
	public String nameSelf() {
		name = "©_¼Æ°¸¼ÆAI";
		return name;
	}
	
	@Override
	public int generateNumber(int lowerBound, int upperBound) {
		Random ran = new Random();
		int range = upperBound - lowerBound;
		answer = (int) (ran.nextInt(range - 1) + 1) + lowerBound;
		return answer;
	}

}
