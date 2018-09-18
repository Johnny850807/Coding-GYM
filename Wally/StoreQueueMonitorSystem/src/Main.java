import java.util.Scanner;
import java.util.HashSet;
import java.util.Iterator;

public class Main {

	static Scanner type = new Scanner(System.in);
	
	static HashSet<Store> storeList = new HashSet<Store>();
	
	public static void main(String[] args) {
		
		String inputStoreNameCustomerNameCustomerQueue ;
		
		createNewStore();
		
	do {	
	 
		inputStoreNameCustomerNameCustomerQueue = type.nextLine();
		if (isUserInputWordCorrect(inputStoreNameCustomerNameCustomerQueue)) {
			setCustomerToStore(inputStoreNameCustomerNameCustomerQueue);			
		}
		
	}while(!inputStoreNameCustomerNameCustomerQueue.equals("0"));
		
	printStoreSituation();
	
	System.gc();
	
	System.out.println("End");
			
	}
	
	private static void createNewStore() {
		
		String inputStoreName = type.nextLine();
		
		String oneOfStoreName[] = inputStoreName.split(" ");  
		
		for	( String storeName : oneOfStoreName ) {
			storeList.add(new Store(storeName));		
		}
	}
	
	public static boolean isUserInputWordCorrect(String inputStoreNameCustomerNameCustomerQueue) {
		
		String storeNameCustomerNameCustomerQueue [] = getStoreNameAndCustomerNameAndCustomerQueue(inputStoreNameCustomerNameCustomerQueue);
		
		if ( storeNameCustomerNameCustomerQueue.length == 3 ) {		
			String customerQuere = (storeNameCustomerNameCustomerQueue[2]).toUpperCase() ;
			if (customerQuere.equals("A")||customerQuere.equals("R")) {
				return true ;
			}
		}	
		return false ;
	}
	
	public static void setCustomerToStore(String inputStoreNameCustomerNameCustomerQueue) {
		
		String storeNameCustomerNameCustomerQueue [] = getStoreNameAndCustomerNameAndCustomerQueue(inputStoreNameCustomerNameCustomerQueue);
		
		String storeName = storeNameCustomerNameCustomerQueue[0];
		String customerName = storeNameCustomerNameCustomerQueue[1];
		String customerQuere = storeNameCustomerNameCustomerQueue[2] ;
		
		if (isStoreExist(storeName)) {		
			Store store = getStore(storeName);
			store.customerGoIntoTheStoreOrLeave(customerName,customerQuere);
		}
	}

	public static Store getStore (String storeName) {	
		
		for (Store oneOfStore : storeList) {
			
			if ((oneOfStore.getStoreName()).equals(storeName)){
				return  oneOfStore ;
			}				
		}
		return null;
	}
	
	private static String[] getStoreNameAndCustomerNameAndCustomerQueue(String inputStoreNameCustomerNameCustomerQueue) {
		return inputStoreNameCustomerNameCustomerQueue.split(" ");
	}

	public static boolean isStoreExist(String inputStoreName) {
			
		for (Store oneOfStore : storeList) {
			
			if (inputStoreName.equals(oneOfStore.getStoreName())) {
				return true ;	
			}
		}	
		return false ;
	}
	
	private static void printStoreSituation() {

		for (Store oneOfStore : storeList) {
			
				printStoreName(oneOfStore);
				
				System.out.print("隊伍 ：");
				
				if (oneOfStore.isStoreEmpty()) {
					System.out.println("人去樓空");
				}
				else {
					printCustomerQueue(oneOfStore);				
				}
		}
	}
	
	private static void printStoreName(Store storeName) {
		System.out.println("商店名稱 ： "+storeName);
	}
	
	private static void printCustomerQueue( Store storeCustomerFinder ) {
		
		for (Customer oneOfCusotmer : storeCustomerFinder.getCustomerList()) {
			System.out.print(" "+oneOfCusotmer);	
		}
		System.out.println();
	}
	
}
