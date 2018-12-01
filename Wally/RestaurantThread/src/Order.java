
public class Order {

	private int numberPlate ;
	private boolean isFoodUndone = true ;
	private Menu customerOrder ;

	public Order(int customerSerialNumber , Menu food) {
		setNumberPlate(customerSerialNumber);
		setFoodInfo(food);
	}
	
	public void setNumberPlate(int customerSerialNumber) {
		this.numberPlate = customerSerialNumber;
	}
	
	public int getNumberPlate() {
		return numberPlate;
	}
	
	public void setFoodInfo(Menu customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	public Menu getFoodInfo() {
		return customerOrder;
	}
	
	public void setFoodProgressRate(boolean isFinished) {
		isFoodUndone = isFinished ;
	}
	
	public boolean isFoodWaitingForCook() {
		return isFoodUndone ;
	}
	
	
}
