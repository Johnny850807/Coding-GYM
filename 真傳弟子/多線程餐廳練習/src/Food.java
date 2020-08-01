public enum Food {
    Humburger("Humburger", 13, 23, 0),
    Pizza("Pizza", 18, 30, 1),
    FrenchFries("FrenchFries", 6, 11, 2),
    ChickenNugget("ChickenNugget", 8, 13, 3),
    Chickenlegs("chickenLegs", 25, 40, 4);


    Food(String food, int second, int money, int code) {
        this.food = food;
        this.second = second;
        this.money = money;
        this.code = code;
    }

    private String food;
    private int second;
    private int money;
    private int code;


    public static Food getFood(int i) {
        for (Food food : values()) {
            if (food.getCode() == i) {
                return food;
            }
        }
        throw new FoodCantFindRuntime();
    }

    public String getFood() {
        return food;
    }

    public int getSecond() {
        return second;
    }

    public int getMoney() {
        return money;
    }

    public int getCode() {
        return code;
    }

    public String getName() {
        return food;
    }
}
