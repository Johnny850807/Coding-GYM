package À\ÆU°õ¦æºü;

import java.util.Random;

public class Market {
	public static void acceptCustomers(Restaurant restaurant){
		Random random = new Random();
		
		//Create a customer in every random 2~7 seconds
		new Thread(){
			@Override
			public void run() {
				try {
					while(restaurant.isWorking())
					{
						Thread.sleep(random.nextInt(5001) + 2000);
						if (restaurant.isWorking())
						{
							Order order = createRandomOrder();
							restaurant.appendOrder(order);
						}
					}
				} catch (InterruptedException e) {}
			}
		}.start();
	}
	
	private static Order createRandomOrder(){
		Random random = new Random();
		Meals[] meals = Meals.values();
		return new Order(createRandomName(), meals[random.nextInt(meals.length)]);
	}
	
	private static String createRandomName(){
		Random random = new Random();
		StringBuilder stringBuilder = new StringBuilder();
		
		int nameLength = random.nextInt(8) + 5;
		stringBuilder.append((char)(random.nextInt(26) + 65));  //first character in a name is upper
		for (int i = 1; i < nameLength; i ++)
			stringBuilder.append((char)(random.nextInt(26) + 97));
		
		return stringBuilder.toString();
	}
}
