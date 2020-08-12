package model.market;

public abstract class Product {
    private String name;
    private int money;

    public Product(String name, int money) {
        this.name = name;
        this.money = money;
    }

    public Product() {

    }

    public String getName() {
        return name;
    }

    public int getMoney() {
        return money;
    }


    @Override
    public String toString() {
        return name + " " + money + " 元 ";
    }
}
