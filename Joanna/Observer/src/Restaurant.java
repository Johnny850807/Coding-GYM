import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Restaurant implements OnClickListener {
	private List<OnOrderListener> listeners = new ArrayList<>();
	private Button button;
	
	public Restaurant() {
		button = new Button();
		button.setListener(this);
	}
	
	public void addGuest(OnOrderListener listener) {
		listeners.add(listener);
		System.out.println("餐廳目前人數: " + listeners.size());
		listener.onTakeMenu(button);
	}
	
	@Override
	public void onGuestOrder(OnOrderListener listener) {
		new Thread() {
			public void run() {
				int random = new Random().nextInt(5) + 5;
				try {
					Thread.sleep(random * 1000);
					listener.onOrderFinish();
					listeners.remove(listener);
				} catch (InterruptedException e) {
					e.printStackTrace();
				}
			}
		}.start();
	}
	
}
