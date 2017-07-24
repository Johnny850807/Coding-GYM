package �׷��K�X;

import java.util.Scanner;

public abstract class Player {
	
	Scanner input = new Scanner(System.in);
	protected String playerName;
	private String[] aiPlayerName = {"Sam", "Ball", "Book�PShiuan", "���h��", "��+��", "�����y", "�U�}��", "�j����", "�i���P", "�p�ʧb<3"};
	private final int index = (int) (Math.random() * aiPlayerName.length);
	

	public Player() {
		this.setPlayerName(playerName);
	}
	
	public String getPlayerName() {
		return playerName;
	}

	public void setPlayerName(String playerName) {
		this.playerName = aiPlayerName[index];
	}
	
	public abstract int guessNumber(int small, int big);
	
	public abstract String getPlayerType();
	
}
