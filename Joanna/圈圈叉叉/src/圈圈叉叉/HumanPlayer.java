package ���e�e;

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
		System.out.println("�п�J�W�l:");
		String name = input.next();
		return name;
	}

}
