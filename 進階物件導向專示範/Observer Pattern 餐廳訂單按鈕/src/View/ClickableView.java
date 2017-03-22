package View;

import Restaurant.Guest;

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
