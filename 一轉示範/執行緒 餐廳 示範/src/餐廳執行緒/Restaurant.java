package 餐廳執行緒;

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
		System.out.println("[餐廳] 餐廳開幕啦！");
		System.out.println("[餐廳] 開始雇用大廚。");
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
		System.out.println("[餐廳] 大廚們已就位！");
		System.out.println("[餐廳] 餐廳正式開張！");
	}

	private void welcomeCustomers() {
		for (Chef chef : chefs)
			new Thread(chef).start();
		
		Market.acceptCustomers(this);
	}
	
	public void appendOrder(Order order){
		System.out.printf("[新訂單] 客人 %s 想要一份 %s。\n", order.getCustomerName(), order.getMeal());
		
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
						System.out.println("[倒數] 時間還剩下 " + (timeCountDown/1000) + "秒。");
					}
					
					closeRestaurant();
				} catch (InterruptedException e) {}
			};
		}.start();
	}
	
	private void closeRestaurant() throws InterruptedException{
		System.out.println("[結業] 開始趕廚師們下班。");
		setWorking(false);
		
		for (Chef chef : chefs)
			chef.setWorking(false);

		for (Chef chef : chefs)  // interrupt the waiting/sleeping threads
			chef.interrupt();
		
		for (Chef chef : chefs)  // wait
			chef.join();

		System.out.println("[結業] 總共賺進了 " + margin + "$！");
	}
	
	public void giveBill(Chef chef, Order order){
		System.out.printf("[完成] 廚師  %s 開始製作客人 %s 要求的 %s。\n", chef.getName(), order.getCustomerName(), order.getMeal());
		this.margin += order.getPrice();
		System.out.println("[結帳] 賺到了 " + order.getPrice() + "！ 目前總盈餘：" + this.margin + "。");
	}
	
	public void setWorking(boolean isWorking) {
		this.isWorking = isWorking;
	}
	
	public boolean isWorking() {
		return isWorking;
	}
}
