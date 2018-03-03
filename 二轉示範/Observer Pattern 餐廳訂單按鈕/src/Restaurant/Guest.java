package Restaurant;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import View.ClickableView;

/**
 * Here we have Guest class, but its an abstract class.
 * We make an abstraction so that guests can react differently to certain events,
 * such as "When the order is finished" event, or different ways to click button.
 * However, if there is an abstraction, means there are things to be different.
 * And the more important point is that here Guest is an observer of the restaurant, 
 * so it should be abstract.
 */
public abstract class Guest {
	private String name;
	private static String[] NAME_SET = {"WangNing","WaterBall","Aping","Max"
			, "ShengFong" , "BingZhong" , "FongXu" , "ZongYeee" , "WeiJie"};
	
	public Guest(){
		this.name = createName();
	}
	
	private String createName(){
		int index = new Random().nextInt(NAME_SET.length);
		return NAME_SET[index];
	}

	public void accessRestaurant(Restaurant restaurant) throws InterruptedException{
		System.out.println(this+" ¶i¤JÀ\ÆU¤F..");
		restaurant.addGuest(this);  //become an observer of the restaurant
		TimeUnit.SECONDS.sleep(3);
		clickButton(restaurant.getButton()); // click the button for ordering food!
	}

	public abstract void clickButton(ClickableView button);
	
	public abstract void onOrderFinished(Restaurant restaurant);
	
	public void leaveRestaurant(Restaurant restaurant){
		restaurant.removeGuest(this);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	

}
