package ���J�P21�I�ܽd;

import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer() {
		super(new HumanInputChoice());
	}

	@Override
	public void createName() {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("�п�J���a"+playerAmount+"�m�W: ");
			name = scanner.nextLine();
		}while(name.length() == 0);
		
	}

}
