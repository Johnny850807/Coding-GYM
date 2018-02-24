package Restaurant;

import View.ClickableView;
/**
 * Here we have an instance of the Guest, so that the implementations are specified here.
 * We now can decide what to do when the order is finished!
 * We leave the restaurant! As codes below.
 */
public class NormalGuest extends Guest{
	
	@Override
	public void clickButton(ClickableView button) {
		button.click(this);
	}

	@Override
	public void onOrderFinished(Restaurant restaurant) {
		System.out.println(this+" 的訂單完成了!!!開心回家!!!");
		restaurant.removeGuest(this);
	}

}
