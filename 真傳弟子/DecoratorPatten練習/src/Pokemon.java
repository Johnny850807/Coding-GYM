public abstract class Pokemon {

    private String name;
    private int damage;

    public Pokemon(String name,int damage) {
        this.name = name;
        this.damage = damage;
    }

    public int getDamage() {
        return damage;
    }

    public String getName() {
        return name;
    }

    public abstract int damageCount(Pokemon pokemon,int currentDamage);
}
