package 二十一點撲克牌遊戲;

import java.util.Scanner;

public class Human extends Player {

	@Override
	protected String nameSelf() {
		Scanner input = new Scanner(System.in);
		name = input.next();
		return name;
	}

	@Override
	protected boolean needCard(int score) {
		Scanner input = new Scanner(System.in);
		String again = input.next();
		if (again.equals("n") || again.equals("N"))
			return false;
		else
			return true;
	}

	
}
