package À\ÆU°õ¦æºü;

public class Order{
	private String customerName;
	private Meals meal;
	
	public Order(String customerName, Meals meal) {
		this.customerName = customerName;
		this.meal = meal;
	}
	
	
	public String getCustomerName() {
		return customerName;
	}

	public Meals getMeal() {
		return meal;
	}
	
	public int getPrice(){
		return meal.price;
	}

	public int getTimeCost(){
		return meal.timeCost;
	}
}
