public abstract class Attribute extends Pokemon {
    private Pokemon pokemon;

    public Attribute(String name, int damage, Pokemon pokemon) {
        super(name, damage);
        this.pokemon = pokemon;
    }
    public String getName() {
        return super.getName() + getPokemon().getName();
    }

    public Pokemon getPokemon() {
        return pokemon;
    }
}
