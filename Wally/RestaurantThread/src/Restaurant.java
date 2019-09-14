import java.util.LinkedList;
import java.util.Random;

public class Restaurant {
    private CounterStaff counterStaff = new CounterStaff();
    private Thread restaurantOpenCountdownThread = new Thread(new CloseTimeCounter());

    public void start() {
        createAndExecuteChefThreads();  //叫廚師上班
        restaurantOpenCountdownThread.start();  //開幕營業倒數
    }

    private void createAndExecuteChefThreads() {
        Thread[] chefs = new Thread[5];
        for (int i = 0; i < chefs.length; i++) {
            chefs[i] = new Thread(new Restaurant.Chef(i));
            chefs[i].start();
        }
    }

    public boolean isOpen() {
        return restaurantOpenCountdownThread.isAlive();
    }

    public void customerComing() {
        if (restaurantOpenCountdownThread.isAlive()) {
            Delay.seconds(new Random().nextInt(5) + 2); //客人拜訪間隔時間是隨機的
            System.out.println("[新顧客] 客人登門來訪");
            new Thread(new Customer(this)).start();
        }
    }

    public class CounterStaff {
        private LinkedList<Order> customerOrders = new LinkedList<Order>();
        private int currentRevenue = 0;

        public  void addOrder(Order customerFoodOrder) {
            synchronized (customerOrders) {
                customerOrders.add(customerFoodOrder);
                customerOrders.notify(); //通知新訂單已裝入
            }
        }

        public Order waitForNextOrder() {
            synchronized (customerOrders) {
                try {
                    if (customerOrders.isEmpty())
                        customerOrders.wait();  //停止當前執行緒直到下一筆訂單出現
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                return customerOrders.pollFirst(); //回傳最先下訂的訂單
            }
        }

        public synchronized void customerCheckOut(int money) {
            currentRevenue += money;  //此函數要同步化才不會出現多執行緒同時更改一變數的問題
            System.out.println("[收入] 當前營收為：" + currentRevenue + "圓整");
        }
    }

    private class Chef implements Runnable {
        private int chefId;
        private Order customerOrder;

        public Chef(int chefId) {
            this.chefId = chefId;
        }

        public void run() {
            System.out.println("廚師" + this.chefId + "號已就位");

            do {
                customerOrder = getCounterStaff().waitForNextOrder();
                Meal customerFood = customerOrder.getFoodInfo();
                System.out.printf("[做菜] 廚師%d號開始烹飪第%d位客人的食物：%s\n",
                        chefId, customerOrder.getId(), customerFood);
                Delay.seconds(customerFood.getCookingTime());
                System.out.printf("[上菜] 廚師%d號正在上菜給第%d位客人%s\n",
                        chefId, customerOrder.getId(), customerFood);
                fillOrder(customerOrder);
            } while (isOpen());
        }

        private void fillOrder(final Order customerOrder) {
            //上菜
            synchronized (customerOrder) {
                customerOrder.notify();  //通知此訂單的Customer，讓他開始用餐
            }
        }
    }

    public int getRevenue() {
        return getCounterStaff().currentRevenue;
    }

    protected CounterStaff getCounterStaff() {
        return counterStaff;
    }

    public static void main(String[] args) {
        Restaurant restaurant = new Restaurant();
        restaurant.start();

        while (restaurant.isOpen()) {
            restaurant.customerComing();
        }

        System.out.println("餐廳打烊了");
        System.out.println("今日營收為：" + restaurant.getRevenue() + "圓整");
    }
}
