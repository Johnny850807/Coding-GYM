package »È¦æ;

import java.util.Random;

public class User extends Thread {
	private Bank bank = Bank.getInstance();
	private Random random = new Random();
	private int money;
	
	public User() {
		money = 3000;
	}

	public int getMoney() {
		return money;
	}
	
	@Override
	public void run() {
		while (bank.hasBlance()) {
			depositOrDraw();
		}
	}

	public void depositOrDraw() {
		int randomNumber = random.nextInt(3);
		switch (randomNumber) {
		case 0:
			if (getMoney() != 0)
				deposit();
			break;
		case 1:
			draw();
		default:
			break;
		}		
	}
	
	public void deposit() {
		int randomMoney = random.nextInt(getMoney()) + 1;
		money -= randomMoney;
		bank.deposit(randomMoney);
	}
	
	public void draw() {
		int randomMoney = random.nextInt(3000);
		bank.draw(randomMoney);
	}
	
}
