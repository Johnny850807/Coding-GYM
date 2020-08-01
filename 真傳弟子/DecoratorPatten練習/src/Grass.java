public class Grass extends Attribute {
    public Grass(Pokemon pokemon) {
        super("草", 100, pokemon);
    }

    @Override
    public int damageCount(Pokemon pokemon, int currentDamage) {
        int damage = currentDamage;

        if (pokemon instanceof Fire) {
            damage = currentDamage * 2;
            System.out.println("火對草..傷害加倍");
        } else if (pokemon instanceof Water) {
            damage = currentDamage / 2;
            System.out.println("水對草..傷害減半");
        }
        return getPokemon().damageCount(pokemon, damage);
    }
}
