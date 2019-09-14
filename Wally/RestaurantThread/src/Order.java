
public class Order {
    private int id;
    private Meal customerOrder;

    public Order(int id, Meal food) {
        setId(id);
        setFood(food);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return id;
    }

    public void setFood(Meal customerOrder) {
        this.customerOrder = customerOrder;
    }

    public Meal getFoodInfo() {
        return customerOrder;
    }
}
