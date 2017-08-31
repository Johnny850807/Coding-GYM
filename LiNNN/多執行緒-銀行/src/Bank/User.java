package Bank;

import Exception.BalanceIsOverdraftException;

public class User implements Runnable {

	private BankAccount bankAccount;

	public User(BankAccount bankAccount) {
		this.bankAccount = bankAccount;
	}

	@Override
	public void run() {
		try {
			depositOrDraw();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}

	private void depositOrDraw() throws InterruptedException {
		int choice = (int) (Math.random() * 2);

		if (choice == 1) {
			int money = (int) (Math.random() * 3000 + 1);
			bankAccount.deposit(money);
		} else {
			int money = (int) (Math.random() * 2500 + 2000);

			if (money > bankAccount.getBalance())
				throw new BalanceIsOverdraftException();
			else
				bankAccount.draw(money);
		}

	}

}
