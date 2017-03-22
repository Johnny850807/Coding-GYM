import java.util.concurrent.TimeUnit;

import Restaurant.Guest;
import Restaurant.NormalGuest;

public class Main {

	public static void main(String[] args) {
		try{
			
			while(true)
			{
				delay();
				createGuest();
			}
			
		}catch(InterruptedException err){
			err.printStackTrace();
		}
		
	}

	private static void delay() throws InterruptedException {
		TimeUnit.SECONDS.sleep(6);
	}

	private static void createGuest() {
		new Thread(){
			@Override
			public void run(){
				try {
					Guest newGuest = new NormalGuest();
					newGuest.accessRestaurant();	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
