import java.util.ArrayList;
import java.util.Scanner;

import Exception.ChoiceDuplicatedException;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String again;

		do {
			Game game = new Game();
			game.confGame();

			System.out.println("�O�_�n�A�Ӥ@��?(y/n):");
			again = input.next();
		} while (again.equals("Y") || again.equals("y"));
	}

}
