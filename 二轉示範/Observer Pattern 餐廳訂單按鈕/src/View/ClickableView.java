package View;

import Restaurant.Guest;
/**
 * This class represents views which can be clicked (have click() method).
 * Make a layer from this abstraction, so that button, 
 * image or any other views can inherit this class.
 */
public abstract class ClickableView implements View {
	private OnClickListener listener;
	
	public void setOnClickListener(OnClickListener listener){
		this.listener = listener;
	}
	
	public void click(Guest guest){
		listener.onClick(guest);
	}
	
	public static interface OnClickListener{
		void onClick(Guest guest);
	}
}
