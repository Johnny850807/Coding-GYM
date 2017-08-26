import java.util.ArrayList;
import java.util.ConcurrentModificationException;
import java.util.List;
import java.util.concurrent.TimeUnit;

import Bank.Bank;
import User.User;

public class Main {
	static Bank bank;
	static List<Thread> threadList;
	public static void main(String[] args) {
		try {
			for ( int i = 0 ; i < 2000 ; i ++ ) // 運行兩千次 驗證資料完全一致
			{
				initResourceAndRunUserThreads();
				for ( Thread t : threadList )  // 等待執行緒們都結束
					t.join();

				int result = bank.getIncome() - bank.getOutlay();
				System.out.printf("結論: 總和 %d - %d = %d %n",bank.getIncome() , bank.getOutlay() , result);
				if (result != 0)
					throw new ConcurrentModificationException("資料不一致，Bank 還有 " + bank.getMoney() + " $");
			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private static void initResourceAndRunUserThreads() {
		bank = new Bank();
		threadList = new ArrayList<Thread>();
		for ( int i = 0 ; i < 100 ; i ++)
			threadList.add(new Thread ( new User(bank) ));
		for (Thread t : threadList)
			t.start();
	}

}
