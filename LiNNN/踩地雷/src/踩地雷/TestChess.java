package ��a�p;

import java.util.Scanner;

public class TestChess {

	public static void main(String[] args) {
		int size, mineAmount;
		
		Scanner input = new Scanner(System.in);
		System.out.print("�п�J�a�Ϥj�p: ");
		size = input.nextInt();
		System.out.print("�п�J�a�p�ƶq(1 ~ " + (size * size) + " ): ");
		mineAmount = input.nextInt();
		Game game = new Game(size, mineAmount);
		game.startGame();

		
	}
}
