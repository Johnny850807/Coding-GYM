
public class Button {
	private OnClickListener listener;
	
	public void setListener(OnClickListener listener) {
		this.listener = listener;
	}
	
	public void order(Guest guest) {
		System.out.println(guest.getName() + " ­qÀ\¤F~~~~");
		listener.onGuestOrder(guest);
	}
}
