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
			for ( int i = 0 ; i < 2000 ; i ++ ) // �B���d�� ���Ҹ�Ƨ����@�P
			{
				initResourceAndRunUserThreads();
				for ( Thread t : threadList )  // ���ݰ�����̳�����
					t.join();

				int result = bank.getIncome() - bank.getOutlay();
				System.out.printf("����: �`�M %d - %d = %d %n",bank.getIncome() , bank.getOutlay() , result);
				if (result != 0)
					throw new ConcurrentModificationException("��Ƥ��@�P�ABank �٦� " + bank.getMoney() + " $");
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
