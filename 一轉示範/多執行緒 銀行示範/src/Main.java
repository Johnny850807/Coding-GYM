import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
	static Bank bank = new Bank();
	static List<Thread> threadList = new ArrayList<Thread>();
	public static void main(String[] args) {
		try {
			genarateUsers();
			while(!bank.isBroke()){
				for ( Thread t : threadList )  // 等待執行緒們都結束
					t.join();
			} // 等待銀行破產

			int result = bank.getIncome() - bank.getOutlay();
			System.out.printf("結論: 總和 %d - %d = %d %n",bank.getIncome() , bank.getOutlay() , result);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	private static void genarateUsers() {
		for ( int i = 0 ; i < 100 ; i ++)
			threadList.add(new Thread ( new User(bank) ));
		for (Thread t : threadList)
			t.start();
	}

}
