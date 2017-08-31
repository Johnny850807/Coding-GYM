package Bank;

public class BankAccount {
	private int balance = 10000;
	private int drawMoney = 0;
	private int depositMoney = 0;

	public synchronized void deposit(int money) throws InterruptedException {
		if (hasBalance())
			System.out.print("");

		else {
			Thread.sleep(1000);
			balance += money;
			depositMoney += money;
			System.out.println("User " + Thread.currentThread().getName() + " is depositting, Amount: " + money);
		}
	}

	public synchronized void draw(int money) throws InterruptedException {
		if (getBalance() > money) {
			Thread.sleep(1000);
			balance -= money;
			drawMoney += money;
			System.out.println("User " + Thread.currentThread().getName() + " is drawing, Amount: " + money
					+ "..., Get: " + money);
		}

		else if (hasBalance())
			System.out.print("");

		else {
			money = getBalance();
			balance -= money;
			drawMoney += money;
			System.out.println("User " + Thread.currentThread().getName() + " is drawing, Amount: " + money
					+ "..., Get: " + money);
			checkImEx();
		}
	}

	public boolean hasBalance() {
		if (getBalance() == 0)
			return true;
		return false;
	}

	private void checkImEx() {
		if (10000 + depositMoney == drawMoney)
			System.out.println("結論: 總和 " + (10000 + depositMoney) + " - " + drawMoney + " = 0");
	}

	public int getBalance() {
		return balance;
	}

}
