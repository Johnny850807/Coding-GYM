import java.util.Random;

public class User implements Runnable{
	
	public String name;
	private int money = 3000;
	public Bank bank;
	public Account account;
	static private int userIndex = 1;
	public Random random = new Random();
	
	public User(Bank bank) {
		this.bank = bank;
		this.setName("User" + (userIndex++));
	}
	
	@Override
    public void run(){
		try {
			DoTransactions();
		} catch (Exception e) {
			e.printStackTrace();
		}
    }
	
	//copy paste
	private void DoTransactions() throws Exception{
		while (!bank.IsBroke()){
			
			if (random.nextBoolean() && money != 0 ) {
				System.out.println(Thread.currentThread().getName() +"deposit");
				Deposit(random.nextInt(money) + 1);
			}
			else {
//				System.out.println(name+"withdraw");
				Withdraw(random.nextInt(3800) + 100);
			}
		}
	}
		
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public void Withdraw(int money) {
		bank.publicAccount.Withdraw(money);
	}
	
	public void Deposit(int money) {
		bank.publicAccount.Deposit(money);
	}
	
	
}
