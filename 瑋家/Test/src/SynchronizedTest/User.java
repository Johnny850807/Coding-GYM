package SynchronizedTest;
import java.util.Random;

public class User implements Runnable{
	
	public String userName;
	static private Account account;
	private int money;
	private int userNo;
	public static int userNoPool = 0;
	
	public User(Account account) {
		this.account = account;
		this.userNo = userNoPool;
		this.userName = "User" + userNoPool++;
		this.money = 3000;
	}
	
	@Override
	public void run() {
		Thread.currentThread().setName(userName);
		System.out.println(Thread.currentThread().getName());
		
		try {
			account.getBank().DoTransactions(this);
			Thread.sleep(500000);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public Account getAccount() {
		return account;
	}

	public void setAccount(Account account) {
		this.account = account;
	}

	public int getMoney() {
		return money;
	}

	public void setMoney(int money) {
		this.money = money;
	}
	
	
	
}
