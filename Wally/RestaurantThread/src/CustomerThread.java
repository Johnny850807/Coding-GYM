import java.util.Random;

public class CustomerThread implements Runnable {

	private static int customerAmount = 0;
	private int customerSerialNumber = 0;
	private Restaurant restaurant;
	private Order customerOrder;

	public void run() {
		
		setCustomerFoodOrder();
		
		synchronized (customerOrder) {

			try {
					customerOrder.wait();
					Thread.sleep(300);
					
					System.out.println("第" + customerSerialNumber + "位客人已用餐完畢");
					System.out.println("第" + customerSerialNumber + "位客人結帳");
					
					Menu customerFood = customerOrder.getFoodInfo();
					int mealPrice = customerFood.getMealPrice();
					restaurant.counterStaff.cumstomerCheckOut(mealPrice);
			} catch (InterruptedException e) {
					e.printStackTrace();
			}
		}
	}
	private synchronized void setCustomerFoodOrder() {

		Menu oneMeal;
		Random randomOrder = new Random();
		oneMeal = Menu.values()[randomOrder.nextInt(Menu.values().length)];

		synchronized (restaurant.counterStaff) {
			customerSerialNumber = ++customerAmount;
			System.out.println("第" + customerSerialNumber + "位客人已點餐");
			customerOrder = new Order(customerSerialNumber, oneMeal);
			restaurant.counterStaff.setOrder(customerOrder);
		}
	}	
	public void setRestaurantLocation(Restaurant lunchPlace) {
		this.restaurant = lunchPlace ;
	}
}
