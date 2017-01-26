package ¼³§JµP21ÂI¥Ü½d;

import java.util.Scanner;

public class HumanInputChoice implements ChoiceStrategy {

	@Override
	public boolean makeChoiceToReceiveNextCardOrNot(Player player) {
		Scanner inputYesOrNot = new Scanner(System.in);
		String choice = "";
		do{
			choice = inputYesOrNot.nextLine();
		} while( choice.length() == 0);
		
		return choice.charAt(0) == 'y' || choice.charAt(0) == 'Y';
	}

}
