import java.util.Random;

public class CustomerThread implements Runnable{
	
	private static int customerAmount = 0 ;
	private int customerSerialNumber = 0 ;
	private Order customerOrder ;
	private Restaurant.CounterStaff counterStaff ;
	
	public CustomerThread(Restaurant.CounterStaff counterStaff) {
		this.counterStaff = counterStaff ;
	}
	
	public void run() {
		
			
		setCustomerFoodOrder();
		
		synchronized (customerOrder) {
			
			try {
				if(customerOrder.isFoodWaitingForCook()) {
						
				customerOrder.wait();			
				}
					
				Thread.sleep(300);
					
				Ｍenu customerFood = customerOrder.getFoodInfo();
				int mealPrice = customerFood.getMealPrice();
					
				System.out.println("第"+customerSerialNumber+"位客人已用餐完畢");
				System.out.println("第"+customerSerialNumber+"位客人結帳");
				counterStaff.cumstomerCheckOut(mealPrice);
					
			} catch (InterruptedException e) {
					
				e.printStackTrace();
			}
		}		
	}
	
	private synchronized void setCustomerFoodOrder() {
		
		Ｍenu oneMeal ;
		Random randomOrder = new Random();
		
		oneMeal = Ｍenu.values()[randomOrder.nextInt(Ｍenu.values().length)];
		
		synchronized (counterStaff) {
		customerSerialNumber = ++customerAmount ;	
		System.out.println("第"+customerSerialNumber+"位客人已點餐");			
		customerOrder = new Order(customerSerialNumber, oneMeal);	
		counterStaff.setOrder(customerOrder);;
		}
	}
	
}
