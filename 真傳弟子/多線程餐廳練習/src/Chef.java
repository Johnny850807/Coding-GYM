public class Chef implements Runnable {

    Restaurant restaurant;

    public Chef(Restaurant restaurant) {
        this.restaurant = restaurant;
    }

    @Override
    public void run() {
        try {
            restaurant.cook();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
