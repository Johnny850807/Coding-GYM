import java.util.ArrayDeque;

public class Restaurant {

    private static int totalMoney;
    private static Food food;
    private static ArrayDeque<Integer> orders = new ArrayDeque<>();
    private static ArrayDeque<String> ordersName = new ArrayDeque<>();

    public Restaurant() {
    }

    public void start() {
        System.out.println("餐廳開始了");
        createCustomers();
        createCook();
        countCloseShop();
    }


    public void createCook() {
        Chef chef = new Chef(this);
        Thread one = new Thread(chef, "廚師1");
        Thread two = new Thread(chef, "廚師2");
        Thread three = new Thread(chef, "廚師3");
        Thread four = new Thread(chef, "廚師4");
        Thread five = new Thread(chef, "廚師5");
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();
    }

    public void createCustomers() {
        Customer customer = new Customer(this);
        Thread one = new Thread(customer, "顧客1");
        Thread two = new Thread(customer, "顧客2");
        Thread three = new Thread(customer, "顧客3");
        Thread four = new Thread(customer, "顧客4");
        Thread five = new Thread(customer, "顧客5");
        one.start();
        two.start();
        three.start();
        four.start();
        five.start();

    }
    public void countCloseShop() {
        new Thread() {
            public void run() {
                int counted = 120*1000;
                try {
                    Thread.sleep(counted);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
               closeStore();
            }
        }.start();
    }

    public void cook() throws InterruptedException {
        while (true) {
            synchronized (Chef.class) {
                if (orders.isEmpty()) {
                   Thread.yield();
                } else {
                    String CustomerName = (String) ordersName.poll();
                    String ChefName = Thread.currentThread().getName();
                    Food Food =food.getFood((int) orders.poll());

                    System.out.println(ChefName+"開始製作"+CustomerName+"要求的"+Food.getName());
                    Chef.class.wait(Food.getSecond()*1000);
                    totalMoney +=Food.getMoney();
                    System.out.println(ChefName+"完成了"+CustomerName+"要求的"+Food.getName()+"，賺到了"+Food.getMoney()+"$");
                }
            }
        }
    }

    public void order() throws InterruptedException {
        while (true) {
            synchronized (Customer.class) {
                int selectFood = (int) (Math.random() * 5);
                int GoRestaurantTime = (int) (Math.random() * 8) + 2;
                int CookTime = food.getFood(selectFood).getSecond();
                String CostomeName = Thread.currentThread().getName();

                System.out.println(CostomeName+"客人點了一道"+food.getFood(selectFood));
                orders.offer(selectFood);
                ordersName.offer(CostomeName);
                Customer.class.wait(GoRestaurantTime * 1000);

            }
        }
    }
    public void closeStore(){
        System.out.println("餐廳打烊了，今天賺了"+ totalMoney +"元");
        System.exit(0);
    }
}

