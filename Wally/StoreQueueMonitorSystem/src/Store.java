import java.util.HashSet;
import java.util.Iterator;

public class Store {
	
	private String storeName ;
	private HashSet<Customer> customerList = new HashSet<Customer>();
	
	public Store() {
	}
	
	public Store(String storeName) {
		setStoreName(storeName);
	}
	
	public void setStoreName(String storeName) {
		this.storeName = storeName;
	}

	public void customerGoIntoTheStoreOrLeave( String customerName , String customerIntoTheStoreOrLeave ){
		
	Customer customer = new Customer(customerName);
	customer.setCustomerQueue(customerIntoTheStoreOrLeave);
	
	if	(isCustomerNotInTheStore(customerName)) {
		setCustomerList(customer);		
	}	
		customer = getCustomer(customerName);
		
	if	(customer.isCumstomerLeave()) {
		customerList.remove(customer);
	}	
	
	}
	
	public void setCustomerList( Customer customer ) {
		customerList.add(customer);
	}
	
	public Customer getCustomer(String customerName) {
				
		for (Customer oneOfCustomer : customerList) {
			
			if ((oneOfCustomer.getCustomerName()).equals(customerName)){
			return  oneOfCustomer ;		
			}
		}
		return null;
	}
	
	public boolean isCustomerNotInTheStore( String customerName ) {
		
		if (getCustomer(customerName) == null) {
			return true ;			
		}
		else
			return false ;
	}
	
	public boolean isStoreEmpty() {
		return customerList.isEmpty();
	}
	
	public String getStoreName() {
		return storeName;
	}
	
	public HashSet<Customer> getCustomerList() {
		return customerList;
	}
	
	public String toString () {		
		return storeName ;
	}
	
}

