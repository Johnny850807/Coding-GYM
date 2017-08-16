package 排隊;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class Main {
	private static Scanner input= new Scanner(System.in);
	private static String[] stores;
	private static HashMap<String, ArrayList<String>> queue = new HashMap<>();
	
	public static void parseStores() {
		System.out.println("輸入商店：");
		String line = input.nextLine();
		stores = line.split(" ");
	}
	
	public static void allCustomersQueue() {
		boolean isEnd = false;
		String line = input.nextLine();
		while (!isEnd) {	
			increaseOrDeleteCustomer(line);
			line = input.nextLine();
			if (line.equals("0")) 
				isEnd = true;						
		}
	}
	
	public static void increaseOrDeleteCustomer(String line) {
		String[] customerSituation = line.split(" ");
		String store = customerSituation[0];
		String customer = customerSituation[1];
		String situation = customerSituation[2];
		
		if (situation.equals("A"))
			queue.get(store).add(customer);
		else if (situation.equals("R"))
			queue.get(store).remove(customer);
	}

	public static void display() {
		for (int i = 0; i < stores.length; i++) {
			System.out.println("商店名稱：" + stores[i]);
			System.out.print("隊伍：");
			
			boolean noCustomer = true;
			
			for (int j = 0; j < queue.get(stores[i]).size(); j++)
				System.out.print(queue.get(stores[i]).get(j) + " ");
			
			if (queue.get(stores[i]).isEmpty())
				System.out.print("沒有人排隊");
			
			System.out.println();
		}
	}
	
	public static void main(String [] args) {		
		parseStores();
		
		for (int i = 0; i < stores.length; i++) {
			ArrayList<String> customerList = new ArrayList();
			queue.put(stores[i], customerList);
		}
				
		allCustomersQueue();
		display();

	}
	
}
