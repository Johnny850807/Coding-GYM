package Player;

import java.util.Scanner;

import Strategy.HumanInputChoice;

public class HumanPlayer extends Player {

	public HumanPlayer() {
		super(new HumanInputChoice());
	}

	@Override
	public String createName() {
		Scanner scanner = new Scanner(System.in);
		String name = "";
		do{
			System.out.println("�п�J���a"+playerAmount+"�m�W: ");
			name = scanner.nextLine();
		}while(name.isEmpty());  //���b
		
		return name;
	}

}
