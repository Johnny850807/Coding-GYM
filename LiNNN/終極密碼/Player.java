package �׷��K�X;

import java.util.Scanner;

public abstract class Player {
	
	private String playerName;
	
	Scanner input = new Scanner(System.in);
	
	public Player() {
		System.out.println("�п�J���a�W��: ");
		setPlayerName(input.nextLine());
	}

	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = playerName;
	}
	
	public abstract int guessNumber(int small, int big);
	
}
