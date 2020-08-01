public class Water extends Attribute {

    public Water(Pokemon pokemon) {
        super("水", 100, pokemon);
    }

    @Override
    public int damageCount(Pokemon pokemon, int currentDamage) {
        int damage = currentDamage;

        if (pokemon instanceof Fire) {
            damage = currentDamage / 2;
            System.out.println("火對水..傷害減半");
        } else if (pokemon instanceof Grass) {
            damage = currentDamage * 2;
            System.out.println("草對水..傷害加倍");
        }
        return getPokemon().damageCount(pokemon, damage);
    }
}
