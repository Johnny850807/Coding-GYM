package �d�P�԰��C��;

import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		System.out.println("��ܹ�ܡG(1)AI���a (2)�u�ꪱ�a");
		int selection = input.nextInt();
		Game game = new Game(selection);
		game.startGame();
	}

}
