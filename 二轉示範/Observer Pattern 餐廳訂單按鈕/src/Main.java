import java.util.concurrent.TimeUnit;

import Restaurant.Guest;
import Restaurant.NormalGuest;
import Restaurant.Restaurant;
import View.Button;

public class Main {
	private static Restaurant restaurant = new Restaurant(new Button()); //DI
	
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
					newGuest.accessRestaurant(restaurant);	
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}

}
