import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Scanner;

public class StoresManager {
    private Scanner input = new Scanner(System.in);
    private HashMap<String, List<String>> storeHashMap = new HashMap<>();
    private String[] storesName;

    public void createStores(){
        System.out.println("請輸入所有商店名稱: ");
        String stores = input.nextLine();

        storesName = stores.split(" ");

        for (int i = 0; i < storesName.length; i++){
            List<String> customerList = new ArrayList<>();
            storeHashMap.put(storesName[i], customerList);
        }
    }

    public void showStoreStatus(){
        customerGoOrLeave();
        displayStoreStatus();
    }

    private void customerGoOrLeave() {
        while (true) {
            String str = input.nextLine();
            if (str.equals("0"))
                break;
            changeStatus(str);
        }
    }

    private void changeStatus(String str) {
        String[] status = str.split(" ");

        switch (status[2]) {
            case "A":
                storeHashMap.get(status[0]).add(status[1]);
                break;
            case "B":
                storeHashMap.get(status[0]).remove(status[1]);
                break;
        }
    }

    public void displayStoreStatus(){
        for (int i = 0; i < storesName.length; i++) {
            System.out.println("商店名稱: " + storesName[i]);
            if (storeHashMap.get(storesName[i]).isEmpty())
                System.out.println("  沒人排隊");
            else
                System.out.print("  隊伍: " + storeHashMap.get(storesName[i]).toString());

            System.out.println();
        }
    }

}
