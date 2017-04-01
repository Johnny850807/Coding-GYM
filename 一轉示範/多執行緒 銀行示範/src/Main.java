import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
	static Bank bank = new Bank();
	static List<Thread> threadList = new ArrayList<Thread>();
	public static void main(String[] args) {
		try {
			genarateUser();
			while(!bank.isStop())
			{
				Thread.sleep(50);
				for ( Thread t : threadList )  // Wait for every thread's work done
					t.join();
			}

			bank.setStop(true);
			int result = bank.getIncome() - bank.getOutlay();
			

			
			System.out.printf("結論: 總和 %d - %d = %d %n",bank.getIncome() , bank.getOutlay() , result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void genarateUser() {
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		threadList.add(new Thread ( new User(bank) ));
		
		for (Thread t : threadList)
			t.start();
	}

}
