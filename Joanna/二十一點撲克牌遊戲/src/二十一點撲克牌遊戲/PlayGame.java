package �G�Q�@�I���J�P�C��;

import java.util.Scanner;

public class PlayGame {

	public static void main(String[] args) {
		int humanAmount;
		int AIAmount;
		Scanner input = new Scanner(System.in);
		System.out.println("�]�m���a�ƶq(0~10):");
		humanAmount = input.nextInt();
		System.out.println("�]�m�q���ƶq(1~" + (10-humanAmount) + "):");
		AIAmount = input.nextInt();
		
		BlackJack game = new BlackJack(humanAmount, AIAmount);
		game.playGame();
		
	}

}
