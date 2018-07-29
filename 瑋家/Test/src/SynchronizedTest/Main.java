package SynchronizedTest;

import java.util.ArrayList;
import java.util.List;

public class Main {
	static List<Thread> userList = new ArrayList<Thread>();
	
	public static void main(String args[]) {
		Bank bank = new Bank("TaiwanBank");
		Account publicAccount = new Account(bank, "PublicAccount");
		CreateUserThread(publicAccount);
		try {
			for ( Thread t : userList ) {
				t.join();
			}
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	public static void CreateUserThread(Account publicAccount) {
		
		for(int i=0 ; i<100 ;i++) {
			userList.add(new Thread(new User(publicAccount)));
		}
		
		for(Thread t : userList) {
			t.start();
		}	
	}
}
