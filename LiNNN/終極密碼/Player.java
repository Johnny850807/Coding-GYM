package 終極密碼;

import java.util.Scanner;

public abstract class Player {
	
	private String playerName;
	
	Scanner input = new Scanner(System.in);
	
	public Player() {
		System.out.println("請輸入玩家名稱: ");
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
