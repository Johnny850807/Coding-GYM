import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String again;

		do {
			Game game = new Game();
			game.confGame();

			System.out.println("是否要再來一場?(y/n):");
			again = input.next();
		} while (again.equals("Y") || again.equals("y"));
	}

}
