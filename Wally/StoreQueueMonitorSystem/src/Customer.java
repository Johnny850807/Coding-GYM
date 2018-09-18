
public class Customer {

	private String customerName ;
	private static String customerQueue ;
		
	public Customer() {

	}
	
	public Customer(String customerName) {
		setCustomerName(customerName);
	}
	
	
	public String getCustomerName() {
		return customerName;
	}
	
	public void setCustomerName(String customerName) {
		this.customerName = customerName;
	}
	
	public String getCustomerQueue() {
		return customerQueue;
	}
	
	public void setCustomerQueue(String customerIntoTheStoreOrLeave) {
		this.customerQueue = customerIntoTheStoreOrLeave;
	}
	
	public boolean isCumstomerLeave(){
		return customerQueue.equals("R");
	}
	
	public String toString(){
		return customerName ;
	}
	
}
