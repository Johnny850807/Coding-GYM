package Restaurant;


import java.util.Collection;
import java.util.Collections;
import java.util.HashSet;
import java.util.concurrent.TimeUnit;

import View.*;


public class Restaurant {
	private Collection<Guest> guestSet = 
			Collections.checkedSet(new HashSet<Guest>(), Guest.class);
	
	private ClickableView orderingRing;
	
	/**
	 * Note that we did a dependency inversion, we don't specify the type of ClickableView to Button,
	 * instead, we fetch the instance of it from the parameter of the constructor.
	 * So the type can be various. It needn't be a button.
	 */
	public Restaurant(ClickableView orderingRing){
		this.orderingRing = orderingRing;
		
		// so now the restaurant is an observer of the ClickableView!
		// restaurant needs to know if the ring got clicked!
		// once the ring is clicked, it's time to handle the request from Guests!
		orderingRing.setOnClickListener((guest) ->handleGuestRequest(guest));
	}  
	
	private void handleGuestRequest(Guest guest){
		System.out.println(guest+" 訂餐了~~~~");
		
		// here we should start a thread, otherwise orders cannot work simultaneously.
		new Thread(){
			@Override
			public void run() {
				try {
					fillOrderAndNotifyGuest(guest);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
	private void fillOrderAndNotifyGuest(Guest guest) throws InterruptedException{
		TimeUnit.SECONDS.sleep(5);  // simulation of working
		guest.onOrderFinished(this);
	}
	
	public void addGuest(Guest guest){
		guestSet.add(guest);
		System.out.println("餐廳目前人數: " + guestSet.size());
	}
	
	public void removeGuest(Guest guest){
		guestSet.remove(guest);
	}

	public ClickableView getButton() {
		return orderingRing;
	}
	
}
