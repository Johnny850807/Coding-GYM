package Restaurant;

import View.ClickableView;

public class NormalGuest extends Guest{
	@Override
	public void clickButton(ClickableView button) {
		button.click(this);
	}

	@Override
	public void onOrderFinished() {
		System.out.println(this+" ���q�槹���F!!!�}�ߦ^�a!!!");
		restaurant.removeGuest(this);
	}

}
