package Restaurant;

import View.ClickableView;

public class NormalGuest extends Guest{
	@Override
	public void clickButton(ClickableView button) {
		button.click(this);
	}

	@Override
	public void onOrderFinished() {
		System.out.println(this+" 的訂單完成了!!!開心回家!!!");
		restaurant.removeGuest(this);
	}

}
