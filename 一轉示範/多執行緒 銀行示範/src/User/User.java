package User;
import java.util.Random;
import java.util.concurrent.TimeUnit;

import Bank.Bank;
import Bank.BankNoMoneyException;


public class User implements Runnable{
	private static Random random = new Random();
	private static final String[] NAMES = {"Binzhong","ZongYee","Max","ShengSheng","Fongshu","Waterball","Fireball","ShengFong","WangNing","Fucker"};
	private String name;
	private static int nameIndex = 0;
	private int money = 3000;
	private Bank bank;
	
	public User(Bank bank){
		this.bank = bank;
	}
	
	@Override
	public void run() {
		try{
			if (name == null)
				Thread.currentThread().setName(NAMES[++nameIndex % NAMES.length]);
			doTransactions();
		}catch (BankNoMoneyException e) {
			// 如果銀行沒錢了，例外就會丟出並強制結束使用者的行為。
		}catch(Exception err){
			err.printStackTrace();
		}
	}
	
	private void doTransactions() throws Exception{
		while (!bank.isBroke()) 
		{
			if (random.nextBoolean() && money != 0 )
				deposit(random.nextInt(money) + 1);
			else
				draw(random.nextInt(3800) + 100);
		}
	}

	private void deposit(int amount) throws Exception{
		bank.deposite(this, amount);
		money -= amount;
	}
	
	private void draw(int amount) throws Exception{
		int result = bank.draw(this, amount);
		money += result;
	}

}
