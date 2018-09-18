package test2;

import java.util.ArrayList;
import java.util.List;

public class Main {
	
	public static void main(String[] args) {
		List<Thread> list = new ArrayList();
		for(int i=0;i<100;i++) {
			list.add( new Thread(new thread(i)));
		}
		
		for(Thread t: list) {
			t.start();
		}
	}

}

class thread implements Runnable{
	String string;
	public thread(int i) {
		string = "T"+i;
		//Thread.currentThread().setName(string);
	}
	@Override
	public void run() {
		Thread.currentThread().setName(string);
		System.out.println(Thread.currentThread().getName());
	}
	
}