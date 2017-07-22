package ²×·¥±K½X;

import java.util.Scanner;

public class Human extends Player {

	@Override
	public int generateNumber(int lowerBound, int upperBound) {
		Scanner input = new Scanner(System.in);
		do {
			answer = input.nextInt();
		} while(answer < lowerBound || answer > upperBound);
		return answer;
	}

}
