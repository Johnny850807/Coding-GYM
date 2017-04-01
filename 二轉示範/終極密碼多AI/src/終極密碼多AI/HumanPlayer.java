package ²×·¥±K½X¦hAI;

import java.util.Scanner;

public class HumanPlayer extends Player{

	private Scanner scanner;

	public HumanPlayer(String name) {
		super(PlayerType.PLAYER, name);
	}

	@Override
	public int getGuessingNumber() {
		scanner = new Scanner(System.in);
		return scanner.nextInt();
	}

}
