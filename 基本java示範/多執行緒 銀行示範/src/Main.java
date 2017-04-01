import java.util.concurrent.TimeUnit;

public class Main {
	static Bank bank = new Bank();
	public static void main(String[] args) {
		try {
			genarateUser();
			while(!bank.isStop())
				TimeUnit.SECONDS.sleep(1);
			bank.setStop(true);
			int result = bank.getIncome() - bank.getOutlay();
			System.out.printf("結論: 總和 %d - %d = %d %n",bank.getIncome() , bank.getOutlay() , result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void genarateUser() {
		new Thread ( new User(bank) ).start();
		new Thread ( new User(bank) ).start();
		new Thread ( new User(bank) ).start();
		new Thread ( new User(bank) ).start();
		new Thread ( new User(bank) ).start();
		new Thread ( new User(bank) ).start();
	}

}
