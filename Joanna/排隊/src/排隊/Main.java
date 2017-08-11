package 排隊;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Scanner;
import java.util.Set;

public class Main {
	public static void main(String [] args) {
		
		Scanner input= new Scanner(System.in);
		boolean isEnd = false;
		
		System.out.println("輸入商店：");
		String line = input.nextLine();
		String[] stores = line.split(" ");
				
		HashMap<String, String> queue = new HashMap<>();
		
		line = input.nextLine();
		
		while (!isEnd) {
			
			String[] customerSituation = line.split(" ");
			
			if (customerSituation[2].equals("A"))
				queue.put(customerSituation[1], customerSituation[0]);
			else if (customerSituation[2].equals("R"))
				queue.remove(customerSituation[1]);
			
			line = input.nextLine();
			
			if (line.equals("0")) {
				isEnd = true;
			}						
		}
		
		for (int i = 0; i < stores.length; i++) {
			System.out.println("商店名稱：" + stores[i]);
			System.out.print("隊伍：");
			
			Set set = new HashSet();
			set =  queue.keySet();
			Iterator it = set.iterator();
			
			String customer;
			boolean noCustomer = true;
			while (it.hasNext()) {
				customer = it.next().toString();
			    if (queue.get(customer).toString().equals(stores[i])) {
			    	System.out.print(customer + " ");
			    	noCustomer = false;
			    }
			}
			
			if (noCustomer)
				System.out.print("沒有人排隊");
			
			System.out.println();
		}
		
		
	}
}
