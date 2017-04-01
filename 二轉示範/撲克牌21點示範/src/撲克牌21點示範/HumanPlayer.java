package 撲克牌21點示範;

import java.util.Scanner;

public class HumanPlayer extends Player {

	public HumanPlayer() {
		super(new HumanInputChoice());
	}

	@Override
	public void createName() {
		Scanner scanner = new Scanner(System.in);
		do{
			System.out.println("請輸入玩家"+playerAmount+"姓名: ");
			name = scanner.nextLine();
		}while(name.length() == 0);
		
	}

}
