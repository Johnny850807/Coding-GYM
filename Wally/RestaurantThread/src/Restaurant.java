import java.util.ArrayList;
import java.util.LinkedList;
import java.util.NoSuchElementException;
import java.util.Random;

public class Restaurant {
	
	CounterStaff counterStaff = new CounterStaff();
	private ArrayList<Thread> customerList = new ArrayList<Thread>();
	private Thread openRestaurantThread = new Thread(new TimeCounter());
	private Thread chefs[] = createChefThread() ;
	
	public static void main(String[] args) {
				
		Restaurant restaurant = new Restaurant();
		restaurant.openRestaurantThread.start();

			while (restaurant.openRestaurantThread.isAlive()) {
					restaurant.customerComing(restaurant);
			}	
		restaurant.closeRestaurant();
	}

	private void customerComing(Restaurant restaurant) {

		Random random = new Random();
		int customerComingFrequency = (random.nextInt(5) + 2) * 1000;
			try {
					Thread.sleep(customerComingFrequency);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		CustomerThread customer = new CustomerThread();
		customer.setRestaurantLocation(restaurant);
		Thread oneOfCustomer = new Thread(customer);
		customerList.add(oneOfCustomer);
			if (openRestaurantThread.isAlive()) {
					oneOfCustomer.start();
					System.out.println("客人登門來訪");
			}
	}
	private Thread[] createChefThread() {

		Thread chefs[] = new Thread[5];
			for (int i = 1; i < (chefs.length + 1); i++) {
					Restaurant.Chef employee = new Restaurant.Chef(i);
					Thread oneChef = new Thread(employee);
					oneChef.start();
			}
		return chefs;
	}

	private void closeRestaurant() {

		try {
				Thread.sleep(25 * 1000);
				System.out.println("餐廳打烊了");
				System.out.println("今日營收為：" + counterStaff.currentRevenue + "圓整");
		} catch (InterruptedException e) {
				e.printStackTrace();
		}
	}
	public class CounterStaff {

		private LinkedList<Order> customerOrders = new LinkedList<Order>();
		private int currentRevenue = 0;

		public synchronized void setOrder(Order customerFoodOrder) {
			customerOrders.add(customerFoodOrder);
		}
		public synchronized Order getOrder() {
			try {
					return customerOrders.pop();				
			} catch (Exception e) {
					return null;
			}
		}
		public synchronized void cumstomerCheckOut(int money) {
			currentRevenue += money;
			System.out.println("當前營收為：" + currentRevenue + "圓整");
		}
	}

	private class Chef implements Runnable {

	private int chefSerialNumber = 0;
	private Order customerOrder;

	public Chef(int chefAmount) {
		chefSerialNumber = chefAmount;
		System.out.println("廚師" + chefSerialNumber + "號已就位");
	}
	public void run() {
		
		do {
				do {
						customerOrder = counterStaff.getOrder();
				}while(customerOrder == null);

				Menu customerFood = customerOrder.getFoodInfo();
				int cookingTime = customerFood.getCookingTime();		
				try {
						System.out.println("廚師" + chefSerialNumber + "號開始烹飪第" + customerOrder.getNumberPlate()+ "位客人的食物：" + customerFood.toString());
						Thread.sleep(cookingTime);
						System.out.println("廚師" + chefSerialNumber + "號已烹飪完第" + customerOrder.getNumberPlate()+ "位客人的食物：" + customerFood.toString());
						System.out.println("正在上菜給第" + customerOrder.getNumberPlate() + "位客人" + customerFood.toString());
						
						synchronized (customerOrder) {
							customerOrder.notify();
						}
				} catch (InterruptedException e) {
						e.printStackTrace();
				}
			} while (openRestaurantThread.isAlive());
		}
	}
}
