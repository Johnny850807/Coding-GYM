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
			System.out.println("請輸入玩家"+playerAmount+"姓名: ");
			name = scanner.nextLine();
		}while(name.isEmpty());  //防呆
		
		return name;
	}

}
