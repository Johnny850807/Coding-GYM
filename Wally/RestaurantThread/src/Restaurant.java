import java.util.LinkedList;
import java.util.Random;

public class Restaurant {

	public static StoreOpenThread s1 = new StoreOpenThread();
	public static Thread storeOpenThread = new Thread(s1);
	
	protected static  Restaurant.CounterStaff counterStaff = new Restaurant().new CounterStaff();	
	
	public static void main(String[] args) {
		
		
		storeOpenThread.start();
		
		Thread chefs [] = chefOnThePosition();
		
		while (storeOpenThread.isAlive()) {
			
			Restaurant.customerComing();			
		}
		
		storeClose();
	}
	
	private static void customerComing() {
		
		Random random = new Random();
		int customerComingFrequency = (random.nextInt(5)+2)*1000 ;
		
		try {
			
			Thread.sleep(customerComingFrequency);
		}catch	(InterruptedException e) {
					
			e.printStackTrace();
		}
			CustomerThread customer = new CustomerThread(counterStaff);
			Thread oneOfCustomer = new Thread(customer);
			
		if (storeOpenThread.isAlive()) {
				
			oneOfCustomer.start();
			System.out.println("客人登門來訪");
		}
	}
	
	private static Thread[] chefOnThePosition () {
		
		Thread chefs [] = new Thread[5];

		for (Thread oneChef : chefs) {
			
			Restaurant.Chef employee = new Restaurant.Chef();
			oneChef = new Thread(employee);
			oneChef.start();
		}
		return chefs ;
	}
	
	private static void storeClose() {
		
		try {
			
			Thread.sleep(23*1000);
			System.out.println("餐廳打烊了");
			System.out.println("今日營收為："+counterStaff.currentRevenue+"圓整");
		} catch (InterruptedException e) {
			
			e.printStackTrace();
		}		
	}
	
	public class CounterStaff {
	
	private LinkedList<Order> customerOrders = new LinkedList<Order>();
	private int currentRevenue = 0 ;
	
	public void setOrder(Order customerFoodOrder) {
		
		customerOrders.add(customerFoodOrder);
	}
	
	public Order getOrder(int customerSerialNumber) {
		
		return customerOrders.get(customerSerialNumber);
	}
	
	public synchronized boolean hasOrder(int finishedOrderAmount) {
		
		boolean hasOrder = false ;
		int unfinishedOrderAmount = customerOrders.size();		
		
		if(finishedOrderAmount<unfinishedOrderAmount){
			
			hasOrder = true ;
		}
		return hasOrder ;
	}
	
	public synchronized void cumstomerCheckOut(int money) {
		
		currentRevenue += money ;
		System.out.println("當前營收為："+currentRevenue+"圓整");
	}
	
	}
	
	
	private static class Chef implements Runnable{
	
	private static int chefAmount = 0 ;
	private static int finishedOrderAmount = 0 ;
	private int chefSerialNumber = 0 ;
	private Order customerOrder ;

	public Chef() {
		
	++chefAmount ;
	chefSerialNumber = chefAmount ;
	System.out.println("廚師"+chefSerialNumber+"號已就位");
	}
	
	public void run() {
		
		do {
			
			synchronized (counterStaff) {
					
				boolean hasFoodWaitForCook = counterStaff.hasOrder(finishedOrderAmount);

				if (hasFoodWaitForCook) {
				
				getCustomerFoodOrder();
				}		
			}
				if (customerOrder!=null) {
				
				Menu customerFood = customerOrder.getFoodInfo();
				
				int cookingTime = customerFood.getCookingTime();
				
				try {
					System.out.println("廚師"+chefSerialNumber+"號開始烹飪第"+customerOrder.getNumberPlate()+"位客人的食物："+customerFood.toString());
					
					Thread.sleep(cookingTime);
						
					System.out.println("廚師"+chefSerialNumber+"號已烹飪完第"+customerOrder.getNumberPlate()+"位客人的食物："+customerFood.toString());
					System.out.println("正在上菜給第"+customerOrder.getNumberPlate()+"位客人"+customerFood.toString());
						
					synchronized (customerOrder) {
							
					customerOrder.notify();
					}
					customerOrder = null ;
					}catch (InterruptedException e) {
						
					e.printStackTrace();
					}
				}		
			}while(storeOpenThread.isAlive());	
	}
	
	public void getCustomerFoodOrder() {
		
		customerOrder = counterStaff.getOrder(finishedOrderAmount++);
	}
		
	}
	
}
