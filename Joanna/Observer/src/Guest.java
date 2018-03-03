
public class Guest implements OnOrderListener {
	private String name;
	
	public Guest(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}

	@Override
	public void onTakeMenu(Button button) {
		button.order(this);
	}

	@Override
	public void onOrderFinish() {
		System.out.println(getName() + " ���q�槹���F!!!�}�ߦ^�a!!!");
	}

}
