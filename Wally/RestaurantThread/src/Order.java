
public class Order {

	private int numberPlate ;
	private boolean isFoodUndone = true ;
	private Ｍenu customerOrder ;

	public Order(int customerSerialNumber , Ｍenu food) {
		setNumberPlate(customerSerialNumber);
		setFoodInfo(food);
	}
	
	public void setNumberPlate(int customerSerialNumber) {
		this.numberPlate = customerSerialNumber;
	}
	
	public int getNumberPlate() {
		return numberPlate;
	}
	
	public void setFoodInfo(Ｍenu customerOrder) {
		this.customerOrder = customerOrder;
	}
	
	public Ｍenu getFoodInfo() {
		return customerOrder;
	}
	
	public void setFoodProgressRate(boolean isFinished) {
		isFoodUndone = isFinished ;
	}
	
	public boolean isFoodWaitingForCook() {
		return isFoodUndone ;
	}
	
	
}
