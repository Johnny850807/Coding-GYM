public class NormalPokemon extends Pokemon {

    public NormalPokemon() {
        super("神奇寶貝", 100);
    }

    @Override
    public int damageCount(Pokemon pokemon, int currentDamage) {
        return currentDamage;
    }
}
