package �\�U�����;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.TimeUnit;

public class Restaurant {
	protected PriorityQueue<Order> orderQueue = 
			new SyncListAdapter<>(/*(o1, o2) -> o1.getTimeCost() - o2.getTimeCost()*/);
	private List<Chef> chefs = new ArrayList<>();
	private int margin = 0;
	private int timeCountDown = (int) TimeUnit.MINUTES.toMillis(2);  //2 minutes countdown
	private boolean isWorking = true;
	
	public void start(){
		System.out.println("[�\�U] �\�U�}���աI");
		System.out.println("[�\�U] �}�l���Τj�p�C");
		employChefs();
		welcomeCustomers();
		startCountingDownTime();
	}

	private void employChefs() {
		chefs.add(new Chef(this, "Wally"));
		chefs.add(new Chef(this, "Lin"));
		chefs.add(new Chef(this, "Waterball"));
		chefs.add(new Chef(this, "Shawn"));
		chefs.add(new Chef(this, "Max"));
		System.out.println("[�\�U] �j�p�̤w�N��I");
		System.out.println("[�\�U] �\�U�����}�i�I");
	}

	private void welcomeCustomers() {
		for (Chef chef : chefs)
			new Thread(chef).start();
		
		Market.acceptCustomers(this);
	}
	
	public void appendOrder(Order order){
		System.out.printf("[�s�q��] �ȤH %s �Q�n�@�� %s�C\n", order.getCustomerName(), order.getMeal());
		
		synchronized (orderQueue) {
			orderQueue.push(order);
			orderQueue.notify();  //notify one of the chefs to receive the next order
		}
	}

	private void startCountingDownTime() {
		new Thread(){
			public void run() {
				try {
					while(timeCountDown > 0)
					{
						int counted = 30 * 1000;
						Thread.sleep(counted);
						timeCountDown -= counted;
						System.out.println("[�˼�] �ɶ��ٳѤU " + (timeCountDown/1000) + "��C");
					}
					
					closeRestaurant();
				} catch (InterruptedException e) {}
			};
		}.start();
	}
	
	private void closeRestaurant() throws InterruptedException{
		System.out.println("[���~] �}�l���p�v�̤U�Z�C");
		setWorking(false);
		
		for (Chef chef : chefs)
			chef.setWorking(false);

		for (Chef chef : chefs)  // interrupt the waiting/sleeping threads
			chef.interrupt();
		
		for (Chef chef : chefs)  // wait
			chef.join();

		System.out.println("[���~] �`�@�ȶi�F " + margin + "$�I");
	}
	
	public void giveBill(Chef chef, Order order){
		System.out.printf("[����] �p�v  %s �}�l�s�@�ȤH %s �n�D�� %s�C\n", chef.getName(), order.getCustomerName(), order.getMeal());
		this.margin += order.getPrice();
		System.out.println("[���b] �Ȩ�F " + order.getPrice() + "�I �ثe�`�վl�G" + this.margin + "�C");
	}
	
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	
	public boolean isWorking() {
		return isWorking;
	}
}
