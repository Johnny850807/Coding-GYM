
public class Bank {
	private static final int DELAY = 100;
	private int money = 10000;
	private int outlay = 0;
	private int income = 10000;
	private boolean isBroke = false;
	
	public synchronized void deposit(User user, int depositeMoney) throws InterruptedException{
		if (!isBroke())
		{
			this.money += depositeMoney;
			income += depositeMoney;
			System.out.printf("User %s is depositting , Amount : %d ...%n" , Thread.currentThread().getName() , depositeMoney);
			Thread.sleep(DELAY);
		}
		
	}
	
	public synchronized int draw(User user, int requestMoney) throws InterruptedException {
		if (!isBroke())
		{
			int result  = this.money < requestMoney ? this.money : requestMoney;
			this.money -= result;
			outlay += result;
			System.out.printf("User %s is drawing , Amount : %d ... , Get : %d %n" , Thread.currentThread().getName() , requestMoney , result);
			Thread.sleep(DELAY);
			return result; 
		}
		
		return 0;
	}
	
	public  boolean isBroke(){
		return this.money <= 0; 
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
