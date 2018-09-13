import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StoreManager {
    private Scanner input = new Scanner(System.in);
    private HashMap<String, List<String>> storeHashMap = new HashMap();
    private String[] stores;

    public StoreManager() {
        createStores();
    }

    private void createStores() {
        System.out.println("Please enter the stores name: ");
        String allStore = input.nextLine();
        stores = allStore.split(" ");

        for (int i = 0; i < stores.length; i++) {
            createCustomerListAndSetupStoreHashMap(stores[i]);
        }
    }

    private void createCustomerListAndSetupStoreHashMap(String storeName) {
        List<String> customers = new ArrayList<>();
        storeHashMap.put(storeName, customers);
    }

    public void customersActivity() {
        String customerActivity;
        while (!(customerActivity = input.nextLine()).equals("0")) {
            String[] customerStatus = customerActivity.split(" ");
            if (customerStatus[2].equals("A")) {
                storeHashMap.get(customerStatus[0]).add(customerStatus[1]);
            } else
                storeHashMap.get(customerStatus[0]).remove(customerStatus[1]);
        }
    }

    public void showStoreStatus() {
        for (int i = 0; i < storeHashMap.size(); i++) {
            String storeName = stores[i];
            System.out.println("商店名稱: " + storeName);
            if (storeHashMap.get(storeName).isEmpty())
                System.out.print("隊伍: 沒有人排隊");
            else
                showStoreCustomer(storeHashMap.get(storeName));
            System.out.println();
        }
    }

    private void showStoreCustomer(List<String> customers) {
        System.out.print("隊伍: ");
        System.out.print(customers.toString());
    }

    public HashMap<String, List<String>> getStoreHashMap() {
        return storeHashMap;
    }

    public void setStoreHashMap(HashMap<String, List<String>> storeHashMap) {
        this.storeHashMap = storeHashMap;
    }
}
