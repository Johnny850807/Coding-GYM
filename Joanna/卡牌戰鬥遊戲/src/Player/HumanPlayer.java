package Player;

import java.util.Scanner;

public class HumanPlayer extends Player {
	
	@Override
	protected String nameSelf() {
		Scanner input = new Scanner(System.in);
		System.out.print("��J���a�W�١G");
		name = input.next();
		return name;
	}

	@Override
	public int selectCard() {
		Scanner input = new Scanner(System.in);
		int selection = input.nextInt();
		return selection;
	}
	
}
