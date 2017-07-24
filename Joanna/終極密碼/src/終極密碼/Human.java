package ²×·¥±K½X;

import java.util.Scanner;

public class Human extends Player {
	
	public String nameSelf() {
		Scanner input = new Scanner(System.in);
		name = input.next();
		return name;
	}
	
	@Override
	public int generateNumber(int lowerBound, int upperBound) {
		Scanner input = new Scanner(System.in);
		do {
			answer = input.nextInt();
		} while(answer < lowerBound || answer > upperBound);
		return answer;
	}

}
