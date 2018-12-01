package 餐廳執行緒;

public class Chef extends Thread{
	private boolean working = true;
	private final Restaurant restaurant;
	private final PriorityQueue<Order> orderQueue;

	public Chef(Restaurant restaurant, String name) {
		this.restaurant = restaurant;
		this.orderQueue = restaurant.orderQueue;
		
		super.setName(name);  //set the chef's name as the thread's name
	}
	
	@Override
	public void run() {
		try {
			while(working)
				takeNextOrder();
		} catch (InterruptedException e) {}
		
		System.out.println("[停工] " + getName() + "已停止工作。");
	}
	
	private void takeNextOrder() throws InterruptedException{
		Order order = null;
		synchronized (orderQueue) {
			if (orderQueue.isEmpty())
			{
				System.out.println("[待命] 廚師 " + getName() + " 待命中。");
				orderQueue.wait();  //wait for the orders
			}
			order = orderQueue.pop();
		}
		
		executeOrder(order);
	}
	
	private void executeOrder(Order order) throws InterruptedException {
		System.out.printf("[開始製作] 廚師  %s 開始製作客人 %s 要求的 %s。\n", getName(), order.getCustomerName(), order.getMeal());
		Thread.sleep(order.getTimeCost() * 1000);  //executing
		restaurant.giveBill(this, order);
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

}
