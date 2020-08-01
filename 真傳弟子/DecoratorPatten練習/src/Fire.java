public class Fire extends Attribute {
    public Fire(Pokemon pokemon) {
        super("火", 100, pokemon);
    }

    @Override
    public int damageCount(Pokemon pokemon, int currentDamage) {
        int damage = currentDamage;

        if (pokemon instanceof Grass) {
            damage = currentDamage / 2;
            System.out.println("草對火..傷害減半");
        } else if (pokemon instanceof Water) {
            damage = currentDamage * 2;
            System.out.println("水對火..傷害加倍");
        }
        return getPokemon().damageCount(pokemon, damage);
    }
}
