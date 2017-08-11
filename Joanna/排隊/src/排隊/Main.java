package 排隊;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	private static Scanner input= new Scanner(System.in);
	private static String[] stores;
	private static HashMap<String, ArrayList<String>> queue = new HashMap<>();
	
	public static void setStores() {
		System.out.println("輸入商店：");
		String line = input.nextLine();
		stores = line.split(" ");
	}
	
	public static void queue() {
		boolean isEnd = false;
		String line = input.nextLine();
		while (!isEnd) {	
			increaseOrDeleteCustomer(line);
			line = input.nextLine();
			if (line.equals("0")) {
				isEnd = true;
			}						
		}
	}
	
	public static void increaseOrDeleteCustomer(String line) {
		String[] customerSituation = line.split(" ");
		
		if (customerSituation[2].equals("A"))
			queue.get(customerSituation[0]).add(customerSituation[1]);
		else if (customerSituation[2].equals("R"))
			queue.get(customerSituation[0]).remove(customerSituation[1]);
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
		setStores();
		
		for (int i = 0; i < stores.length; i++) {
			ArrayList<String> customerList = new ArrayList();
			queue.put(stores[i], customerList);
		}
				
		queue();
		display();

	}
	
	
}
