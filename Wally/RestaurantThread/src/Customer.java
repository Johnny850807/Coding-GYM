import java.util.Random;

public class Customer implements Runnable {
	private static int customerAmount = 0;
	private int id = 0;
	private Restaurant restaurant;
	private Order customerOrder;

	public Customer(Restaurant restaurant) {
		this.restaurant = restaurant;
	}

	public void run() {
		orderCustomerMeal();  //點餐
		waitForTheOrderedMeal();
		System.out.println("[結帳] 第" + id + "位客人已用餐完畢並結帳");
		Meal customerFood = customerOrder.getFoodInfo();
		int mealPrice = customerFood.getMealPrice();
		restaurant.getCounterStaff().customerCheckOut(mealPrice);
	}

	private void waitForTheOrderedMeal() {
		synchronized (customerOrder) {
			try {
				customerOrder.wait();  //等待此訂單完成上菜
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		Delay.milliseconds(300);  // 用餐時間
	}

	private synchronized void orderCustomerMeal() {
		Meal oneMeal;
		Random randomOrder = new Random();
		oneMeal = Meal.values()[randomOrder.nextInt(Meal.values().length)];

		synchronized (restaurant.getCounterStaff()) {
			id = ++customerAmount;
			System.out.println("[點餐] 第" + id + "位客人已點餐");
			customerOrder = new Order(id, oneMeal);
			restaurant.getCounterStaff().addOrder(customerOrder);
		}
	}

}
