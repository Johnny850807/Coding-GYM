package 圈圈叉叉;

import java.util.Scanner;

public class HumanPlayer extends Player {

	@Override
	public int chooseBlockNumber(Board board) {
		Scanner input = new Scanner(System.in);
		int number = input.nextInt();
		return number;
	}

	@Override
	protected String nameSelf() {
		Scanner input = new Scanner(System.in);
		System.out.println("請輸入名子:");
		String name = input.next();
		return name;
	}

}
