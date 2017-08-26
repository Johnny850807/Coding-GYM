package Bank;

import User.User;

public class Bank {
	private static final int DELAY = 0;
	private int money = 10000;
	private int outlay = 0;
	private int income = 10000;
	private boolean isBroke = false;
	
	public enum Action {DEPOSITE, DRAW}
	
	public synchronized int action(User user, int money, Action action) throws InterruptedException{
		if (!isBroke())
			switch (action) 
			{
				case DEPOSITE:
					deposit(user,money);
					return this.money;
				default:
					return draw(user, money);
			}
		throw new BankNoMoneyException();
	}

	public synchronized void deposit(User user, int depositeMoney) throws InterruptedException {
		this.money += depositeMoney;
		income += depositeMoney;
		System.out.printf("User %s is depositting , Amount : %d ...%n", Thread.currentThread().getName(),
				depositeMoney);
		Thread.sleep(DELAY);
	}
	
	public synchronized int draw(User user, int requestMoney) throws InterruptedException {
		int result = this.money < requestMoney ? this.money : requestMoney;
		this.money -= result;
		outlay += result;
		isBroke = this.money <= 0;
		System.out.printf("User %s is drawing , Amount : %d ... , Get : %d %n", Thread.currentThread().getName(),
				requestMoney, result);
		Thread.sleep(DELAY);
		return result;
	}
	
	public  boolean isBroke(){
		return isBroke;
	}

	public int getOutlay() {
		return outlay;
	}

	public int getIncome() {
		return income;
	}

	public void setIncome(int income) {
		this.income = income;
	}
	
	public int getMoney() {
		return money;
	}
	
}
