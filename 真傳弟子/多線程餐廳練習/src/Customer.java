public class Customer implements Runnable {

    Restaurant restaurant;

    public Customer(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            restaurant.order();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}

