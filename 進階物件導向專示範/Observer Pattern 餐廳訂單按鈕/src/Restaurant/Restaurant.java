package Restaurant;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import View.*;

public class Restaurant {
	private static Restaurant instance = new Restaurant();
	private static Collection<Guest> guestSet = 
			Collections.checkedSet(new HashSet<Guest>(), Guest.class);
	
	private ClickableView button = new Button();
	
	//singleton
	private Restaurant(){
		setupButton();
	}  
	
	public static Restaurant getInstance(){
		return instance;
	}
	
	private void setupButton(){
		button.setOnClickListener(new ClickableView.OnClickListener() {
			@Override
			public void onClick(Guest guest) {
				handleGuest(guest);
			}
		});
	}
	
	private void handleGuest(Guest guest){
		System.out.println(guest+" 訂餐了~~~~");
		new Thread(){
			@Override
			public void run() {
				try {
					makeOrderToGuest(guest);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	private void makeOrderToGuest(Guest guest) throws InterruptedException{
		TimeUnit.SECONDS.sleep(5);
		guest.onOrderFinished();
	}
	
	public void addGuest(Guest guest){
		guestSet.add(guest);
		System.out.println("餐廳目前人數: " + guestSet.size());
	}
	
	public void removeGuest(Guest guest){
		guestSet.remove(guest);
	}

	public ClickableView getButton() {
		return button;
	}
	
}
