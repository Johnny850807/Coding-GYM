package Restaurant;

import java.util.Random;
import java.util.concurrent.TimeUnit;

import View.ClickableView;

public abstract class Guest {
	protected Restaurant restaurant;
	private String name;
	
	private static String[] NAME_SET = {"WangNing","WaterBall","Aping","Max"
			, "ShengFong" , "BingZhong" , "FongXu" , "ZongYeee" , "WeiJie"};
	
	public Guest(){
		restaurant = Restaurant.getInstance();
		createName();
	}
	
	private void createName(){
		int index = new Random().nextInt(NAME_SET.length);
		name = NAME_SET[index];
	}

	public abstract void clickButton(ClickableView button);
	
	public abstract void onOrderFinished();
	
	public void accessRestaurant() throws InterruptedException{
		System.out.println(this+" ¶i¤JÀ\ÆU¤F..");
		restaurant.addGuest(this);
		TimeUnit.SECONDS.sleep(3);
		restaurant.getButton().click(this);
	}
	
	public void leaveRestaurant(){
		restaurant.removeGuest(this);
	}

	@Override
	public String toString() {
		return name;
	}
	
	
	

}
