
public class Water extends TypeDecorator {

	public Water(Pokemon pokemon) {
		super(pokemon);
	}

	@Override
	public String getDescription() {
		return "¤ô¨t" + pokemon.getDescription();
	}

}
