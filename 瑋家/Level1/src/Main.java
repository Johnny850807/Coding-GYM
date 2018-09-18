import java.util.ArrayList;
import java.util.List;

import javax.sound.midi.Soundbank;

public class Main {

	static Bank bank = new Bank();
	static List<Thread> userThreadList = new ArrayList<Thread>();
	
	public static void main(String[] args) {
		CreatUserThread();
		StartUserThread();
	}
	
	public static void CreatUserThread() {
		for(int i=0;i<100;i++) {
			userThreadList.add(new Thread(new User(bank)));
		}
			
	}
	
	public static void StartUserThread() {
		if(userThreadList == null)
			System.out.println("請先創建Users");
		else {
			for(Thread thread:userThreadList) {
				thread.start();
				try {
					thread.join();
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
				
		}
		System.out.println("總提領" + bank.publicAccount.withdrawLog);
		System.out.println("總存款" + bank.publicAccount.depositLog);
	}
}
