package �\�U�����;

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
		
		System.out.println("[���u] " + getName() + "�w����u�@�C");
	}
	
	private void takeNextOrder() throws InterruptedException{
		Order order = null;
		synchronized (orderQueue) {
			if (orderQueue.isEmpty())
			{
				System.out.println("[�ݩR] �p�v " + getName() + " �ݩR���C");
				orderQueue.wait();  //wait for the orders
			}
			order = orderQueue.pop();
		}
		
		executeOrder(order);
	}
	
	private void executeOrder(Order order) throws InterruptedException {
		System.out.printf("[�}�l�s�@] �p�v  %s �}�l�s�@�ȤH %s �n�D�� %s�C\n", getName(), order.getCustomerName(), order.getMeal());
		Thread.sleep(order.getTimeCost() * 1000);  //executing
		restaurant.giveBill(this, order);
	}

	public void setWorking(boolean working) {
		this.working = working;
	}

}
