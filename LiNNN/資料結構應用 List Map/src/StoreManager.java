import java.util.ArrayList;
import java.util.HashMap;
import java.util.Scanner;

public class StoreManager {
	Scanner input = new Scanner(System.in);

	private String stores;
	private String[] storeName;
	private HashMap<String, ArrayList<String>> storeMap = new HashMap<>();

	public void StoreName() {
		System.out.println("�п�J�Ҧ��Ӯa�W��: ");
		stores = input.nextLine();

		storeName = stores.split(" ");

		for (int i = 0; i < storeName.length; i++) {
			ArrayList<String> customerList = new ArrayList<>();
			storeMap.put(storeName[i], customerList);
		}
		storeStatus();
	}

	private void storeStatus() {
		goOrLeave();
		display();
	}

	private void goOrLeave() {
		while (true) {
			String s = input.nextLine();
			if (s.equals("0"))
				break;
			status(s);
		}
	}

	private void status(String s) {
		String[] status = s.split(" ");

		switch (status[2]) {
		case "A":
			storeMap.get(status[0]).add(status[1]);
			break;
		case "R":
			storeMap.get(status[0]).remove(status[1]);
			break;
		}
	}

	public void display() {
		for (int i = 0; i < storeName.length; i++) {
			System.out.println("�ө��W��: " + storeName[i]);
			if (storeMap.get(storeName[i]).isEmpty())
				System.out.println("  �S�H�ƶ�");
			else
				System.out.print("  ����: " + storeMap.get(storeName[i]));

			System.out.println();
		}
	}
}
