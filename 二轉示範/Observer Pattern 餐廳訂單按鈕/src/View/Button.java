package View;

import Restaurant.Guest;

/**
 * Button is a kind of ClickableView, so it can do more things in click() method.
 */
public class Button extends ClickableView{

	@Override
	public void click(Guest guest) {
		super.click(guest);
		// do more things if needed.
	}
}
